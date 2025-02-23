package com.greetingappadevlopment.controller;



import com.greetingappadevlopment.model.Greeting;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import com.greetingappadevlopment.service.GreetingService;
import com.greetingappadevlopment.model.Greeting;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    /*
    //UC1
    @GetMapping("/greet")
    public Greeting getGreeting() {
        return new Greeting("Hello from BridgeLabz");
    }

    @PostMapping("/greet")
    public Greeting postGreeting(@RequestBody Greeting greeting) {
        return greeting;
    }

    @PutMapping("/greet")
    public Greeting putGreeting(@RequestBody Greeting greeting) {
        return new Greeting("Updated: " + greeting.getMessage());
    }

    @DeleteMapping("/greet")
    public Greeting deleteGreeting() {
        return new Greeting("Greeting deleted");
    }


    */


    private final GreetingService greetingService;

    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    /*
    //UC2
    @GetMapping("/greetservice")
    public Greeting getGreetings() {
        return new Greeting(greetingService.getGreetingMessage());
    }
    */

    /*
    UC3-Ability for the Greeting App to give Greeting message with
        1. User First Name and Last Name or
        2. With just First Name or Last Name based on User attributes provides or
        3. Just Hello World.
    */
    @GetMapping("/greetuser")
    public Greeting greetUser(@RequestParam(required = false) String firstName,
                              @RequestParam(required = false) String lastName) {
        String message = greetingService.getGreetingMessage(firstName, lastName);
        return new Greeting(message);
    }

    //UC-04
    @PostMapping("/savegreeting")
    public Greeting saveGreeting(@RequestParam(required = false) String firstName,
                                 @RequestParam(required = false) String lastName) {
        String message = greetingService.getGreetingMessage(firstName, lastName);
        return greetingService.saveGreeting(firstName, lastName);
    }

    //U05
    @GetMapping("/findgreeting/{id}")
    public Greeting findGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id)
                .orElseThrow(() -> new RuntimeException("Greeting not found with ID: " + id));
    }


    //UC-06 Ability for the Greeti App to List all the Greeting Messages in the Repository
    @GetMapping("/allgreetings")
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }
    //UC-07Ability for the Greeting App to Edit a Greeting Messages in thE Repository
    @PutMapping("/updategreeting/{id}")
    public Greeting updateGreeting(
            @PathVariable Long id,
            @RequestParam String message) {
        return greetingService.updateGreeting(id, message);
    }

    //UC-08 Add Delete Endpoint in GreetingController.java
    /*Uses @DeleteMapping to handle HTTP DELETE requests.
Returns a success message when deletion is complete.*/
    @DeleteMapping("/deletegreeting/{id}")
    public ResponseEntity<String> deleteGreeting(@PathVariable Long id) {
        greetingService.deleteGreeting(id);
        return ResponseEntity.ok("Greeting with ID " + id + " deleted successfully.");
    }


}
