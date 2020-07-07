package me.johnyoat.hellocast.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityOptionsCompat
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback
import kotlinx.android.synthetic.main.activity_a.*
import me.johnyoat.hellocast.R

class ActivityA : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        setExitSharedElementCallback(MaterialContainerTransformSharedElementCallback())
        window.sharedElementsUseOverlay = false
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        albumCard.setOnClickListener {
            val intent = Intent(this,ActivityB::class.java)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this,it,"album_transition")
            startActivity(intent,options.toBundle())
        }
    }
}