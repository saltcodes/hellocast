package me.johnyoat.hellocast.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import me.johnyoat.hellocast.R
import me.johnyoat.hellocast.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val navHost = supportFragmentManager.findFragmentById(R.id.fragmentHost) as NavHostFragment
        NavigationUI.setupWithNavController(binding.bnv,navHost.navController)


    }
}