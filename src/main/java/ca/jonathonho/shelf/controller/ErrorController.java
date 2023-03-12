package ca.jonathonho.shelf.controller;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Error controller.
 * Sends an error message when an error occurs.
 */
@RestController
@RequestMapping("/error")
public class ErrorController {
  
  // GET HTTP request
  // http://localhost:8080/error
  @GetMapping
  public String getError() {
    return "An error has occurred.";
  }
}
