package artamonov.nikolay.simpleapp.dto;

import java.io.Serializable;

public class AddUserRequest implements Serializable {

    private String email;

    private String username;

    private String imageUri;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }
}
