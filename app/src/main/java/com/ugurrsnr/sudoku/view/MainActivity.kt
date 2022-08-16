package com.ugurrsnr.sudoku.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ugurrsnr.sudoku.R
import com.ugurrsnr.sudoku.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //TODO: Bottom menu items will not contain text, only image. It will fixed at the end.
        /**
         * Not : Every item's id in bottom_menu.xml should be equal with fragment's ids in nav_graph
         */

        //initialize bottom navigation
        val bottomNavigation = binding.bottomNavigation

        //navController
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        //connecting navigation with bottom menu
        NavigationUI.setupWithNavController(bottomNavigation,navController)

    }
}