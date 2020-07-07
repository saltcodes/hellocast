package me.johnyoat.hellocast.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.johnyoat.hellocast.R

class ActivityFragmentTransform : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_activity_transform)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, FragmentA())
            .commit()
    }
}