package ca.jonathonho.shelf.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * SFX model.
 * Represents a SFX object.
 */
@Setter
@Getter
@Data
@Entity
@Table(name = "sfx")
@NoArgsConstructor
@AllArgsConstructor
public class SFX {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "name", nullable = false, unique = true)
  private String name;
}
