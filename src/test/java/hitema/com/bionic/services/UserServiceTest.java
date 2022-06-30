package hitema.com.bionic.services;


import hitema.com.bionic.entity.User;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
public class UserServiceTest {

    private static final Logger log = LoggerFactory.getLogger(UserServiceTest.class);

    @Autowired
    UserService service;

    private User user = new User();
    @Test
    @Order(3)
    void readAll() {
        log.info("<<<<<<<City Read ALL>>>>>>>");
        service.readAll().forEach(c->log.trace("{}",c));
        log.info("<<<<<<<END>>>>>>>");

    }

    @Test
    @Order(1)
    void create() {
        log.info("<<<START create USER  >>>");
        user.setName("Name"+ LocalDateTime.now().toString());
        user.setPassword("password");
        var u = service.create(user);
        assertNotNull(u.getId(),"ERROR While Create Role :" +user);
        service.delete(u.getId());
        log.info("<<<END   create USER >>>");

    }

    @Test
    @Order(2)
    void read() {
        log.info("<<<Start   read USER >>>");
        var u = service.read(1l);
        log.info("<<<END   read USER >>>");
    }

    @Test
    @Order(4)
    void delete() {
        user.setName("Name"+ LocalDateTime.now().toString());
        user.setPassword("password");
        user = service.create(user);
        log.info("<<<START shouldDeleteNewCreatedCountry >>>");
        assertTrue("ERROR While DELETE New Created Country, id", service.delete(user.getId()));
        log.info("<<<END   shouldDeleteNewCreatedCountry >>>");
    }

    @Test
    @Order(5)
    void testFindByUsernameAndPassword(){
         user = service.getUserByLoginNoHashCode("admin","admin");

         assertTrue("error while getting user by login", user.getName().equals(service.read(5l).getName()) );
    }
}
