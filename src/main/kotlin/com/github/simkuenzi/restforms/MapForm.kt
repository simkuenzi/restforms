package com.github.simkuenzi.restforms

class MapForm(private val message: String, vararg val fields: FormField<*>) : Map<String, Any> {
    override val entries: Set<Map.Entry<String, Any>>
        get() = map().entries
    override val keys: Set<String>
        get() = map().keys
    override val size: Int
        get() = map().size
    override val values: Collection<Any>
        get() = map().values

    override fun containsKey(key: String): Boolean = map().containsKey(key)
    override fun containsValue(value: Any): Boolean = map().containsValue(value)
    override fun get(key: String): Any? = map().get(key)
    override fun isEmpty(): Boolean = map().isEmpty()

    private fun map(): Map<String, Any> {
        val map = HashMap<String, Any>()
        fields.forEach { map.put(it.name(), it) }
        map.put("message", message())
        map.put("valid", valid())
        return map
    }

    fun valid() = fields.all { it.valid() }
    private fun message() = if (valid()) "" else message
    fun nonValidating() = MapForm(message, *fields.map { AlwaysValidField(it) }.toTypedArray())
}