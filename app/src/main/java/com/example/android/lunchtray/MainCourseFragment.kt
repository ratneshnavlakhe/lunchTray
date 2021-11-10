package com.example.android.lunchtray

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.android.lunchtray.databinding.FragmentMainCourseBinding
import com.example.android.lunchtray.model.MainCourseViewModel

class MainCourseFragment : Fragment() {

    private var binding: FragmentMainCourseBinding? = null

    private val mainCourseViewModel: MainCourseViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentMainCourseBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = mainCourseViewModel
            mainCourseFragment = this@MainCourseFragment
        }
    }

    fun goToNextScreen(price: Double) {
        mainCourseViewModel.updatePrice(price)
        findNavController().navigate(R.id.action_mainCourseFragment_to_sidedishFragment)
    }

    fun cancelOrder() {
        mainCourseViewModel.resetSideDish()
        mainCourseViewModel.resetMainCourse()
        findNavController().navigate(R.id.action_mainCourseFragment_to_startFragment)
    }
}