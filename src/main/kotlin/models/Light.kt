package me.loule.models

class Light : Thing() {

    var isOn: Boolean = false

    override val type: String = "Light"
    override val description: String
        get() = "Light ($name), isOn: $isOn"

    override fun toString(): String {
        return "$type $description"
    }
}
