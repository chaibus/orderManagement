package softuni.restaurant.model.binding;

import java.util.HashSet;
import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import softuni.restaurant.model.entity.AllergenEntity;

public class ProductUpdateBindingModel {
    private Long id;
    @NotBlank
    @Size(min = 2, max = 20, message = "The product name must contain at least 2 symbols")
    private String name;
    private Set<AllergenEntity> allergens = new HashSet<>();

    public ProductUpdateBindingModel() {
    }

    public Long getId() {
        return id;
    }

    public ProductUpdateBindingModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductUpdateBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public Set<AllergenEntity> getAllergens() {
        return allergens;
    }

    public ProductUpdateBindingModel setAllergens(Set<AllergenEntity> allergens) {
        this.allergens = allergens;
        return this;
    }
}
