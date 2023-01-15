package com.example.project_akhir_mobile.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project_akhir_mobile.R
import com.example.project_akhir_mobile.home
import com.example.project_akhir_mobile.view.PhotoListAdapter
import com.example.project_akhir_mobile.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class test:AppCompatActivity() {
    lateinit var viewModel: ListViewModel
    val photoListAdapter = PhotoListAdapter(arrayListOf())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.fetchData()

        rv_list.apply {

            layoutManager = LinearLayoutManager(context)
            adapter = photoListAdapter
        }
        observeViewModel()
    }
    fun observeViewModel() {
        viewModel.photos.observe(this, Observer { photos ->
            photos?.let {
                photoListAdapter.updatePhotos(it)
            }
        })
    }
    fun keHome(view: View?) {
        val i = Intent(applicationContext, home::class.java)
        startActivity(i)

    }
}


