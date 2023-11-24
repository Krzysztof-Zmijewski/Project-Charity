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

    @Override
    public UserDetails loginUser(UserEntity userEntity) throws UsernameNotFoundException {
        UserEntity loginUserEntity = userRepository.getUserByUsername(userEntity.getUsername());
        if (loginUserEntity == null) {
            throw new UsernameNotFoundException("User email " + userEntity.getUsername() + "not found");
        }
//        if (passwordEncoder.matches(user.getPassword(), loginUser.getPassword())) {
//            return org.springframework.security.core.userdetails.User.builder().username(loginUser.getFirstname())
//                    .password(loginUser.getPassword())
//                    .
//        }


        return null;
    }
}
