package ca.jonathonho.shelf.service;

import java.util.List;
import ca.jonathonho.shelf.model.Definition;

/**
 * DefinitionService interface.
 */
public interface DefinitionService {
    Definition saveDefinition(Definition definition);
    List<Definition> getAllDefinitions();
    Definition getDefinitionById(Long id);  
    Definition getDefinitionByWord(String word);
    Definition updateDefinition(Long id, Definition definition);
    void deleteDefinition(Long id);
}