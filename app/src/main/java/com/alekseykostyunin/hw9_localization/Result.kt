package com.alekseykostyunin.hw9_localization

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alekseykostyunin.hw9_localization.Poll.Companion.TAG_RESULT
import com.alekseykostyunin.hw9_localization.databinding.FragmentResultBinding

class Result : Fragment() {

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val result = arguments?.getInt(TAG_RESULT).toString()
        binding.textResult.text = result + " из 3"
        binding.toWelcome.setOnClickListener {
            findNavController().navigate(R.id.action_result_to_welcome)
        }

        ObjectAnimator.ofFloat(binding.textResult, View.TRANSLATION_Y, 200f, 0f).apply {
            duration = 3000
        }.start()

        ObjectAnimator.ofFloat(binding.textResult, View.ALPHA, 0f, 1f).apply {
            duration = 6000
        }.start()

        ObjectAnimator.ofFloat(binding.toWelcome, View.TRANSLATION_Y, 200f, 0f).apply {
            duration = 3000
        }.start()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}