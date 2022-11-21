package ai.onnxruntime.example.imageclassifier

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ai.onnxruntime.example.imageclassifier.R
import android.content.Intent
import ai.onnxruntime.example.imageclassifier.MainActivity
import android.view.View
import android.widget.Button

// THIS IS HOME
class Activity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        // NAVIGATE TO CLASSIFIER
        val goToClassifier = findViewById<Button>(R.id.classifierButton)
        goToClassifier.setOnClickListener { v: View? -> changeToClassifier() }

        // NAVIGATE TO ENCYCLOPEDIA
        val goToEncy = findViewById<Button>(R.id.encyButton)
        goToEncy.setOnClickListener { v: View? -> changeToEncy() }
    }

    private fun changeToClassifier() {
        val intentClassifier = Intent(this, MainActivity::class.java)
        startActivity(intentClassifier)

    }
    private fun changeToEncy() {
        val intentEncy = Intent(this, Ency::class.java)
        startActivity(intentEncy)
    }
}