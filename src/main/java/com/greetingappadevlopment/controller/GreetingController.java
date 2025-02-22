package com.greetingappadevlopment.controller;



import com.greetingappadevlopment.model.Greeting;
import org.springframework.web.bind.annotation.*;



import com.greetingappadevlopment.service.GreetingService;
import com.greetingappadevlopment.model.Greeting;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

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

    @PostMapping("/savegreeting")
    public Greeting saveGreeting(@RequestParam(required = false) String firstName,
                                 @RequestParam(required = false) String lastName) {
        String message = greetingService.getGreetingMessage(firstName, lastName);
        return new Greeting(message);
    }





}
