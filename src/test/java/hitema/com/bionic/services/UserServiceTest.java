package hitema.com.bionic.services;


import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

    private static final Logger log = LoggerFactory.getLogger(UserServiceTest.class);

    @Autowired
    UserService service;

    @Test
    void readAll() {
        log.trace("<<<<<<<City Read ALL>>>>>>>");
        service.readAll().forEach(c->log.trace("{}",c));
        log.trace("<<<<<<<END>>>>>>>");

    }

}
