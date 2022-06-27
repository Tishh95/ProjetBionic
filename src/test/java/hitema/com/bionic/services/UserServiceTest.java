package hitema.com.bionic.services;


import hitema.com.bionic.entity.User;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
public class UserServiceTest {

    private static final Logger log = LoggerFactory.getLogger(UserServiceTest.class);

    @Autowired
    UserService service;

    private User user;
    @Test
    void readAll() {
        log.trace("<<<<<<<City Read ALL>>>>>>>");
        service.readAll().forEach(c->log.trace("{}",c));
        log.trace("<<<<<<<END>>>>>>>");

    }

    @Test
    @Order(1)
    void create() {
        log.info("<<<START create USER  >>>");
        user = new User();
        user.setName("Name");
        user.setPassword("password");
        service.create(user);
        log.info("<<<END   create USER >>>");
    }

    @Test
    void read() {
        long id = 9;
        service.read(id);
    }



}
