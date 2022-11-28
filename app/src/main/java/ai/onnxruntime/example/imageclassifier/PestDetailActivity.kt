package ai.onnxruntime.example.imageclassifier

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PestDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_view_ency)

        val title = findViewById<TextView>(R.id.titleNamaHama)
        val scientific = findViewById<TextView>(R.id.scientificName)
        val habitat = findViewById<TextView>(R.id.habitatHama)
        val dampak = findViewById<TextView>(R.id.dampakHama)
        val kontrol = findViewById<TextView>(R.id.kontrolHama)

            title.text = intent.getStringExtra(PEST_nama)
            scientific.text = intent.getStringExtra(PEST_scientific)
            habitat.text = intent.getStringExtra(PEST_habitat)
            dampak.text = intent.getStringExtra(PEST_dampak)
            kontrol.text = intent.getStringExtra(PEST_kontrol)
    }
}

