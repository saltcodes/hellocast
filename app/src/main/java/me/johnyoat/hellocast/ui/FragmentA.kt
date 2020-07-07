package me.johnyoat.hellocast.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.transition.MaterialFadeThrough
import me.johnyoat.hellocast.R
import me.johnyoat.hellocast.databinding.FragmentABinding

class FragmentA : Fragment() {

    private var _binding: FragmentABinding? = null;

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enterTransition = MaterialFadeThrough()
        binding.albumCard.setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, FragmentB(), "FRAG_B")
                .addSharedElement(binding.albumCard, "album_transition")
                .addToBackStack("FRAG_B")
                .commit()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentABinding.inflate(inflater, container, false)
        return binding.root
    }


}