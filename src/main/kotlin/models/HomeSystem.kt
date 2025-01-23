package me.loule.models

class HomeSystem {
    private val things = mutableListOf<Thing>()

    val lights: List<Light>
        get() = things.filterIsInstance<Light>()

    fun addThing(thing: Thing) {
        things.add(thing)
    }
}
