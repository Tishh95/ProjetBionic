package hitema.com.bionic.services;

import hitema.com.bionic.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

        List<User> readAll();
        User create(User user);
        User read(Long id);
        User update(User user);
        Boolean delete(Long id);
        Optional<User> getOne(Long id);
        User getUserbyLogin(String username, String password);
}
