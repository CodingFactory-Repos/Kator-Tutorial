package me.loule.models

import kotlin.test.*

class LightTest {
    lateinit var light: Light

    @BeforeTest
    fun setUp() {
        light = Light()
        light.name = "Test Light"
    }

    @Test
    fun `valid initial state`() {
        assertEquals(Thing.State.REACHABLE, light.reachable)
        assertFalse(light.isOn)
    }

    @Test
    fun `set light on success`() {
        light.isOn = true
        assertTrue(light.isOn)
    }

    @Test
    fun `set light isOn when unreachable failure`() {
        light.reachable = Thing.State.UNREACHABLE

        light.isOn = true

        assertFalse(light.isOn)
    }
}