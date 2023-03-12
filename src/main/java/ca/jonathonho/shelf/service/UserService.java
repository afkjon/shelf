package ca.jonathonho.shelf.service;

import java.util.List;
import ca.jonathonho.shelf.model.User;

/**
 * UserService interface.
 */
public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);  
    User getUserByUsername(String username);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
}
