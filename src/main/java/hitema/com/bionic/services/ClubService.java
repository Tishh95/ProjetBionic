package hitema.com.bionic.services;

import hitema.com.bionic.entity.Club;

import java.util.List;

public interface ClubService {
    List<Club> readAll();
    Club create(Club club);
    Club read(Long id);
    Club update(Club club);
    Boolean delete(Long id);
}
