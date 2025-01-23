package me.loule.models

class HomeSystem {
    val things = mutableListOf<Thing>()
    val lights: List<Light> = things.filterIsInstance<Light>()

    fun getThingByIndex(index: Int): Thing? {
        return if (index < things.size) things[index] else null
    }
}
