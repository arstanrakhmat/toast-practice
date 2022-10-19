package com.example.custrombuttonsandtoasts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var ll: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ll = findViewById(R.id.linearLayout)

        ll.setOnClickListener {
//            toastLoading("Hello World")
//            toastSuccess("Sgeiiin")
//            toastError("Something went wrong")
            toastTimer("Hey", "")
        }

    }

    private fun toastLoading(text: String) {
        val inflater = layoutInflater
        val layout: View =
            inflater.inflate(R.layout.loading_toast, findViewById(R.id.loading_wrapper))

        Toast(this).apply {
            val textMessage: TextView = layout.findViewById(R.id.toastLoadingMessage)

            textMessage.text = text
            duration = Toast.LENGTH_SHORT
            setGravity(Gravity.CENTER, 0, 0)
            view = layout
        }.show()
    }

    private fun toastSuccess(text: String) {
        val inflater = layoutInflater
        val layout: View =
            inflater.inflate(R.layout.success_toast, findViewById(R.id.success_wrapper))

        Toast(this).apply {
            val textMessage: TextView = layout.findViewById(R.id.toastSuccessMessage)

            textMessage.text = text
            duration = Toast.LENGTH_SHORT
            setGravity(Gravity.BOTTOM, 0, 0)
            view = layout
        }.show()
    }

    private fun toastError(text: String) {
        val inflater = layoutInflater
        val layout: View =
            inflater.inflate(R.layout.error_toast, findViewById(R.id.error_wrapper))

        Toast(this).apply {
            val textMessage: TextView = layout.findViewById(R.id.toastErrorMessage)

            textMessage.text = text
            duration = Toast.LENGTH_SHORT
            setGravity(Gravity.TOP, 0, 0)
            view = layout
        }.show()
    }

    private fun toastTimer(text: String, btnText: String) {
        val inflater = layoutInflater
        val layout: View =
            inflater.inflate(R.layout.timer_toast, findViewById(R.id.timer_wrapper))

        Toast(this).apply {
            val textMessage: TextView = layout.findViewById(R.id.toastTimerMessage)
            val textBtn: TextView = layout.findViewById(R.id.toastTimerButton)
            val timerText: TextView = layout.findViewById(R.id.toastTimer)

            object : CountDownTimer(5000, 1000) {
                override fun onTick(p0: Long) {
                    timerText.text = "$p0"
                }

                override fun onFinish() {
                    timerText.text = "0"
                }
            }.start()

            textMessage.text = text
            textBtn.text = btnText
            duration = Toast.LENGTH_LONG
            setGravity(Gravity.TOP, 0, 0)
            view = layout
        }.show()
    }
}