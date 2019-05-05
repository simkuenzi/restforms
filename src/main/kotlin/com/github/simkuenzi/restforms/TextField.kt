package com.github.simkuenzi.restforms

class TextField(private val value: FormValue) : FormField<String> {
    override fun name() = value.name
    override fun rawValue() = value.rawValue()
    override fun value() = rawValue().trim { it <= ' ' }
    override fun valid() = true
    override fun message() = ""
    override fun toString() = rawValue()
}
