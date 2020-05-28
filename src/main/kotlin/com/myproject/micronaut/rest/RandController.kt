package com.myproject.micronaut.rest

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.system.measureNanoTime


/**
 * This is a simple Rest endpoint that returns
 * a random number
 */
@Controller("/rand")
class RandController {
    companion object {
        val LOG: Logger = LoggerFactory.getLogger(RandController::class.java)
    }

    @Get("/")
    @Produces(MediaType.TEXT_PLAIN)
    fun rand(): Double {
        var random = 0.0
        LOG.info("Request Received")
        val taken = measureNanoTime {
            random = genNum()
        }
        LOG.info("Request Finished, taken {}(ns)", taken)
        return random
    }

    private fun genNum(): Double {
        var num = 0.0
        for (n in 1..1000) {
            num += Math.random()
        }
        return num
    }
}