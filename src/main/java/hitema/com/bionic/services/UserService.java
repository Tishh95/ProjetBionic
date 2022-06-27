package hitema.com.bionic.services;

import hitema.com.bionic.entity.User;

import java.util.List;

public interface UserService {

        List<User> readAll();
        User create(User user);
        User read(Long id);
        User update(User user);
        Boolean delete(Long id);
}
