package com.myproject.micronaut.rest

import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.BehaviorSpec
import io.micronaut.test.annotation.MicronautTest

@MicronautTest
class RandControllerTest(
        private val restController: RandController
) : BehaviorSpec({
    given("the restContrller") {
        `when`("the service is called with /rand") {
            val result = restController.rand()
            then("there should no error/excepton") {
                result shouldBe 1000
            }
        }
    }
})