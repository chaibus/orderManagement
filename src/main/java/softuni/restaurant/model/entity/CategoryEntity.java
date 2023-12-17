package softuni.restaurant.model.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table(name = "categories")
@Entity
public class CategoryEntity extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String name;
    @OneToOne
    private PictureEntity picture;
    @Column(columnDefinition = "TEXT")
    private String description;
    @ManyToMany(mappedBy = "categories", fetch = FetchType.EAGER)
    private Set<ItemEntity> items;


    public CategoryEntity() {
    }

    public CategoryEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public CategoryEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public CategoryEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CategoryEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public PictureEntity getPicture() {
        return picture;
    }

    public CategoryEntity setPicture(PictureEntity picture) {
        this.picture = picture;
        return this;
    }

    public Set<ItemEntity> getItems() {
        return items;
    }

    public CategoryEntity setItems(Set<ItemEntity> items) {
        this.items = items;
        return this;
    }
}