package hitema.com.bionic.controlleurs;


import hitema.com.bionic.entity.Club;
import hitema.com.bionic.entity.User;
import hitema.com.bionic.services.ClubService;
import hitema.com.bionic.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clubs")
@CrossOrigin
public class ClubControlleur {
    private static final Logger log = LoggerFactory.getLogger(UserControlleur.class);

    private ClubService service;

    private UserService Userservice;
    public ClubControlleur(ClubService service, UserService userservice) {
        this.service = service;
        this.Userservice = userservice;
    }

    @GetMapping({"","/list"})
    List<Club> getAll(){
        log.info("getAll");
        return service.readAll();
    }


    @GetMapping("/{id}")
    Club getOne(@PathVariable("id") Long id){
        log.trace("user Id :{}",id);
        return service.read(id);
    }
    @GetMapping("/userclub")
    List<User> GetAllUser(){
        return Userservice.readAll();
    }
}
