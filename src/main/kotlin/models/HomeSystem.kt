package me.loule.models

class HomeSystem private constructor() : OnLightChanged {
    companion object {
        private var instance: HomeSystem? = null

        fun getInstance(): HomeSystem {
            if (instance == null) {
                instance = HomeSystem()
            }
            return instance!!
        }
    }

    enum class State {
        ON,
        OFF
    }

    var state = State.OFF

    private val logs = mutableListOf<String>()

    val things = mutableListOf<Thing>()
    val lights: List<Light>
        get() = things.filterIsInstance<Light>()

    fun addThing(thing: Thing) {
        things.add(thing)

        when (thing) {
            is Light -> thing.onLightChangedListener = this
        }
    }

    fun getThingByIndex(index: Int): Thing? {
        return if (index < things.size) things[index] else null
    }

    override fun onLightSwitched(light: Light) {
        val message = "light changed. ${light.description}"
        println(message)
        logs.add(message)
    }

    fun toggleLights(isOn: Boolean) {
        if (state != State.ON) {
            return
        }

        lights.forEach { it.isOn = isOn }
    }
}
