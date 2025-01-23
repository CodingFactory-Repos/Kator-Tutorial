package me.loule

import io.ktor.http.*
import io.ktor.server.pebble.PebbleContent
import io.ktor.server.response.*
import io.ktor.server.routing.*
import me.loule.models.HomeSystem
import me.loule.models.Light

fun Route.thingById(homeSystem: HomeSystem) {
    get("{id}") {
        val id: Int = call.parameters["id"]!!.toInt()
        val thing = homeSystem.getThingByIndex(id)

        if (thing == null) {
            call.respond(HttpStatusCode.NotFound)
            return@get
        }

        if (thing !is Light) {
            call.respond(HttpStatusCode.BadRequest, "This ID does not correspond to a Light")
            return@get
        }

        val action = call.parameters["action"]
        when (action) {
            "toggle" -> {
                thing.isOn = !thing.isOn
                call.respondRedirect("/things/$id")
                return@get
            }
        }

        val model = mapOf("id" to id, "light" to thing)

        call.respond(PebbleContent("thing_light.html", model))
    }
}
