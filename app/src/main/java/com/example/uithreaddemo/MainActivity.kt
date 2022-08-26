package com.example.uithreaddemo

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
//Main Thread can only change view properties
class MainActivity : AppCompatActivity() {
    var runLoop = false
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickStart(view: View){
        runLoop = true

        val view = findViewById<TextView>(R.id.textView)

            while (runLoop){
            Log.e(TAG,"New Thread invoked with id ${Thread.currentThread().id}:, count - $count")

            count++
                break
            }
        //THread accessibility error here!!
            view.text = "text changed by ${Thread.currentThread().id}!!!"

    }

    fun onClickStop(view: View) {
        Thread{
            runLoop = false


        Log.e(TAG,"STOPPPEDDDD $runLoop")
        val view = findViewById<TextView>(R.id.textView)
        view.text = "text changed by ${Thread.currentThread().id}"
        }.start()


    }

}