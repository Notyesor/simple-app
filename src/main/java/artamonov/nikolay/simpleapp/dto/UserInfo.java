package artamonov.nikolay.simpleapp.dto;

import artamonov.nikolay.simpleapp.entity.User;

import java.io.Serializable;
import java.util.UUID;

public class UserInfo implements Serializable {

    private UUID id;

    private String username;

    private String email;

    private String imageUri;

    private UserStatus status;

    public UserInfo() {
    }

    public UserInfo(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.imageUri = user.getImageUri();
        this.status = user.getStatus();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
}
