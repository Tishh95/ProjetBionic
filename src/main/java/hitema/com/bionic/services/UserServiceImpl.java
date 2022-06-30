package hitema.com.bionic.services;

import hitema.com.bionic.entity.User;
import hitema.com.bionic.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }
    /**
     * @return User list
     */
    @Override
    public List<User> readAll() {
        return repository.findAll();
    }

    /**
     * @param user
     * @return user
     */
    @Override
    public User create(User user) {
        if(user.getCreationDate() == null)
            user.setCreationDate(LocalDateTime.now());
        user.setPassword(String.valueOf(user.getPassword().hashCode()));
        return repository.save(user);
    }

    /**
     * @param id
     * @return user
     */
    @Override
    public User read(Long id) {

            return repository.findById(id).orElse(null);
    }

    /**
     * @param user
     * @return user
     */
    @Override
    public User update(User user) {
        return repository.save(user);
    }

    /**
     * @param id
     * @return boolean
     */
    @Override
    public Boolean delete(Long id) {

        repository.deleteById(id);
        return read(id) == null;

    }


    public User getUserbyLogin(String username, String password){
        return repository.findByUsernameAndPassword(username,password);
    }
}
