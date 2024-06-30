package com.alekseykostyunin.hw9_localization

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alekseykostyunin.hw9_localization.databinding.FragmentPollBinding

class Poll : Fragment() {

    private var _binding: FragmentPollBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPollBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        animation()

        binding.toAnswer.setOnClickListener {
            val result = getResultAnswer()
            val bundle = Bundle()
            bundle.putInt(TAG_RESULT, result)
            findNavController().navigate(R.id.action_poll_to_result, bundle)
        }
        binding.toBack.setOnClickListener {
            findNavController().navigate(R.id.action_poll_to_welcome)
        }
    }

    private fun getResultAnswer(): Int {
        var result = 0
        if (binding.radioGroup.checkedRadioButtonId == binding.radioButtonTree.id) result++
        if (binding.radioGroup2.checkedRadioButtonId == binding.radioButtonTwo2.id) result++
        if (binding.radioGroup3.checkedRadioButtonId == binding.radioButtonTwo3.id) result++
        Log.i("TEST_result", result.toString())
        return result
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG_RESULT = "TAG_RESULT"
    }

    private fun animation() {
        binding.question1.alpha = 0f
        binding.radioGroup.alpha = 0f

        binding.toBack.alpha = 0f
        binding.toAnswer.alpha = 0f

        binding.question1.animate().apply {
            duration = 2000
            alpha(1f)
        }.start()

        binding.radioGroup.animate().apply {
            duration = 2500
            alpha(1f)
        }.start()

        binding.toBack.animate().apply {
            duration = 5000
            alpha(1f)
        }.start()

        binding.toAnswer.animate().apply {
            duration = 5500
            alpha(1f)
        }.start()
    }

}