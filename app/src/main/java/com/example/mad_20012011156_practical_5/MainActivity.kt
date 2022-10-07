package com.example.mad_20012011156_practical_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val play =
            findViewById<FloatingActionButton>(R.id.playbutton)
        val stop =
            findViewById<FloatingActionButton>(R.id.stopbutton)
        var count = 0
        play.setOnClickListener{
            count++
            play()
            if(count%2!=0)
            {

                play.setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_stop_24))
            }
            else
            {

                play.setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_play_arrow_24))
            }
        }
        stop.setOnClickListener {
            stop()
        }
    }
    fun play() {
        Intent(applicationContext, MyService::class.java).putExtra(MyService.DATA_KEY,MyService.DATA_VALUE).apply{
            startService(this)
        }
    }
    fun stop() {
        Intent(applicationContext,
            MyService::class.java).apply {
            stopService(this)
        }
    }
}

