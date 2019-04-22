package com.github.simkuenzi.restforms

class AlwaysValidField<T>(private val inner: FormField<T>) : FormField<T> {

    override fun rawValue(): String {
        return inner.rawValue()
    }

    override fun value(): T {
        return inner.value()
    }

    override fun valid(): Boolean {
        return true
    }

    override fun message(): String {
        return ""
    }

    override fun toString(): String {
        return inner.toString()
    }
}
