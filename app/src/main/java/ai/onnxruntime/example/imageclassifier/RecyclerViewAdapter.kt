package ai.onnxruntime.example.imageclassifier

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(private val onClick: (Pest) -> Unit, private val list: List<Pest>): RecyclerView.Adapter<RecyclerViewAdapter.PestViewHolder>() {

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
}