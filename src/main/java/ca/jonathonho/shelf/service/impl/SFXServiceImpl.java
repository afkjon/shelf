package ca.jonathonho.shelf.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import ca.jonathonho.shelf.model.SFX;
import ca.jonathonho.shelf.service.SFXService;
import ca.jonathonho.shelf.repository.SFXRepository;
import ca.jonathonho.shelf.exception.ResourceNotFoundException;

/**
 * SFXService implementation.
 */
@Service
public class SFXServiceImpl implements SFXService {
  
  private final SFXRepository sfxRepository;

  public SFXServiceImpl(SFXRepository sfxRepository) {
    super();
    this.sfxRepository = sfxRepository;
  }

  @Override
  public SFX saveSFX(SFX sfx) {
    return sfxRepository.save(sfx);
  }

  @Override
  public List<SFX> getAllSFX() {
    return sfxRepository.findAll();
  }

  @Override
  public List<SFX> searchSFX(String query) {
    return sfxRepository.searchSFX(query);
  }

  // Get sfx by id
  @Override
  public SFX getSFXById(Long id) {
    return sfxRepository.findById(id).orElseThrow(() -> 
      new ResourceNotFoundException("SFX", "id", id));
  }

  // Get sfx by name
  @Override
  public SFX getSFXByName(String name) {
    return sfxRepository.findByName(name);
  }

  // Update sfx by id
  @Override
  public SFX updateSFX(Long id, SFX sfx) {
    SFX existingSFX = sfxRepository.findById(id).orElseThrow(() -> 
      new ResourceNotFoundException("SFX", "id", id));
    existingSFX.setName(sfx.getName());
    return sfxRepository.save(existingSFX);
  }

  // Delete sfx by id
  @Override
  public void deleteSFX(Long id) {

    sfxRepository.findById(id).orElseThrow(() ->
      new ResourceNotFoundException("SFX", "id", id));
    sfxRepository.deleteById(id);
  }
}
