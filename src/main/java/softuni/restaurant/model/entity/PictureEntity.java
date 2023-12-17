package softuni.restaurant.model.entity;

import static softuni.restaurant.constants.RestaurantConstantImages.DEFAULT_IMAGE;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "pictures")
public class PictureEntity extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String url;
    @Column(nullable = false, unique = true)
    private String publicId = DEFAULT_IMAGE;

    public PictureEntity() {
    }

    public String getUrl() {
        return url;
    }

    public PictureEntity setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getPublicId() {
        return publicId;
    }

    public PictureEntity setPublicId(String publicId) {
        this.publicId = publicId;
        return this;
    }
}
