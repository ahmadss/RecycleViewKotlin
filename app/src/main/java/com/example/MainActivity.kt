package com.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.network.RetroInstance
import com.example.network.RetroService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
//       val items = ArrayList<RecyclerData>()
//       items.add(RecyclerData("Java", "Java Desription"))
//       items.add(RecyclerData("Kotlin", "Kotlin Desription"))
//       items.add(RecyclerData("Flutter", "Flutter Desription"))
//       items.add(RecyclerData("React Native", "React Native Desription"))
//       items.add(RecyclerData("PHP", "PHP Desription"))
//       items.add(RecyclerData("Go", "Go Desription"))

//       recycleViewAdapter.setListData(items)
//       recycleViewAdapter.notifyDataSetChanged()

       val retrofitinstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
       val call = retrofitinstance.getDataFromApi("jakarta")
       call.enqueue(object : Callback<RecyclerDataList>{
           override fun onResponse(call: Call<RecyclerDataList>, response: Response<RecyclerDataList>) {
               if(response.isSuccessful){
                   recycleViewAdapter.setListData(response.body()?.items!!)
                   recycleViewAdapter.notifyDataSetChanged();
               }
           }

           override fun onFailure(call: Call<RecyclerDataList>, t: Throwable) {
               Toast.makeText(this@MainActivity, "Error in getting data", Toast.LENGTH_LONG).show();
           }
       }
       )
   }
}