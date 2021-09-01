package com.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var recycleViewAdapter: RecycleViewAdapter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView();
        createData()
    }

    private fun initRecyclerView() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            recycleViewAdapter = RecycleViewAdapter();

            adapter = recycleViewAdapter;
        }

    }

   fun createData(){
       val items = ArrayList<RecyclerData>()
       items.add(RecyclerData("Java", "Java Desription"))
       items.add(RecyclerData("Kotlin", "Kotlin Desription"))
       items.add(RecyclerData("Flutter", "Flutter Desription"))
       items.add(RecyclerData("React Native", "React Native Desription"))
       items.add(RecyclerData("PHP", "PHP Desription"))
       items.add(RecyclerData("Go", "Go Desription"))

       recycleViewAdapter.setListData(items)
       recycleViewAdapter.notifyDataSetChanged()
   }
}