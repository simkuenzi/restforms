package com.github.simkuenzi.restforms

interface FormField<T> {
    fun name(): String
    fun rawValue(): String
    fun value(): T
    fun valid(): Boolean
    fun message(): String
}