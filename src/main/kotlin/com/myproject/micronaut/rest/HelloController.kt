package com.myproject.micronaut.rest

import com.myproject.micronaut.validation.namepattern.NamePattern
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Produces
import org.slf4j.Logger
import org.slf4j.LoggerFactory


/**
 * This is a simple Rest endpoint that returns
 * hello message
 */
@Controller("/hello")
open class HelloController {
    companion object {
        val LOG: Logger = LoggerFactory.getLogger(HelloController::class.java)
    }

    @Get("/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    open fun hello(@PathVariable name: String): String {
        LOG.info("Request received with name [$name]")
        return sayHello(name)
    }

    open fun sayHello(@NamePattern name: String) = "hello $name!!"
}