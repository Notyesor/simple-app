package artamonov.nikolay.simpleapp.entity;

import artamonov.nikolay.simpleapp.dto.UserStatus;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "imageUri")
    private String imageUri;
    @Column(name = "status")
    private UserStatus status;
    @Column(name = "updated")
    private Long updated = new Date().getTime();

    public User() {
    }

    public User(String username, String email, String imageUri, UserStatus status) {
        this.username = username;
        this.email = email;
        this.imageUri = imageUri;
        this.status = status;
    }

    @PreUpdate
    public void setLastUpdate() {
        this.updated = new Date().getTime();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID userId) {
        this.id = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public Long getUpdated() {
        return updated;
    }

    public void setUpdated(Long updated) {
        this.updated = updated;
    }
}
