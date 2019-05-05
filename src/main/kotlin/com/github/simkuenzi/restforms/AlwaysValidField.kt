package com.github.simkuenzi.restforms

class AlwaysValidField<T>(private val inner: FormField<T>) : FormField<T> {
    override fun name() = inner.name()
    override fun rawValue() = inner.rawValue()
    override fun value() = inner.value()
    override fun valid() = true
    override fun message() = ""
    override fun toString() = inner.toString()
}
