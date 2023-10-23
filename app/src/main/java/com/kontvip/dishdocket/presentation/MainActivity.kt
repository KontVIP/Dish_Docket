package com.kontvip.dishdocket.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kontvip.dishdocket.R
import dagger.hilt.android.AndroidEntryPoint

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}