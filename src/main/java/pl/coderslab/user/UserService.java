package pl.coderslab.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public void add (UserEntity userEntity);

    public void addAdmin (UserEntity userEntity);

    public void edit (UserEntity userEntity);

    public void remove (UserEntity userEntity);

    public List<UserEntity> getAllAdmins();

    public UserEntity get(Long id);

    public List<UserEntity> findAll();

    public List<UserEntity> getAllUsers();

    public UserEntity getUserByUsername (String username);


}
