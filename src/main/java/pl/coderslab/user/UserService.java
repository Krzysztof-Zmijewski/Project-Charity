package pl.coderslab.user;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public void add (User user);

    public void remove (User user);
}
