package com.github.simkuenzi.restforms

import java.math.BigDecimal
import java.util.regex.Pattern

class DecimalField(private val value: FormValue, private val message: String) : FormField<BigDecimal> {
    override fun name() = value.name
    override fun rawValue() = value.rawValue()
    override fun value() = BigDecimal(rawValue())
    override fun valid() = pattern.matcher(rawValue()).matches()
    override fun message() = if (!valid()) message else ""
    override fun toString() = rawValue()
    companion object {
        private val pattern = Pattern.compile("\\d+(\\.\\d+)?")
    }
}
