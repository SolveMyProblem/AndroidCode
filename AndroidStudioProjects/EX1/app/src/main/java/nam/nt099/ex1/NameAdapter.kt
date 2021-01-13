package nam.nt099.ex1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.items_layout.view.*

class NameAdapter(var context: Context, var listTitle: MutableList<String>, var listDesc: MutableList<String> ):
    RecyclerView.Adapter<NameAdapter.NameViewHolder>(){
    var onCallBack : OnCallBack? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameAdapter.NameViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.items_layout, parent, false)
        return NameViewHolder(v)
    }

    override fun onBindViewHolder(holder: NameAdapter.NameViewHolder, position: Int) {
        val title = listTitle[position]
        val desc = listDesc[position]
        holder.bindView(title, desc)
    }

    override fun getItemCount(): Int {
        return listTitle.size
    }
    inner class NameViewHolder(var itemView: View): RecyclerView.ViewHolder(itemView){
        fun bindView(title: String, desc: String){
            itemView.tv_titles.text = title
            itemView.tv_desc.text = desc
            itemView.ct_click.setOnClickListener {
                onCallBack?.onClick()
            }

        }
    }
     fun setOnClickListener(onCallBack: OnCallBack){
            this.onCallBack = onCallBack
     }

    interface OnCallBack{
        fun onClick()
    }

}