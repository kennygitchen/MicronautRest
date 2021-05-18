package com.myproject.micronaut.validation.notnull

import io.micronaut.aop.InterceptorBean
import io.micronaut.aop.MethodInterceptor
import io.micronaut.aop.MethodInvocationContext
import java.util.*
import javax.inject.Singleton

@Singleton
@InterceptorBean(NotNull::class)
class NotEmptyInterceptor : MethodInterceptor<Any, Any> {
    override fun intercept(context: MethodInvocationContext<Any, Any>): Any {
        context.parameterValueMap.entries.stream()
            .filter { Objects.isNull(it.value) || isBlankString(it.value) }
            .findFirst()
            .ifPresent { throw IllegalArgumentException("Null parameter for [${it.key}] is not allowed") }
        return context.proceed()
    }

    private fun isBlankString(value: Any) = value is String && value.isBlank()
}