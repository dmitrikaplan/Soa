package validation

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import ru.kaplaan.apiservice.web.validation.Greater
import kotlin.properties.Delegates

class GreaterValidator: ConstraintValidator<Greater, Int> {

    private var value: Int by Delegates.notNull()

    override fun initialize(constraintAnnotation: Greater) {
        this.value = constraintAnnotation.value
    }

    override fun isValid(p0: Int?, p1: ConstraintValidatorContext?): Boolean {
        if(p0 == null)
            return false

        return p0 > value
    }
}