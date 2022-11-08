package com.example.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.viewModel.MainViewModel
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainVM: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainVM = ViewModelProvider(this).get(MainViewModel::class.java)
        setObserver()
        binding.button.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if(view.id == R.id.button) {
            val postId = binding.editText.text.toString().toIntOrNull()
            if (postId == null)
                Toast.makeText(this, "Não foi fornecido nenhum ID de post", Toast.LENGTH_SHORT).show()
            else
                mainVM.requestNewPost(postId)
        }
    }

    private fun setObserver() {
        mainVM.getTextView().observe(this, Observer {
            if(it != "")
                binding.textView.text = it
            else
                binding.textView.text = ""
        })
    }
}