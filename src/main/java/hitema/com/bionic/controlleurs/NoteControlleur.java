package hitema.com.bionic.controlleurs;


import hitema.com.bionic.entity.Note;
import hitema.com.bionic.services.NoteService;
import hitema.com.bionic.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@CrossOrigin
public class NoteControlleur {
    private static final Logger log = LoggerFactory.getLogger(UserControlleur.class);

    private NoteService service;
    private UserService Userservice;

    public NoteControlleur(NoteService service, UserService userservice) {
        this.service = service;
        this.Userservice = userservice;
    }



    @GetMapping({"","/list"})
    List<Note> getAll(){
        log.info("getAll");
        return service.readAll();
    }


    @GetMapping("/test/{id}")
    Note getOne(@PathVariable("id") Long id){
        log.trace("user Id :{}",id);
        return service.read(id);
    }

    @GetMapping("/user/{id}")
    Note getById(@PathVariable("id") Long id){
        log.trace("note Id :{}",id);
        return service.read(id);
    }

    @GetMapping("/note/drop/{id}")
    void dropNote(@PathVariable("id") Long id){
        log.trace("user Id :{}",id);
        service.delete(id);
    }


    @GetMapping("/note/create/{title}/{content}/{userid}")
    String createNote(@PathVariable("title") String title, @PathVariable("content")String content, @PathVariable("userid")Long userid){
        Note note = new Note();
        note.setTitle(title);
        note.setNote(content);
        note.setUser(Userservice.read(userid));
        service.create(note);
        return title + " " + content;
    }
}
