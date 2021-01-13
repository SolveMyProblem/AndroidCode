package nam.nt099.rcv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), ListClassAdapter.OnCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }
    private fun initView() {
        val listClass: MutableList<DataClass> = mutableListOf()
        for (i in 0..20) {
            val nameClass: String = "Lop A$i"
            val dataClass = DataClass(nameClass, addStudent(nameClass))
            listClass.add(dataClass)
        }
        setupAdapter(listClass)
    }

    private fun addStudent(nameClass: String): MutableList<Student> {
        var random : Random = Random()
        val listStudent: MutableList<Student> = mutableListOf()
        for (i in 0..20) {
            val student = Student("Name $i", nameClass, 18, "BG", 4 + random.nextInt(6).toFloat())
            listStudent.add(student)
        }
        return listStudent
    }

    private fun setupAdapter(listClass: MutableList<DataClass>) {
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        rcv_list_class.layoutManager = linearLayoutManager

        val listClassAdapter = ListClassAdapter(this, listClass)
        rcv_list_class.adapter = listClassAdapter
        listClassAdapter.setOnClickListener(this)

    }
    override fun onClickDataClass() {
        val intent = Intent(this, ListStudentActivity::class.java)
        startActivity(intent)
    }
}