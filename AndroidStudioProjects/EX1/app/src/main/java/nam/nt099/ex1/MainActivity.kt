package nam.nt099.ex1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NameAdapter.OnCallBack {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        val listTitle : MutableList<String> = mutableListOf()
        val listDesc : MutableList<String> = mutableListOf()
        for (i in 0..20){
            val title = "Title $i"
            val desc = "Description $i"
            listDesc.add(desc)
            listTitle.add(title)
        }
        setUpAdapter(listTitle, listDesc)
    }

    private fun setUpAdapter(listTitle: MutableList<String>, listDesc: MutableList<String>) {
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        rcv_items.layoutManager = linearLayoutManager

        val adapter = NameAdapter(this, listTitle, listDesc)
        adapter.setOnClickListener(this)
        rcv_items.adapter = adapter

    }

    override fun onClick() {
        Toast.makeText(this, "click aaa", Toast.LENGTH_SHORT).show()
    }

}