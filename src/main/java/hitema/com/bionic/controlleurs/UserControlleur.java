package hitema.com.bionic.controlleurs;


import hitema.com.bionic.entity.User;
import hitema.com.bionic.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserControlleur {
    private static final Logger log = LoggerFactory.getLogger(UserControlleur.class);

    private UserService service;

    public UserControlleur(UserService service) {
        this.service = service;
    }

    @GetMapping({"","/list"})
    List<User> getAll(){
        log.info("getAll");
        return service.readAll();
    }


    @GetMapping("/{id}")
    User getOne(@PathVariable("id") Long id){
        log.trace("user Id :{}",id);
        return service.read(id);
    }
}
