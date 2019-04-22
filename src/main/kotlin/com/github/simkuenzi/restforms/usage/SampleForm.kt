package com.github.simkuenzi.restforms.usage

import com.github.simkuenzi.restforms.*
import java.math.BigDecimal
import java.util.*
import java.util.stream.Stream
import javax.ws.rs.core.MultivaluedHashMap
import javax.ws.rs.core.MultivaluedMap

class SampleForm private constructor(
    val title: FormField<String>,
    val description: FormField<String>,
    val price: FormField<BigDecimal>
) {

    @JvmOverloads
    internal constructor(rawForm: MultivaluedMap<String, String> = MultivaluedHashMap()) : this(
        MandatoryField(TextField(FormValue("title", rawForm))),
        TextField(FormValue("description", rawForm)),
        DecimalField(FormValue("price", rawForm))
    )

    internal fun noValidation(): SampleForm {
        return SampleForm(
            AlwaysValidField(title),
            AlwaysValidField(description),
            AlwaysValidField(price)
        )
    }

    fun valid(): Boolean {
        return Stream.of(title, description, price).allMatch { x -> x.valid() }
    }

    fun message(): String {
        return if (valid()) "" else "Invalid input"
    }
}

fun main(args: Array<String>) {
    val emptyForm = SampleForm()
    println("An empty form")
    println("Raw value of price: " + emptyForm.price)
    println("Message of price: " + emptyForm.price.message())
    println("Valid: " + emptyForm.valid())
    println("Message of form: " + emptyForm.message())
    println()

    val rawInvalidForm = MultivaluedHashMap<String, String>()
    rawInvalidForm.put("price", Collections.singletonList("invalid"));
    val invalidForm = SampleForm(rawInvalidForm)
    println("An invalid form")
    println("Raw value of price: " + invalidForm.price)
    println("Message of price: " + invalidForm.price.message())
    println("Valid: " + invalidForm.valid())
    println("Message of form: " + invalidForm.message())
    println("Valid (validation turned off): " + invalidForm.noValidation().valid())
    println()

    val rawValidForm = MultivaluedHashMap<String, String>()
    rawValidForm.put("title", Collections.singletonList("Title"));
    rawValidForm.put("price", Collections.singletonList("012.3"));
    val validForm = SampleForm(rawValidForm)
    println("A valid form")
    println("Raw value of price: " + validForm.price)
    println("Value of price: " + validForm.price.value())
    println("Message of price: " + validForm.price.message())
    println("Valid: " + validForm.valid())
    println("Message of form: " + validForm.message())
    println()
}

