package ai.onnxruntime.example.imageclassifier

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(private val context: Context, private val list: ArrayList<pest>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView){

        internal lateinit var textView2: TextView
        internal lateinit var textView3: TextView

        init {
            textView2.findViewById<View>(R.id.textView2)
            textView3.findViewById<View>(R.id.textView3)
        }
        internal fun bind(position: Int) {
            textView2.text = list[position].nama_hama
            textView3.text = list[position].nama_ilmiah
    }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_view_ency, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}