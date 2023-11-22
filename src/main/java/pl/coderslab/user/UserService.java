package pl.coderslab.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public void add (UserEntity userEntity);

    public void remove (UserEntity userEntity);

    public UserDetails loginUser (UserEntity userEntity);
}
