package softuni.restaurant.model.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueUserNameValidator.class)
public @interface UniqueUserName {

  String message() default "Username is not unique";

  Class<?>[] groups() default { };

  Class<? extends Payload>[] payload() default { };

}
