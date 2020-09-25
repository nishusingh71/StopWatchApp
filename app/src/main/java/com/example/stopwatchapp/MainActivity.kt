package com.example.stopwatchapp

import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Chronometer
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var timerCount:Chronometer
    private var running:Boolean?=true
    var pauseOffset:Long?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        timerCount=findViewById(R.id.stopWatch)

    }

    fun startTimer(view: View) {
        if (!running!!){
            timerCount.base=SystemClock.elapsedRealtime()- pauseOffset!!
            timerCount.start()
            running=true
        }
    }
    fun stopTimer(view: View) {
        if (running!!){
            pauseOffset=SystemClock.elapsedRealtime()-timerCount.base
            timerCount.stop()
            running=false
        }
    }
    fun resetTimer(view: View) {
        timerCount.base=SystemClock.elapsedRealtime()
        pauseOffset=0

    }

}