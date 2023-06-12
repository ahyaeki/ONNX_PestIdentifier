package ai.onnxruntime.example.imageclassifier

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuItemCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.ency.*
import java.util.*



const val PEST_nama = "pest_nama"
const val PEST_scientific = "pest_scientific"
const val PEST_habitat = "pest_habitat"
const val PEST_dampak = "pest_dampak"
const val PEST_kontrol = "pest_kontrol"

class PestListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ency)

        val pestJson = applicationContext.assets
            .open("pestList.json").bufferedReader().use {
                it.readText()
            }

        val pestRead = Gson().fromJson(pestJson, PestList::class.java)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val adapter = RecyclerViewAdapter({ pest -> adapterOnClick(pest) }, pestRead.pest)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val search = findViewById<SearchView>(R.id.action_search)

        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
//                adapter.filterList(query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filterList(newText)
                return true
            }

        })
    }

    private fun adapterOnClick(pest: Pest) {
        val intent = Intent(this, PestDetailActivity()::class.java)
        intent.putExtra(PEST_nama, pest.nama_hama)
        intent.putExtra(PEST_scientific, pest.nama_ilmiah)
        intent.putExtra(PEST_habitat, pest.habitat)
        intent.putExtra(PEST_dampak, pest.dampak)
        intent.putExtra(PEST_kontrol, pest.kontrol_bio)

        startActivity(intent)
    }





}
