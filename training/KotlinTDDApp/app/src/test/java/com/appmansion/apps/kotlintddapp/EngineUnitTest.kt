package com.appmansion.apps.kotlintddapp

import org.junit.Test

import org.junit.Assert.*

class EngineUnitTest {

    private val engine = Engine(2000,190,20,false)

    @Test
    fun engineTurnsOn() {
        engine.turnOn()
        assertEquals(true,engine.isTurnedOn)
        assertEquals(95,engine.temperature)
    }

    @Test
    fun engineTurnsOff() {
        engine.turnOff()
        assertEquals(false,engine.isTurnedOn)
        assertEquals(20,engine.temperature)
    }
}