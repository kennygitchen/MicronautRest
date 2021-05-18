package com.myproject.micronaut.validation.namepattern

import io.micronaut.core.annotation.AnnotationValue
import io.micronaut.validation.validator.constraints.ConstraintValidator
import io.micronaut.validation.validator.constraints.ConstraintValidatorContext


class NamePatternValidator : ConstraintValidator<NamePattern, CharSequence> {
    override fun isValid(
        value: CharSequence?, annotationMetadata: AnnotationValue<NamePattern>, context: ConstraintValidatorContext
    ): Boolean = value != null && value.length > 1

}