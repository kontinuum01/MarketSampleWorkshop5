package ru.gb.android.workshop5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.gb.android.workshop5.marketsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}