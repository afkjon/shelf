package ca.jonathonho.shelf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.jonathonho.shelf.model.Definition;

@Repository
public interface DefinitionRepository extends JpaRepository<Definition, Long> {
  
}
