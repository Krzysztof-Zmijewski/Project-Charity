package pl.coderslab.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
        userRepository.save(toEdit);
    }

    @Override
    public void remove(UserEntity userEntity) {

    }

    @Override
    public List<UserEntity> getAllAdmins() {
        return userRepository.findAllByRole(roleRepository.findRoleByName("ADMIN"));
    }

    @Override
    public UserEntity get(Long id) {
        return userRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

}
