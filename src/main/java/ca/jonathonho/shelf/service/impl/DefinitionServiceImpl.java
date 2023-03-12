package ca.jonathonho.shelf.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import ca.jonathonho.shelf.model.Definition;

import ca.jonathonho.shelf.repository.SFXRepository;
import ca.jonathonho.shelf.service.DefinitionService;
import ca.jonathonho.shelf.repository.DefinitionRepository;
import ca.jonathonho.shelf.exception.ResourceNotFoundException;

/**
 * DefinitionService implementation.
 */
@Service
public class DefinitionServiceImpl implements DefinitionService {

    private final SFXRepository sfxRepository;
    private final DefinitionRepository definitionRepository;
    
    public DefinitionServiceImpl(SFXRepository sfxRepository, DefinitionRepository definitionRepository) {
        super();
        this.sfxRepository = sfxRepository;
        this.definitionRepository = definitionRepository;
    }

    @Override
    public Definition saveDefinition(Definition definition) {
        return definitionRepository.save(definition);
    }

    @Override
    public List<Definition> getAllDefinitions() {
        return definitionRepository.findAll();
    }

    // Get definition by id
    @Override
    public Definition getDefinitionById(Long id) {
        return definitionRepository.findById(id).orElseThrow(() -> 
            new ResourceNotFoundException("Definition", "id", id));
    }

    // Get definition by word
    @Override
    public Definition getDefinitionByWord(String word) {
        return definitionRepository.findById(sfxRepository.findByName(word).getId()).orElseThrow(() -> 
            new ResourceNotFoundException("Definition", "word", word));
    }

    // Update definition by id
    @Override
    public Definition updateDefinition(Long id, Definition definition) {
        Definition existingDefinition = definitionRepository.findById(id).orElseThrow(() -> 
            new ResourceNotFoundException("Definition", "id", id));
        existingDefinition.setDefinition(definition.getDefinition());
        return definitionRepository.save(existingDefinition);
    }

    // Delete definition by id
    @Override
    public void deleteDefinition(Long id) {

        definitionRepository.findById(id).orElseThrow(() ->
            new ResourceNotFoundException("Definition", "id", id));
        definitionRepository.deleteById(id);
    }
    
}
