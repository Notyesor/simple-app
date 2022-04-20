package artamonov.nikolay.simpleapp.rest;

import artamonov.nikolay.simpleapp.dto.AddUserRequest;
import artamonov.nikolay.simpleapp.dto.ChangeUserStatusResponse;
import artamonov.nikolay.simpleapp.dto.UserInfo;
import artamonov.nikolay.simpleapp.dto.UserStatus;
import artamonov.nikolay.simpleapp.entity.User;
import artamonov.nikolay.simpleapp.rest.exception.UserNotFoundException;
import artamonov.nikolay.simpleapp.service.UserService;
import artamonov.nikolay.simpleapp.validation.UserValidator;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "users")
public class UserController {

    private final UserService userService;
    private final UserValidator userValidator;


    public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @GetMapping()
    public List<UserInfo> getUserList(
            @RequestParam("status") @Nullable UserStatus status,
            @RequestParam("updatedFrom") @Nullable Long updatedFrom
    ) {
        List<User> userList = userService.getUserList(status, updatedFrom);
        return userList
                .stream()
                .map(UserInfo::new)
                .collect(Collectors.toList());
    }

    @PostMapping()
    public UUID addUser(@RequestBody AddUserRequest request) {
        userValidator.validateAddUserRequest(request);
        return userService.addUser(request.getEmail(), request.getUsername(), request.getImageUri());
    }

    @PatchMapping(path = "{userId}/status")
    public ChangeUserStatusResponse changeUserStatus(@PathVariable UUID userId, @RequestBody UserStatus status) {
        User user = userService
                .findUserById(userId)
                .orElseThrow(UserNotFoundException::new);
        return userService.updateUserStatus(user, status);
    }

    @GetMapping(path = "{userId}")
    public UserInfo getUserInfo(@PathVariable UUID userId) {
        return userService
                .findUserById(userId)
                .map(UserInfo::new)
                .orElseThrow(UserNotFoundException::new);
    }
}
