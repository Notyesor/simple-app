package artamonov.nikolay.simpleapp.repository;

import artamonov.nikolay.simpleapp.dto.UserStatus;
import artamonov.nikolay.simpleapp.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {

    @Query("SELECT user FROM User user WHERE user.status = ?1")
    List<User> findUsersByStatus(UserStatus status);

    @Query("SELECT user FROM User user WHERE user.updated > ?1")
    List<User> findUsersByUpdatedFrom(Long updatedFrom);

    @Query("SELECT user FROM User user WHERE user.status = ?1 and user.updated > ?2")
    List<User> findUsersByStatusAndUpdatedFrom(UserStatus status, Long updatedFrom);

    @Query("SELECT user FROM User user")
    List<User> findUsers();
}
