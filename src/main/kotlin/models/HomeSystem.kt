package me.loule.models

class HomeSystem {
    val things = mutableListOf<Thing>()
    val lights: List<Light> = things.filterIsInstance<Light>()
}
