package softuni.restaurant.model.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import softuni.restaurant.service.CategoryService;

public class UniqueCategoryNameValidator implements ConstraintValidator<UniqueCategoryName, String> {
    private final CategoryService categoryService;

    public UniqueCategoryNameValidator(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        if (name == null){
            return true;
        }
        return categoryService.isCategoryNameFree(name);
    }
}
