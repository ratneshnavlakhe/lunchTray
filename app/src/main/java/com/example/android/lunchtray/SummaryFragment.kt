package com.example.android.lunchtray

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.android.lunchtray.databinding.FragmentSummaryBinding
import com.example.android.lunchtray.model.MainCourseViewModel

class SummaryFragment : Fragment() {
    private var binding: FragmentSummaryBinding? = null

    private val mainCourseViewModel: MainCourseViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentSummaryBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = mainCourseViewModel
            summaryFragment = this@SummaryFragment
        }
    }

    fun showToast() {
        Toast.makeText(context, "Total order is $${mainCourseViewModel.subtotal.value}", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_summaryFragment_to_startFragment)
    }

    fun cancelOrder() {
        mainCourseViewModel.resetSideDish()
        mainCourseViewModel.resetMainCourse()
        findNavController().navigate(R.id.action_summaryFragment_to_startFragment)
    }
}