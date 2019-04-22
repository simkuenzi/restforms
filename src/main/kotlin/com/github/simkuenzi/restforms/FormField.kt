package com.github.simkuenzi.restforms

interface FormField<T> {
    fun rawValue(): String
    fun value(): T
    fun valid(): Boolean
    fun message(): String
}