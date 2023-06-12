package ai.onnxruntime.example.imageclassifier

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import java.util.*



class RecyclerViewAdapter(private val onClick: (Pest) -> Unit, private var list: List<Pest>):
    RecyclerView.Adapter<RecyclerViewAdapter.PestViewHolder>() {


    private var originalList: List<Pest> = ArrayList(list)
    private var filteredList: List<Pest> = list

    class PestViewHolder (itemView: View, val onClick: (Pest) -> Unit) :
        RecyclerView.ViewHolder(itemView){

        private val namaHama : TextView = itemView.findViewById(R.id.textNamaHama)
        private val namaIlmiah : TextView = itemView.findViewById(R.id.textNamaIlmiah)
        private var currentPest: Pest? = null

        init {
            itemView.setOnClickListener {
                currentPest?.let {
                    onClick(it)
                }
            }
        }
        internal fun bind(pest: Pest) {
            currentPest = pest
            namaHama.text = pest.nama_hama
            namaIlmiah.text = pest.nama_ilmiah
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PestViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_ency, parent, false)
        return PestViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: PestViewHolder, position: Int) {
        val pest = list[position]
        holder.bind(pest)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    private fun filterList(filteredList: List<Pest>) {
        list = filteredList
        notifyDataSetChanged()
    }

    fun filterList(query: String?) {
        val filteredList = mutableListOf<Pest>()
        if (query.isNullOrEmpty()) {
            filteredList.addAll(originalList)
        } else {
            val filtered = originalList.filter {pestItem ->
                pestItem.nama_hama.contains(query, ignoreCase = true)
            }
            filteredList.addAll(filtered)
        }

        this.filterList(filteredList)
    }

    /*override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val query = constraint?.toString()?.toLowerCase()
                val results = FilterResults()
                results.values = if  (query.isNullOrEmpty()) {
                    list
                } else {
                    list.filter {
                        it.nama_hama.toLowerCase().contains(query) ||
                                it.nama_ilmiah.toLowerCase().contains(query)
                    }
                }
                return results
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                @Suppress("UNCHECKED_CAST")
                filteredList = results?.values as? List<Pest> ?: emptyList()
                notifyDataSetChanged()
            }
        }
    }*/


    // override fun onBindViewHolder(holder: PestViewHolder, position: Int) {
    //    val pest = list[position]
     //   holder.bind(pest)
  //  }

 //   override fun getItemCount(): Int {
  //      return list.size
  //  }
}