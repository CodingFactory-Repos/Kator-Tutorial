package me.loule

import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.pebble.*
import io.ktor.server.plugins.calllogging.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import me.loule.models.HomeSystem
import org.slf4j.event.*

fun Application.configureRouting(homeSystem: HomeSystem) {
    routing {
        get("/") {
            val model = mapOf("things" to homeSystem.things)

            call.respond(PebbleContent("home.html", model))
        }

        route("things") { thingById(homeSystem) }

        // Static plugin. Try to access `/static/index.html`
        staticResources("/static", "static")
    }
}
