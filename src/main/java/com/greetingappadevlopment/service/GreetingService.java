package com.greetingappadevlopment.service;



import com.greetingappadevlopment.model.Greeting;
import com.greetingappadevlopment.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {


    private final GreetingRepository greetingRepository;

    @Autowired
    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }


    /* UC-01
    public String getGreetingMessage() {
        return "Hello World";
    }
    */

    /*UC-02
    public String getGreetingMessage(String firstName, String lastName) {
        if (firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty()) {
            return "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null && !firstName.isEmpty()) {
            return "Hello, " + firstName + "!";
        } else if (lastName != null && !lastName.isEmpty()) {
            return "Hello, " + lastName + "!";
        } else {
            return "Hello World";
        }
    }
    */


    //UC-04
    public String getGreetingMessage(String firstName, String lastName) {
        String message;
        if (firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty()) {
            message = "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null && !firstName.isEmpty()) {
            message = "Hello, " + firstName + "!";
        } else if (lastName != null && !lastName.isEmpty()) {
            message = "Hello, " + lastName + "!";
        } else {
            message = "Hello World";
        }

        // Save greeting to repository
        Greeting greeting = new Greeting(message);
        greetingRepository.save(greeting);

        return message; // Save in database
    }


    //UC-05
    // New method to find a greeting by ID
    public Optional<Greeting> getGreetingById(Long id) {
        return greetingRepository.findById(id);
    }


    //UC-06
    public Greeting saveGreeting(String firstName, String lastName) {
        String message;

        if (firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty()) {
            message = "Hello, " + firstName.trim() + " " + lastName.trim() + "!";
        } else if (firstName != null && !firstName.isEmpty()) {
            message = "Hello, " + firstName.trim() + "!";
        } else if (lastName != null && !lastName.isEmpty()) {
            message = "Hello, " + lastName.trim() + "!";
        } else {
            message = "Hello World!";
        }

        message = message.replaceAll("\\s+", " ").trim(); // Remove extra spaces or newlines

        Greeting greeting = new Greeting(message);
        return greetingRepository.save(greeting);
    }



    //UC-06 Ability for the Greeti App to List all the Greeting Messages in the Repository
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    //UC-07Ability for the Greeting App to Edit a Greeting Messages in thE Repository
    public Greeting updateGreeting(Long id, String newMessage) {
        Optional<Greeting> existingGreeting = greetingRepository.findById(id);

        if (existingGreeting.isPresent()) {
            Greeting greeting = existingGreeting.get();
            greeting.setMessage(newMessage);
            return greetingRepository.save(greeting);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Greeting not found with id: " + id);
        }
    }

    //UC-08 Ability for the Greeting  App to delete a Greeting Messages in thE Repository
    public void deleteGreeting(Long id) {
        if (greetingRepository.existsById(id)) {
            greetingRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Greeting not found with id: " + id);
        }
    }



}