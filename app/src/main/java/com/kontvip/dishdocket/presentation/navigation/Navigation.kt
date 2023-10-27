package com.kontvip.dishdocket.presentation.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.kontvip.dishdocket.R
import com.kontvip.dishdocket.presentation.screen.main.MainFragment
import com.kontvip.dishdocket.presentation.screen.main.home.HomeFragment
import com.kontvip.dishdocket.presentation.screen.main.saved.SavedFragment

abstract class NavigationStrategy(private val screen: Screen) {

    fun navigate(fragmentManager: FragmentManager, containerId: Int) {
        fragmentManager.beginTransaction().executeTransaction(containerId).commit()
    }

    protected abstract fun FragmentTransaction.executeTransaction(
        containerId: Int
    ): FragmentTransaction

    class Add(private val screen: Screen) : NavigationStrategy(screen) {
        override fun FragmentTransaction.executeTransaction(containerId: Int): FragmentTransaction {
            return add(containerId, screen.fragment())
        }

    }

    class Replace(private val screen: Screen) : NavigationStrategy(screen) {
        override fun FragmentTransaction.executeTransaction(containerId: Int): FragmentTransaction {
            return replace(containerId, screen.fragment())
        }
    }
}

interface Screen {

    fun fragment(): Fragment

    class Home(
        private val mainFragmentNavigation: MainFragmentNavigation = MainFragmentNavigation.Empty()
    ) : NavigationStrategy {
        override fun navigate(fragmentManager: FragmentManager) {
            if (mainFragmentNavigation.canNavigate()) {
                mainFragmentNavigation.navigateToHome()
            } else {
                fragmentManager.beginTransaction().add(R.id.container, HomeFragment()).commit()
            }
        }
    }

    class Saved(
        private val mainFragmentNavigation: MainFragmentNavigation = MainFragmentNavigation.Empty()
    ) : NavigationStrategy {
        override fun navigate(fragmentManager: FragmentManager) {
            if (mainFragmentNavigation.canNavigate()) {
                mainFragmentNavigation.navigateToSaved()
            } else {
                fragmentManager.beginTransaction().add(R.id.container, SavedFragment()).commit()
            }
        }
    }
}

interface MainFragmentNavigation {
    fun navigateToHome()
    fun navigateToSaved()
    fun canNavigate(): Boolean

    class Default : MainFragmentNavigation {
        override fun navigateToHome() {
            TODO("Not yet implemented")
        }

        override fun navigateToSaved() {
            TODO("Not yet implemented")
        }

        override fun canNavigate(): Boolean = true
    }

    class Empty : MainFragmentNavigation {
        override fun navigateToHome() = Unit

        override fun navigateToSaved() = Unit

        override fun canNavigate(): Boolean = false
    }
}