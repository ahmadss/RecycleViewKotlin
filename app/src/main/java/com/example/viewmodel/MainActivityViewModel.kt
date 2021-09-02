package com.example.viewmodel

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.RecyclerDataList
import com.example.network.RetroInstance
import com.example.network.RetroService
import retrofit2.Call
import retrofit2.Response

class MainActivityViewModel : ViewModel () {

    lateinit var recyclerlistData: MutableLiveData<RecyclerDataList>

    init{
        recyclerlistData = MutableLiveData()
    }

    fun getRecyclerListDataObserver() : MutableLiveData<RecyclerDataList>{
        return recyclerlistData
    }

    fun makeApiCall(){
        val retrofitinstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
        val call = retrofitinstance.getDataFromApi("atlanta")
        call.enqueue(object : retrofit2.Callback<RecyclerDataList> {
            override fun onResponse(call: Call<RecyclerDataList>, response: Response<RecyclerDataList>) {
                if(response.isSuccessful){
//                    recycleViewAdapter.setListData(response.body()?.items!!)
//                    recycleViewAdapter.notifyDataSetChanged();
                    recyclerlistData.postValue(response.body())
                } else {
                    recyclerlistData.postValue(null)
                }
            }

            override fun onFailure(call: Call<RecyclerDataList>, t: Throwable) {
//                Toast.makeText(this@MainActivity, "Error in getting data", Toast.LENGTH_LONG).show();
                recyclerlistData.postValue(null)
            }
        }
        )
    }
}