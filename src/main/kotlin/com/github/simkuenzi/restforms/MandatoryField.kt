package com.github.simkuenzi.restforms

class MandatoryField(private val inner: FormField<String>) : FormField<String> {

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
        return if (!valid()) "Provide some text here" else ""
    }

    override fun toString(): String {
        return rawValue()
    }
}
