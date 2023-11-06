package com.example.alldayfit.exercisestatus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.alldayfit.R
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.alldayfit.databinding.ExerciseStatusFragmentBinding



class ExerciseStatusFragment : Fragment() {

    private var _binding: ExerciseStatusFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private lateinit var viewModel: BodyStatusViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ExerciseStatusFragmentBinding.inflate(inflater, container, false)
        initView()

        viewModel = ViewModelProvider(requireActivity()).get(BodyStatusViewModel::class.java)


        viewModel.bodyStatus.observe(viewLifecycleOwner) { bodyStatus ->
            // 라이브 데이터 변경 감지
            binding.statusWeightView.text = "${bodyStatus.weight}"
            binding.statusHeightView.text = " ${bodyStatus.height}"
        }


        binding.fixed.setOnClickListener {
                val dialog = BodyStatusDialog()
                dialog.show(requireActivity().supportFragmentManager, "ExerciseStatusDailyEditDialog")
            }

        return binding.root
    }

    private fun initView() = with(binding) {
        // 수정 버튼 클릭 시 해당 dialog 뜨위기
        fixed.setOnClickListener {
            showDialog(R.id.action_exerciseStatusFragment_to_exerciseStatusDailyEditDialog)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    /* main_graph의 action을 활용해서 dialog 띄우기 */
    private fun showDialog(action : Int) {
        findNavController().navigate(action)
    }

    companion object {
        fun newInstance() = ExerciseStatusFragment()
    }
}