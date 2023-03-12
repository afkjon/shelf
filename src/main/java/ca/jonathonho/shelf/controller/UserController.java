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
import org.springframework.web.bind.annotation.RestController;

import ca.jonathonho.shelf.model.User;
import ca.jonathonho.shelf.service.UserService;

/**
 * User controller.
 * Handles HTTP requests for user data.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    super();
    this.userService = userService;
  }

  @PostMapping()
  public ResponseEntity<User> saveUser(@RequestBody User user) { 
    return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
  }

  @GetMapping
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  // build get user by id endpoint
  // localhost://8080/api/users/1
  @GetMapping("{id}")
  public ResponseEntity<User> getUserById(@PathVariable("id") long userId) {
    return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
  }

  // Update user by id
  @PutMapping("{id}")
  public ResponseEntity<User> updateUserById(@PathVariable("id") long userId, @RequestBody User user) {
    return new ResponseEntity<>(userService.updateUser(userId, user), HttpStatus.OK);
  }

  // Delete user by id
  @DeleteMapping("{id}")
  public ResponseEntity<User> deleteUserById(@PathVariable("id") long userId) {
    userService.deleteUser(userId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  // Get user by username
  @GetMapping("/name/{username}")
  public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username) {
    return new ResponseEntity<>(userService.getUserByUsername(username), HttpStatus.OK);
  }
}
