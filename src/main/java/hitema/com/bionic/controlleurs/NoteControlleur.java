package hitema.com.bionic.controlleurs;


import hitema.com.bionic.entity.Note;
import hitema.com.bionic.services.NoteService;
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

    public NoteControlleur(NoteService service) {
        this.service = service;
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

    @GetMapping("/xd")
    String gettest(@PathVariable("id") Long id){
        log.trace("user Id :{}",id);
        return "héhé";
    }
}
