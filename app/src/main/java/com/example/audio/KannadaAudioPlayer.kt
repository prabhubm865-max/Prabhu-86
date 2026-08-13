package com.example.audio

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioFormat
import android.media.AudioTrack
import android.speech.tts.TextToSpeech
import android.util.Log
import java.util.Locale
import kotlin.concurrent.thread
import kotlin.math.sin

class KannadaAudioPlayer(context: Context) : TextToSpeech.OnInitListener {
    private var tts: TextToSpeech? = TextToSpeech(context, this)
    private var isTtsReady = false

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = tts?.setLanguage(Locale("kn", "IN"))
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("KannadaAudioPlayer", "Kannada TTS language missing or not supported on device")
                // Fallback to default
                tts?.setLanguage(Locale.getDefault())
            } else {
                isTtsReady = true
            }
        }
    }

    fun speak(text: String) {
        if (text.isBlank()) return
        tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "KannadaTTS_${System.currentTimeMillis()}")
    }

    fun playSuccessSound() {
        thread {
            try {
                // Synthesize pleasant double-chime (C5 -> G5)
                val sampleRate = 22050
                val durationSec = 0.35
                val numSamples = (sampleRate * durationSec).toInt()
                val samples = ShortArray(numSamples)

                for (i in 0 until numSamples) {
                    val t = i.toDouble() / sampleRate
                    val freq = if (t < 0.15) 523.25 else 783.99 // C5 then G5
                    val envelope = (1.0 - t / durationSec)
                    val sample = sin(2.0 * Math.PI * freq * t) * envelope * 0.5
                    samples[i] = (sample * Short.MAX_VALUE).toInt().toShort()
                }

                val track = AudioTrack.Builder()
                    .setAudioAttributes(
                        AudioAttributes.Builder()
                            .setUsage(AudioAttributes.USAGE_GAME)
                            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                            .build()
                    )
                    .setAudioFormat(
                        AudioFormat.Builder()
                            .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
                            .setSampleRate(sampleRate)
                            .setChannelMask(AudioFormat.CHANNEL_OUT_MONO)
                            .build()
                    )
                    .setBufferSizeInBytes(samples.size * 2)
                    .setTransferMode(AudioTrack.MODE_STATIC)
                    .build()

                track.write(samples, 0, samples.size)
                track.play()
                Thread.sleep((durationSec * 1000).toLong() + 50)
                track.stop()
                track.release()
            } catch (e: Exception) {
                Log.e("KannadaAudioPlayer", "Error playing success sound: ${e.message}")
            }
        }
    }

    fun playErrorSound() {
        thread {
            try {
                val sampleRate = 22050
                val durationSec = 0.25
                val numSamples = (sampleRate * durationSec).toInt()
                val samples = ShortArray(numSamples)

                for (i in 0 until numSamples) {
                    val t = i.toDouble() / sampleRate
                    val freq = 220.0 // Low A3
                    val envelope = (1.0 - t / durationSec)
                    val sample = sin(2.0 * Math.PI * freq * t) * envelope * 0.4
                    samples[i] = (sample * Short.MAX_VALUE).toInt().toShort()
                }

                val track = AudioTrack.Builder()
                    .setAudioAttributes(
                        AudioAttributes.Builder()
                            .setUsage(AudioAttributes.USAGE_GAME)
                            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                            .build()
                    )
                    .setAudioFormat(
                        AudioFormat.Builder()
                            .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
                            .setSampleRate(sampleRate)
                            .setChannelMask(AudioFormat.CHANNEL_OUT_MONO)
                            .build()
                    )
                    .setBufferSizeInBytes(samples.size * 2)
                    .setTransferMode(AudioTrack.MODE_STATIC)
                    .build()

                track.write(samples, 0, samples.size)
                track.play()
                Thread.sleep((durationSec * 1000).toLong() + 50)
                track.stop()
                track.release()
            } catch (e: Exception) {
                Log.e("KannadaAudioPlayer", "Error playing error sound: ${e.message}")
            }
        }
    }

    fun shutdown() {
        tts?.stop()
        tts?.shutdown()
    }
}
