package ai.onnxruntime.example.imageclassifier

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class Ency : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ency)

    val pestJson = applicationContext.assets
        .open("pestList.json").bufferedReader().use {
            it.readText()
        }

        val pestRead = Gson().fromJson(pestJson, PestList::class.java)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val adapter = RecyclerViewAdapter(this, pestRead.pest);
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }







}