package com.github.simkuenzi.restforms

class TextField(private val value: FormValue) : FormField<String> {

    override fun rawValue(): String {
        return value.rawValue()
    }

    override fun value(): String {
        return rawValue().trim { it <= ' ' }
    }

    override fun valid(): Boolean {
        return true
    }

    override fun message(): String {
        return ""
    }

    override fun toString(): String {
        return rawValue()
    }
}
