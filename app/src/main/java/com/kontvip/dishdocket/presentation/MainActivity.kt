package com.kontvip.dishdocket.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kontvip.dishdocket.R
import com.kontvip.dishdocket.databinding.ActivityMainBinding
import com.kontvip.dishdocket.presentation.screen.main.MainFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment())
                .commit()

            //todo
            viewModel.navigate(NavigationStrategy.Home())
        }

        //todo
        viewModel.observeNavigation { navigation ->
            navigation.navigate(supportFragmentManager)
        }
    }
}