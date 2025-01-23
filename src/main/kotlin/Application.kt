package me.loule

import io.ktor.server.application.*
import me.loule.models.HomeSystem
import me.loule.models.Light

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    val homeSystem = HomeSystem()

    val light = Light()
    light.name = "Living room"
    light.isOn = true
    homeSystem.things.add(light)

    homeSystem.things.add(
            Light().apply {
                name = "Kitchen"
                isOn = false
            }
    )

    configureTemplating()
    configureMonitoring()
    configureRouting(homeSystem)
}
