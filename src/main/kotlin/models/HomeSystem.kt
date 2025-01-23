package me.loule.models

class HomeSystem private constructor() {
    companion object {
        private var instance: HomeSystem? = null

        fun getInstance(): HomeSystem {
            if (instance == null) {
                instance = HomeSystem()
            }
            return instance!!
        }
    }

    val things = mutableListOf<Thing>()
    val lights: List<Light> = things.filterIsInstance<Light>()

    fun getThingByIndex(index: Int): Thing? {
        return if (index < things.size) things[index] else null
    }
}
