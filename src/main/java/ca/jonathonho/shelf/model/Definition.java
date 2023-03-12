package ca.jonathonho.shelf.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Definition model.
 * Represents a definition object.
 */
@Data
@Entity
public class Definition {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "word_id", nullable = false, unique = false)
  private long wordId;

  @Column(name = "definition", nullable = false, unique = false)
  private String definition;

  @Column(name = "example", nullable = true)
  private String example;
}
