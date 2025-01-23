package me.loule.models

class Light : Thing() {

    var isOn: Boolean = false

    override val type: String = "Light"
    override val description: String
        get() = "Light ($name), isOn: $isOn"
}
