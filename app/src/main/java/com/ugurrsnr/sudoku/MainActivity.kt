package com.ugurrsnr.sudoku

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ugurrsnr.sudoku.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startGameBtn.setOnClickListener {
            val intent = Intent(this@MainActivity,GameActivity::class.java)
            startActivity(intent)
        }
    }
}