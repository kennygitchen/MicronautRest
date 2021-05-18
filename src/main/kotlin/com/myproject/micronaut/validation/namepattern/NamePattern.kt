package com.myproject.micronaut.validation.namepattern

import javax.validation.Constraint
import kotlin.reflect.KClass


@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [NamePatternValidator::class])
annotation class NamePattern(
    val message: String = "invalid name ({validatedValue})",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Any>> = []
)
