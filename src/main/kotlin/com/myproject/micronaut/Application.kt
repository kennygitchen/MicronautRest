package com.myproject.micronaut

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
            .packages("com.myproject.micronaut")
            .eagerInitConfiguration(true)
            .mainClass(Application.javaClass)
            .start()
    }
}
