package pl.coderslab.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
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
    public void remove(UserEntity userEntity) {

    }

}
