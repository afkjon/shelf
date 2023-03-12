package ca.jonathonho.shelf.service;

import java.util.List;
import ca.jonathonho.shelf.model.SFX;

/**
 * SFXService interface.
 */
public interface SFXService {
    SFX saveSFX(SFX sfx);
    List<SFX> getAllSFX();
    List<SFX> searchSFX(String query);
    SFX getSFXById(Long id);  
    SFX getSFXByName(String name);
    SFX updateSFX(Long id, SFX sfx);
    void deleteSFX(Long id);
}