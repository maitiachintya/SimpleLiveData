package com.example.simplelivedataexample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.simplelivedataexample.R
import com.example.simplelivedataexample.databinding.ActivityMainBinding
import com.example.simplelivedataexample.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MainViewModel :: class.java)
        binding.btnOnClick.setOnClickListener(View.OnClickListener {
            viewModel.updateUser(binding.userNameEditText.text.toString(), binding.userAgeEditText.text.toString().toInt())
        })
        viewModel.user.observe(this, Observer {
            binding.tvwInfoUsername.text = it.name
            binding.tvwInfoUserAge.text = it.age.toString()
        })
    }
}