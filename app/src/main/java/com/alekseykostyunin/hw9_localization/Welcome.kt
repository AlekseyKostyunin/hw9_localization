package com.alekseykostyunin.hw9_localization

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alekseykostyunin.hw9_localization.databinding.FragmentWelcomeBinding
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.snackbar.Snackbar
import java.util.Calendar

class Welcome : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding
    val calendar = Calendar.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWelcomeBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.welcome.setOnClickListener {
            findNavController().navigate(R.id.action_welcome_to_poll)
        }

        binding.openDate.setOnClickListener {
            val date = MaterialDatePicker.Builder.datePicker()
                .setTitleText(resources.getString(R.string.title_date_picker))
                .build()

            date.addOnPositiveButtonClickListener { timeInMillis: Long ->
                calendar.timeInMillis = timeInMillis
                val day = calendar.get(Calendar.DAY_OF_MONTH)
                val month = calendar.get(Calendar.MONTH) + 1
                val year  = calendar.get(Calendar.YEAR)
                Snackbar.make(it, "Дата рождения: $day.$month.$year", Snackbar.LENGTH_LONG)
                    .show()
            }
            date.show(parentFragmentManager, "DatePicker")
        }
    }
}