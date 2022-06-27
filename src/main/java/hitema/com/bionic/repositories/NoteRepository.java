package hitema.com.bionic.repositories;

import hitema.com.bionic.Entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
