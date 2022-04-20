package artamonov.nikolay.simpleapp.dto;

import java.io.Serializable;
import java.util.UUID;

public class ChangeUserStatusResponse implements Serializable {

    private UUID userId;

    private UserStatus oldStatus;

    private UserStatus newStatus;

    public ChangeUserStatusResponse(UUID userId, UserStatus oldStatus, UserStatus newStatus) {
        this.userId = userId;
        this.oldStatus = oldStatus;
        this.newStatus = newStatus;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UserStatus getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(UserStatus oldStatus) {
        this.oldStatus = oldStatus;
    }

    public UserStatus getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(UserStatus newStatus) {
        this.newStatus = newStatus;
    }
}
