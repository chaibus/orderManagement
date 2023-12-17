package softuni.restaurant.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import softuni.restaurant.model.entity.enums.RoleEnum;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;
    @Enumerated(EnumType.STRING)
    private RoleEnum role;
    private boolean active;

    public UserEntity() {
    }

    public UserEntity(String username, String password, String email, RoleEnum role, boolean active) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.active = active;
    }

    public String getUsername() {
        return username;
    }


    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public UserEntity setActive(boolean active) {
        this.active = active;
        return this;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public RoleEnum getRole() {
        return role;
    }

    public UserEntity setRole(RoleEnum role) {
        this.role = role;
        return this;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", active=" + active +
                '}';
    }
}
