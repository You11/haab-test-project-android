package ru.you11.haabtestproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstCircle.angle = 120.0
        secondCircle.angle = 300.0
    }

    override fun onStart() {
        super.onStart()

        firstCircle.setOnClickListener {
            moveCircle(firstCircle)
        }

        secondCircle.setOnClickListener {
            moveCircle(secondCircle)
        }
    }

    private fun moveCircle(circle: Circle) {
        launch(Dispatchers.IO) {
            while (true) {
                runOnUiThread { circle.moveCircle(25f) }
                delay(25)
            }
        }
    }
}
