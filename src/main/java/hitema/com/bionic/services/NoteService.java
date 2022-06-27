package hitema.com.bionic.services;

import hitema.com.bionic.entity.Note;

import java.util.List;

public interface NoteService    {
    List<Note> readAll();
    Note create(Note club);
    Note read(Long id);
    Note update(Note club);
    Boolean delete(Long id);
}
