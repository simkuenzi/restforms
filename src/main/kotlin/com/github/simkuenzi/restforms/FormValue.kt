package com.github.simkuenzi.restforms

import javax.ws.rs.core.MultivaluedMap

class FormValue(internal val name: String, private val rawForm: MultivaluedMap<String, String>) {
    fun rawValue() = if (rawForm.containsKey(name)) rawForm.getFirst(name) else ""
    fun name() = name
}
