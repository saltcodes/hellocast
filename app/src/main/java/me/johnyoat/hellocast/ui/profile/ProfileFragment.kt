package me.johnyoat.hellocast.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.transition.MaterialFadeThrough
import me.johnyoat.hellocast.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(){

    private var _binding:FragmentProfileBinding? =null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        enterTransition = MaterialFadeThrough()
        _binding = FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}