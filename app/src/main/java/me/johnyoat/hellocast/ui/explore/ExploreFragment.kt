package me.johnyoat.hellocast.ui.explore

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.transition.MaterialFadeThrough
import me.johnyoat.hellocast.databinding.FragmentExploreBinding
import me.johnyoat.hellocast.ui.search.SearchActivity

class ExploreFragment : Fragment() {

    private var _binding: FragmentExploreBinding? = null

    private val binding get() = _binding!!
    private val viewModel: ExploreViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enterTransition = MaterialFadeThrough ()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExploreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.exploreRefreshLayout.isRefreshing = true
        viewModel.curatedList.observe(viewLifecycleOwner) { curatedList ->
            binding.exploreRefreshLayout.isRefreshing = false
                binding.curatedList.apply {
                    adapter = ExplorePodcastCuratedAdapter(curatedList,activity as AppCompatActivity)
                    setHasFixedSize(true)
                    isNestedScrollingEnabled = false
                }
        }

        binding.searchBtn.setOnClickListener {
            requireActivity().startActivity(Intent(requireActivity(),SearchActivity::class.java))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}