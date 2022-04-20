package artamonov.nikolay.simpleapp.validation;

import artamonov.nikolay.simpleapp.dto.AddUserRequest;
import artamonov.nikolay.simpleapp.rest.exception.ValidationException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserValidator {

    public void validateAddUserRequest(AddUserRequest request) {
        Map<String, String> fieldErrors = new HashMap<>();
        validateEmail(request.getEmail(), fieldErrors);
        validateUsername(request.getUsername(), fieldErrors);
        if (!fieldErrors.isEmpty()) {
            throw new ValidationException(fieldErrors);
        }
    }

    public void validateEmail(String email, Map<String, String> fieldErrors) {
        String emailKey = "email";
        validateString(emailKey, email, 5, 256, fieldErrors);
        if (email != null && !email.isBlank() && !email.contains("@")) {
            fieldErrors.put(emailKey, "invalid");
        }
    }

    public void validateUsername(String username, Map<String, String> fieldErrors) {
        validateString("username", username, 3, 21, fieldErrors);
    }

    private void validateString(String key, String value, int minLength, int maxLengthExclude, Map<String, String> fieldErrors) {
        if (value == null || value.isBlank()) {
            fieldErrors.put(key, "required");
        } else if (value.length() < minLength) {
            fieldErrors.put(key, "too short");
        } else if (value.length() >= maxLengthExclude) {
            fieldErrors.put(key, "too long");
        }
    }
}
