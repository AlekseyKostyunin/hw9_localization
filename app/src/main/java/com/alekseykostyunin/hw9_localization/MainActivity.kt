package com.alekseykostyunin.hw9_localization

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alekseykostyunin.hw9_localization.databinding.ActivityMainBinding
import com.google.android.material.datepicker.MaterialDatePicker

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}