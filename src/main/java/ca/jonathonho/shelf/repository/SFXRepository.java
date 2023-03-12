package ca.jonathonho.shelf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import ca.jonathonho.shelf.model.SFX;

@Repository
public interface SFXRepository extends JpaRepository<SFX, Long> {
  SFX findByName(String name);

  @Query("SELECT s FROM SFX s WHERE s.name LIKE %?1%")
  List<SFX> searchSFX(String query);
}
