package com.example.romannumbersconverter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.example.romannumbersconverter.romaniangenerator.RomanNumeralGenerator
import com.example.romannumbersconverter.romaniangenerator.RomanNumeralGeneratorImpl

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private val romanNumeralGenerator: RomanNumeralGenerator by lazy { RomanNumeralGeneratorImpl() }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<EditText>(R.id.inputContainer).addTextChangedListener {
            it?.toString()?.let { input ->
                view.findViewById<TextView>(R.id.resultContainer).text = romanNumeralGenerator.generate(input.toInt())
            } ?: run {
                view.findViewById<TextView>(R.id.resultContainer).text = "Error"
            }
        }

    }
}