package com.github.simkuenzi.restforms

class MandatoryField(private val inner: FormField<String>, private val message: String) : FormField<String> {
    override fun name() = inner.name()
    override fun rawValue() = inner.rawValue()
    override fun value() = inner.value()
    override fun valid() = !value().isEmpty()
    override fun message() = if (!valid()) message else inner.message()
    override fun toString() = inner.toString()
}
