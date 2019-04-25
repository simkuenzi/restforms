package com.github.simkuenzi.restforms

class MandatoryField(private val inner: FormField<String>, private val message: String) : FormField<String> {

    override fun rawValue(): String {
        return inner.rawValue()
    }

    override fun value(): String {
        return inner.value()
    }

    override fun valid(): Boolean {
        return !value().isEmpty()
    }

    override fun message(): String {
        return if (!valid()) message else ""
    }

    override fun toString(): String {
        return rawValue()
    }
}
