package pl.coderslab.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.exception.ResourceNotFoundException;
import pl.coderslab.model.Role;
import pl.coderslab.model.RoleRepository;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    @Override
    public void add(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role role = roleRepository.findRoleByName("USER");
        user.setRole(Collections.singletonList(role));

        userRepository.save(user);
    }

    @Override
    public void addAdmin(UserEntity userEntity) {

    }

    @Override
    public void edit(UserEntity userEntity) {
        UserEntity toEdit = userRepository.findById(userEntity.getId()).orElseThrow(ResourceNotFoundException::new);
        toEdit.setFirstname(userEntity.getFirstname());
        toEdit.setLastname(userEntity.getLastname());
        toEdit.setUsername(userEntity.getUsername());
        if (userEntity.getPassword() != null) {
            toEdit.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        }
        userRepository.save(toEdit);
    }

    @Override
    public void remove(UserEntity userEntity) {
        userRepository.delete(userEntity);
    }

    @Override
    public List<UserEntity> getAllAdmins() {
        return userRepository.findAllByRole(roleRepository.findRoleByName("ADMIN"));
    }
    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAllByRole(roleRepository.findRoleByName("USER"));
    }

    @Override
    public UserEntity getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    @Override
    public UserEntity get(Long id) {
        return userRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

}
