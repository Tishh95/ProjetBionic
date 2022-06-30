package hitema.com.bionic.controlleurs;

import hitema.com.bionic.repositories.UserRepository;
import hitema.com.bionic.entity.User;
import hitema.com.bionic.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserControlleur {
    private static final Logger log = LoggerFactory.getLogger(UserControlleur.class);

    private UserService service;
    private UserRepository repository;
    public UserControlleur(UserService service) {
        this.service = service;
    }

    @GetMapping({"/list"})
    List<User> getAll(){
        log.info("getAll");
        return service.readAll();
    }


    @GetMapping("/user/{id}")
    String getOne(@PathVariable("id") Long id){
        log.trace("user Id :{}",id);
        service.read(id);
        return "test id";
    }
    @GetMapping("/user/note/{id}")
    Optional<User> getNotes(@PathVariable("id") Long id){
        log.trace("user Id :{}",id);
        return service.getOne(id);
    }

    @GetMapping("/user/login_check/username={username}&password={password}")
    long getLoginFromLogin(@PathVariable("username") String username,@PathVariable("password") String password){
        log.trace("user username :{}",username);
        log.trace("user password :{}",password);
        return service.getUserbyLogin(username,password).getId();
    }
    @GetMapping("/user/subscribe/username={username}&password={password}")
    long createUser(@PathVariable("username") String username,@PathVariable("password") String password){
        if (repository.existsByUsername(username)){
            return 0;
        }
        else {
            User user = new User();
            user.setName(username);
            user.setPassword(password);
            service.create(user);
            return 1;
        }
    }


}
