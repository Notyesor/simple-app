package artamonov.nikolay.simpleapp.service;

import artamonov.nikolay.simpleapp.dto.ChangeUserStatusResponse;
import artamonov.nikolay.simpleapp.dto.UserStatus;
import artamonov.nikolay.simpleapp.entity.User;
import artamonov.nikolay.simpleapp.repository.UserRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUserList(@Nullable UserStatus status, @Nullable Long updatedFrom) {
        if (status != null && updatedFrom != null) {
            return userRepository.findUsersByStatusAndUpdatedFrom(status, updatedFrom);
        } else if (status != null) {
            return userRepository.findUsersByStatus(status);
        } else if (updatedFrom != null) {
            return userRepository.findUsersByUpdatedFrom(updatedFrom);
        } else {
            return userRepository.findUsers();
        }
    }

    public UUID addUser(String email, String username, String imageUri) {
        User user = userRepository.save(new User(
                email,
                username,
                imageUri,
                UserStatus.OFFLINE
        ));
        return user.getId();
    }

    public ChangeUserStatusResponse updateUserStatus(User user, UserStatus newStatus) {
        UserStatus oldStatus = user.getStatus();
        if (!oldStatus.equals(newStatus)) {
            user.setStatus(newStatus);
            userRepository.save(user);
        }
        return new ChangeUserStatusResponse(user.getId(), oldStatus, newStatus);
    }

    public Optional<User> findUserById(UUID userId) {
        return userRepository.findById(userId);
    }
}
