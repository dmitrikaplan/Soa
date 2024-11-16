package validation

import jakarta.validation.Constraint
import kotlin.reflect.KClass

@MustBeDocumented
@Target(
    AnnotationTarget.FIELD,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Constraint(validatedBy = [GreaterValidator::class])
@Retention(AnnotationRetention.RUNTIME)
annotation class Greater(
    val value: Int,
    val message: String = "Must be greater than",
    val groups: Array<KClass<out Any>> = [],
    val payload: Array<KClass<out Any>> = []
)