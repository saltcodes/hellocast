package me.johnyoat.hellocast.ui.search

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.johnyoat.hellocast.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {

    private var  _binding:ActivitySearchBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}