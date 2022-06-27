package hitema.com.bionic.services;

import hitema.com.bionic.entity.Club;
import hitema.com.bionic.repositories.ClubRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClubServiceImpl implements ClubService{

    private final ClubRepository repository;

    public ClubServiceImpl(ClubRepository repository) {
        this.repository = repository;
    }
    /**
     * @return Club list
     */
    @Override
    public List<Club> readAll() {
        return repository.findAll();
    }

    /**
     * @param club
     * @return Club
     */
    @Override
    public Club create(Club club) {
        if(club.getCreationDate() == null)
            club.setCreationDate(LocalDateTime.now());
        return repository.save(club);
    }

    /**
     * @param id
     * @return Club
     */
    @Override
    public Club read(Long id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * @param club
     * @return Club
     */
    @Override
    public Club update(Club club) {
        return repository.save(club);
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
