package me.johnyoat.hellocast.ui.search

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.core.widget.addTextChangedListener
import me.johnyoat.hellocast.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {

    private var _binding: ActivitySearchBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.clearBtn.isGone = true

        binding.clearBtn.setOnClickListener {
            binding.searchText.setText("")
        }

        binding.backBtn.setOnClickListener {
            finish()
        }

        binding.searchText.addTextChangedListener {
            binding.clearBtn.isGone = it?.length!! <= 3
        }
    }
}