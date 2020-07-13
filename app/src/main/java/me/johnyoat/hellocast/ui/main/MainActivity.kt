package me.johnyoat.hellocast.ui.main

import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.player_ui.view.*
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
        NavigationUI.setupWithNavController(binding.bnv, navHost.navController)

        val bottomSheetBehaviour = BottomSheetBehavior.from(binding.root.playerUI as RelativeLayout)

        bottomSheetBehaviour.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                val alpha = 1 - slideOffset
                binding.root.mainPlayerUI.alpha = slideOffset
                binding.root.miniPlayer.alpha = alpha
                binding.root.miniPlayerProgress.alpha = alpha
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_DRAGGING -> {
                        binding.bnv.visibility = View.GONE

                    }
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        binding.bnv.visibility = View.VISIBLE
                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {

                    }
                    BottomSheetBehavior.STATE_HALF_EXPANDED -> {

                    }
                    BottomSheetBehavior.STATE_HIDDEN -> {

                    }
                    BottomSheetBehavior.STATE_SETTLING -> {

                    }
                }
            }

        })


    }
}