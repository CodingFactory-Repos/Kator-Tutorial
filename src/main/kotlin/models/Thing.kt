package me.loule.models

// On ne peut pas instancier une classe abstraite
// l'objectif est de définir un type "commun"
// pour les classes enfants
abstract class Thing(var name: String = "No name", var reachable: State = State.REACHABLE) {
    enum class State {
        REACHABLE,
        UNREACHABLE
    }

    abstract val type: String
    abstract val description: String
}
