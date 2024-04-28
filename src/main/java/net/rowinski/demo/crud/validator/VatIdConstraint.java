package net.rowinski.demo.crud.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = VatIdValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface VatIdConstraint {
    String message() default "Invalid VatID";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
