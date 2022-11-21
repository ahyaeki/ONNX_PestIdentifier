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
        val changeActivityBTN = findViewById<Button>(R.id.classifierButton)
        changeActivityBTN.setOnClickListener { v: View? -> changeActivity() }
    }

    private fun changeActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}