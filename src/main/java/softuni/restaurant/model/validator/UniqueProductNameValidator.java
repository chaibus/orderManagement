package softuni.restaurant.model.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import softuni.restaurant.service.ProductService;

public class UniqueProductNameValidator implements ConstraintValidator<UniqueProductName, String> {
    private final ProductService productService;

    public UniqueProductNameValidator(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {

        if (name == null){
            return true;
        }
        return productService.isCategoryNameFree(name);

    }
}
