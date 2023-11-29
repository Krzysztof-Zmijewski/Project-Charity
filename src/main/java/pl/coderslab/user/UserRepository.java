package pl.coderslab.user;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Role;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    public UserEntity getUserByUsername (String username);

    public Optional<UserEntity> findByUsername (String username);

    public List<UserEntity> findAllByRole(Role role);
}
