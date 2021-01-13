    package nam.nt099.rcv

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.items_layout.view.*

class ListClassAdapter(val context: Context, private val listStudent: MutableList<DataClass>) :
    RecyclerView.Adapter<ListClassAdapter.ClassViewHolder>() {
    private var onCallback: OnCallback? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.items_layout, parent, false)
        return ClassViewHolder(view)
    }

    override fun onBindViewHolder(holder: ClassViewHolder, position: Int) {
        val dataClass = listStudent[position]
        holder.bindView(dataClass)
    }

    override fun getItemCount(): Int {

        return listStudent.size
    }

    inner class ClassViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(dataClass: DataClass) {
            itemView.tv_title.text = dataClass.name
            itemView.cv_class.setOnClickListener {
                onCallback?.onClickDataClass()
            }
        }
    }

    fun setOnClickListener(onCallback: OnCallback) {
        this.onCallback = onCallback
    }

    interface OnCallback {
        fun onClickDataClass()
    }
}