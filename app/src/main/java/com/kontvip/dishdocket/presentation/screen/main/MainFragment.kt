package com.kontvip.dishdocket.presentation.screen.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.kontvip.dishdocket.R
import com.kontvip.dishdocket.databinding.FragmentMainBinding
import com.kontvip.dishdocket.presentation.core.BaseFragment
import com.kontvip.dishdocket.presentation.screen.main.home.HomeFragment
import com.kontvip.dishdocket.presentation.screen.main.saved.SavedFragment

class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bottomNavigationView.setOnItemSelectedListener {
            val fragment = when (it.itemId) {
                R.id.home_item -> HomeFragment()
                R.id.saved_item -> SavedFragment()
                else -> return@setOnItemSelectedListener false
            }
            childFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
            return@setOnItemSelectedListener true
        }
    }

}