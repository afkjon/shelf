package ca.jonathonho.shelf.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import ca.jonathonho.shelf.model.SFX;
import ca.jonathonho.shelf.service.SFXService;

/**
 * SFX controller.
 * Handles HTTP requests for SFX data.
 */
@RestController
@RequestMapping("/api/sfx")
public class SFXController {
  private final SFXService sfxService;
  
  public SFXController(SFXService sfxService) {
    super();
    this.sfxService = sfxService;
  }

  @GetMapping("{id}")
  public ResponseEntity<SFX> getSFXById(@PathVariable("id") Long id) {
    return new ResponseEntity<>(sfxService.getSFXById(id), HttpStatus.OK);
  }
  
  /**
   * Get all SFX from the database.
   * @return
   */
  @GetMapping
  public List<SFX> getAllSFX() {
    return sfxService.getAllSFX();
  }

  /**
    * Get a SFX by its name.
    * @param id
    * @param name
    * @return
    */
  @GetMapping("/word/{name}")
  public ResponseEntity<SFX> getSFXByName(@RequestParam("name") String name) {
    return new ResponseEntity<>(sfxService.getSFXByName(name), HttpStatus.OK);
  }

  /**
   * Save a SFX to the database.
   * @param sfx
   * @return
   */
  @PostMapping
  public ResponseEntity<SFX> saveSFX(@RequestBody SFX sfx) {
    return new ResponseEntity<>(sfxService.saveSFX(sfx), HttpStatus.CREATED);
  }

  /**
   * Update a SFX in the database.
   * @param id
   * @param sfx
   * @return
   */
  @PutMapping("{id}")
  public SFX updateSFX(@PathVariable("id") Long id, @RequestBody SFX sfx) {
    return sfxService.updateSFX(id, sfx);
  }

  /**
   * Delete a SFX from the database.
   * @param id
   */
  @DeleteMapping("{id}")
  public void deleteSFX(@PathVariable("id") Long id) {
    sfxService.deleteSFX(id);
  }

  /**
   * Search for a SFX by its name.
   * @param query
   * @return
   */
  @GetMapping("/search")
  public List<SFX> searchSFX(@RequestParam("query") String query) {
    return sfxService.searchSFX(query);
  }
  
}
