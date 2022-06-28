package hitema.com.bionic.services;

import hitema.com.bionic.entity.Club;
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
public class ClubServiceTest {

    private static final Logger log = LoggerFactory.getLogger(UserServiceTest.class);

    @Autowired
    ClubService service;

    Club club = new Club();

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
        club.setName("Club"+ LocalDateTime.now().toString());
        club.setCreatorId(1l);

        var c = service.create(club);
        assertNotNull(c.getId(),"ERROR While Create Role :" +club);
        service.delete(c.getId());
        log.info("<<<END   create USER >>>");

    }

    @Test
    @Order(2)
    void read() {
        log.info("<<<Start   read USER >>>");
        var c = service.read(1l);
        log.info("<<<END   read USER >>>");
    }

    @Test
    @Order(4)
    void delete() {
        club.setName("Name"+ LocalDateTime.now().toString());
        club.setCreatorId(1l);
        club = service.create(club);
        log.info("<<<START shouldDeleteNewCreatedCountry >>>");
        assertTrue("ERROR While DELETE New Created Country, id", service.delete(club.getId()));
        log.info("<<<END   shouldDeleteNewCreatedCountry >>>");
    }
}
