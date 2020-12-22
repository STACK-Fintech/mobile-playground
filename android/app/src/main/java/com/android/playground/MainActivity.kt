package com.android.playground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val navHost by lazy {
        supportFragmentManager.findFragmentById(R.id.nav_container) as NavHostFragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        with(navHost.navController) {
            val appBarConfiguration = AppBarConfiguration(this.graph)
            toolbar.setupWithNavController(this, appBarConfiguration)
        }
    }
}
