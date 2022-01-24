package com.example.applicationlanguage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.applicationlanguage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {

        setTheme(R.style.AppTheme)

        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val navController = this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this,navController)

//        drawerLayout = binding.drawerLayout
//        NavigationUI.setupWithNavController(binding.navView, navController)
//        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)

    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        //return NavigationUI.navigateUp(navController, drawerLayout)
        return navController.navigateUp()
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        return false
    }
}