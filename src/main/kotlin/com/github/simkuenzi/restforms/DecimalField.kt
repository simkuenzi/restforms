package com.github.simkuenzi.restforms

import java.math.BigDecimal
import java.util.regex.Pattern

class DecimalField(private val value: FormValue) : FormField<BigDecimal> {

    override fun rawValue(): String {
        return value.rawValue()
    }

    override fun value(): BigDecimal {
        return BigDecimal(rawValue())
    }

    override fun valid(): Boolean {
        return pattern.matcher(rawValue()).matches()
    }

    override fun message(): String {
        return if (!valid()) "Invalid number" else ""
    }

    override fun toString(): String {
        return rawValue()
    }

    companion object {
        private val pattern = Pattern.compile("\\d+(\\.\\d+)?")
    }
}
