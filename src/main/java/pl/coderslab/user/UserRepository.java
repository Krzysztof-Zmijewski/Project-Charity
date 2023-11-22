package pl.coderslab.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    public UserEntity getUserByUsername (String username);

    public Optional<UserEntity> findByUsername (String username);
}
