package hitema.com.bionic.repositories;


import hitema.com.bionic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}