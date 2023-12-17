package softuni.restaurant.model.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class ProductEntity extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String name;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<AllergenEntity> allergens = new HashSet<>();
    @ManyToMany(mappedBy = "products", fetch = FetchType.EAGER)
    private Set<ItemEntity> items;

    public Set<ItemEntity> getItems() {
        return items;
    }

    public ProductEntity setItems(Set<ItemEntity> items) {
        this.items = items;
        return this;
    }

    public ProductEntity() {
    }

    public String getName() {
        return name;
    }

    public ProductEntity setName(String name) {
        this.name = name;
        return this;
    }

    public Set<AllergenEntity> getAllergens() {
        return allergens;
    }

    public ProductEntity setAllergens(Set<AllergenEntity> allergens) {
        this.allergens = allergens;
        return this;
    }
}
