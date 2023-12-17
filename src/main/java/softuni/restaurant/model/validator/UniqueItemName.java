package softuni.restaurant.model.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueItemNameValidator.class)
public @interface UniqueItemName {
    String message() default "Item already exists.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
