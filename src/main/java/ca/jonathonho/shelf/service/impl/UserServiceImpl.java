package ca.jonathonho.shelf.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import ca.jonathonho.shelf.model.User;
import ca.jonathonho.shelf.service.UserService;
import ca.jonathonho.shelf.repository.UserRepository;
import ca.jonathonho.shelf.exception.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    
    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by id
    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> 
            new ResourceNotFoundException("User", "id", id));
    }

    // Get user by username
    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Update user by id
    @Override
    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> 
            new ResourceNotFoundException("User", "id", id));
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setRole(user.getRole());
        return userRepository.save(existingUser);
    }

    // Delete user by id
    @Override
    public void deleteUser(Long id) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> 
            new ResourceNotFoundException("User", "id", id));
        userRepository.delete(existingUser);
    }
}
