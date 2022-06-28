package hitema.com.bionic.services;

import hitema.com.bionic.entity.Note;
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
public class NoteServiceTest {

    private static final Logger log = LoggerFactory.getLogger(UserServiceTest.class);

    @Autowired
    NoteService service;
    @Autowired
    UserService userService;
    @Autowired
    ClubService clubService;

    Note note = new Note();

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
        note.setTitle("Note"+ LocalDateTime.now().toString());
        note.setNote("Get Bamboozled");
        note.setUser(userService.read(1l));
        var c = service.create(note);
        assertNotNull(c.getId(),"ERROR While Create Role :" +note);
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
        note.setTitle("Note"+ LocalDateTime.now().toString());
        note.setNote("Get Bamboozled");
        note.setUser(userService.read(1l));
        note = service.create(note);
        log.info("<<<START shouldDeleteNewCreatedCountry >>>");
        assertTrue("ERROR While DELETE New Created Country, id", service.delete(note.getId()));
        log.info("<<<END   shouldDeleteNewCreatedCountry >>>");
    }
    @Test
    @Order(5)
    void create_in_club(){
        note.setTitle("Note"+ LocalDateTime.now().toString());
        note.setNote("Get Bamboozled");
        note.setUser(userService.read(1l));
        note.setClub(clubService.read(1l));
        note = service.create(note);
        log.info("<<<START shouldDeleteNewCreatedCountry >>>");
        assertTrue("ERROR While DELETE New Created Country, id", service.delete(note.getId()));
        log.info("<<<END   shouldDeleteNewCreatedCountry >>>");
    }
}