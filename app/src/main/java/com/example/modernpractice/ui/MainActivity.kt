package com.example.modernpractice.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.modernpractice.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // setup the back-button at the top of the view page or screen
        val navController = this.findNavController(R.id.myNavHostFragment1)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    //  setup back-button at the top of the view page or screen
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment1)
        return navController.navigateUp()
    }

}
