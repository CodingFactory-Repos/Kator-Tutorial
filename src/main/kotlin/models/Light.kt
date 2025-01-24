package me.loule.models

interface OnLightChanged {
    fun onLightSwitched(light: Light)
}

class Light : Thing() {
    var onLightChangedListener: OnLightChanged? = null

    var isOn: Boolean = false
        set(value) {
            if (reachable != State.REACHABLE) {
                return
            }

            field = value
            onLightChangedListener?.onLightSwitched(this)
        }

    override val type: String = "Light"
    override val description: String
        get() = "Light ($name), isOn: $isOn"

    override fun toString(): String {
        return "$type $description"
    }
}
