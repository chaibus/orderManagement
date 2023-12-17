package softuni.restaurant.model.binding;

import java.util.HashSet;
import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import softuni.restaurant.model.entity.AllergenEntity;
import softuni.restaurant.model.validator.UniqueProductName;

public class ProductAddBindingModel {
    @NotBlank
    @UniqueProductName
    @Size(min = 2, max = 20, message = "The product name must contain at least 2 symbols")
    private String name;
    private Set<AllergenEntity> allergens= new HashSet<>();

    public String getName() {
        return name;
    }

    public ProductAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public Set<AllergenEntity> getAllergens() {
        return allergens;
    }

    public ProductAddBindingModel setAllergens(Set<AllergenEntity> allergens) {
        this.allergens = allergens;
        return this;
    }
}

