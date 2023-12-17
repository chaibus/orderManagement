package softuni.restaurant.model.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueProductNameValidator.class)
public @interface UniqueProductName {

    String message() default "Product already exists.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}