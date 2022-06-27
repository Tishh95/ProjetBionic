package hitema.com.bionic.services;

import hitema.com.bionic.entity.Note;
import hitema.com.bionic.repositories.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService{

    private final NoteRepository repository;

    public NoteServiceImpl(NoteRepository repository) {
        this.repository = repository;
    }

    /**
     * @return Note list
     */
    @Override
    public List<Note> readAll() {

            return repository.findAll();
    }

    /**
     * @param note
     * @return Note
     */
    @Override
    public Note create(Note note) {
        return repository.save(note);
    }

    /**
     * @param id
     * @return  Note
     */
    @Override
    public Note read(Long id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * @param note
     * @return note
     */
    @Override
    public Note update(Note note) {
        return repository.save(note);
    }

    /**
     * @param id
     * @return boolean
     */
    @Override
    public Boolean delete(Long id) {
        repository.deleteById(id);
        return read(id) == null;
    }
}
