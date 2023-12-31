package softuni.restaurant.model.validator;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import softuni.restaurant.service.UserService;

public class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName, String> {

  private final UserService userService;

  public UniqueUserNameValidator(UserService userService) {
    this.userService = userService;
  }

  @Override
  public boolean isValid(String userName, ConstraintValidatorContext context) {
    if (userName == null) {
      return true;
    }
    return userService.usernameFree(userName);
  }
}
