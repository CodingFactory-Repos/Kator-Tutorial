package me.loule

import io.ktor.server.application.*
import me.loule.models.HomeSystem
import me.loule.models.Light

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    val homeSystem = HomeSystem()

    // Add some test lights
    homeSystem.addThing(
            Light().apply {
                name = "Living Room"
                isOn = true
            }
    )
    homeSystem.addThing(
            Light().apply {
                name = "Kitchen"
                isOn = false
            }
    )

    configureTemplating()
    configureMonitoring()
    configureRouting()
}
