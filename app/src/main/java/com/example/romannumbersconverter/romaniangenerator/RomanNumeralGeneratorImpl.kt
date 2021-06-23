package com.example.romannumbersconverter.romaniangenerator

class RomanNumeralGeneratorImpl : RomanNumeralGenerator {

    companion object {
        private val mainRomanNumbers = linkedMapOf(
            "M" to 1000,
            "CM" to 900,
            "D" to 500,
            "CD" to 400,
            "C" to 100,
            "XC" to 90,
            "L" to 50,
            "XL" to 40,
            "X" to 10,
            "IX" to 9,
            "V" to 5,
            "IV" to 4,
            "I" to 1
        )
    }

    override fun generate(number: Int): String {
        var src = number.inc()
        if(src !in 1..3999) return ""
        var result = ""
        mainRomanNumbers.keys.forEach { key ->
            while (src - mainRomanNumbers[key]!! > 0) {
                result += key
                src -= mainRomanNumbers[key]!!
            }
        }
        return result
    }
}