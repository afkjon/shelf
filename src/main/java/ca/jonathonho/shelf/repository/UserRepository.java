package ca.jonathonho.shelf.repository;

import ca.jonathonho.shelf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
  User findByUsername(String username);
}
