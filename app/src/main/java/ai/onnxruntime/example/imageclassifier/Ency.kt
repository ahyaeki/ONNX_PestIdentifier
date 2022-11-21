package ai.onnxruntime.example.imageclassifier

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class Ency : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ency)

    val pestJson = applicationContext.assets
        .open("pestList").bufferedReader().use {
            it.readText()
        }

        val pestRead = Gson().fromJson(pestJson, PestList::class.java)
        val data = arrayListOf<pest>()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val adapter = RecyclerViewAdapter(this, data);
        recyclerView.layoutManager = GridLayoutManager(this, 102)
        recyclerView.adapter = adapter
    }







}