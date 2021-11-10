package com.example.android.lunchtray

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.android.lunchtray.databinding.FragmentSidedishBinding
import com.example.android.lunchtray.model.MainCourseViewModel

class SidedishFragment : Fragment() {

    private var binding: FragmentSidedishBinding? = null

    private val mainCourseViewModel: MainCourseViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentSidedishBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = mainCourseViewModel
            sideDishFragment = this@SidedishFragment
        }
    }

    fun goToNextScreen(price: Double) {
        mainCourseViewModel.updatePrice(price)
        findNavController().navigate(R.id.action_sidedishFragment_to_summaryFragment)
    }

    fun cancelOrder() {
        mainCourseViewModel.resetSideDish()
        mainCourseViewModel.resetMainCourse()
        findNavController().navigate(R.id.action_sidedishFragment_to_startFragment)
    }
}