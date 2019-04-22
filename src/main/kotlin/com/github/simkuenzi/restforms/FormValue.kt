package com.github.simkuenzi.restforms

import javax.ws.rs.core.MultivaluedMap

class FormValue(private val name: String, private val rawForm: MultivaluedMap<String, String>) {

    internal fun rawValue(): String {
        return if (rawForm.containsKey(name)) rawForm.getFirst(name) else ""
    }
}
