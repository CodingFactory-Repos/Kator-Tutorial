package me.loule.models

import kotlin.test.*

class HomeSystemTest {

    lateinit var homeSystem: HomeSystem

    @BeforeTest
    fun setUp() {
        homeSystem = HomeSystem.getInstance()
        homeSystem.things.clear()
    }

    @Test
    fun `valid initial state`() {
        assertEquals(0, homeSystem.things.size)
    }


    @Test
    fun `if homesystem have same instances`() {
        val homeSystem2 = HomeSystem.getInstance()
        assertEquals(homeSystem, homeSystem2)
    }

    @Test
    fun `add 1 light success`() {
        homeSystem.things.add(Light())

        assertEquals(1, homeSystem.things.size)
    }

    @Test
    fun `add 2 light success`() {
        homeSystem.things.add(Light())
        homeSystem.things.add(Light())

        assertEquals(2, homeSystem.things.size)
    }

    @Test
    fun `toggle all lights ON when system off failure`() {
        homeSystem.addThing(Light())
        homeSystem.addThing(Light())

        homeSystem.toggleLights(true)

        homeSystem.lights.forEach { light ->
            assertFalse(light.isOn)
        }
    }

    @Test
    fun `toggle all lights OFF when system off failure`() {
        val light1 = Light()
        val light2 = Light()

        light1.isOn = true
        light2.isOn = true

        homeSystem.addThing(light1)
        homeSystem.addThing(light2)

        homeSystem.toggleLights(false)

        homeSystem.lights.forEach { light ->
            assertTrue(light.isOn)
        }
    }

    fun `toogle all lights ON when system on success`() {
        homeSystem.state = HomeSystem.State.ON
        val light1 = Light()
        val light2 = Light()

        light1.isOn = true
        light2.isOn = true

        homeSystem.addThing(light1)
        homeSystem.addThing(light2)

        homeSystem.toggleLights(false)

        homeSystem.lights.forEach { light ->
            assertFalse(light.isOn)
        }
    }

    @Test
    fun `toggle all lights OFF when system on success`() {
        homeSystem.state = HomeSystem.State.ON
        homeSystem.addThing(Light())
        homeSystem.addThing(Light())

        homeSystem.toggleLights(true)

        homeSystem.lights.forEach { light ->
            assertTrue(light.isOn)
        }
    }
}