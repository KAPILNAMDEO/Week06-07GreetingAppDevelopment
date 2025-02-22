package com.greetingappadevlopment.controller;



import com.greetingappadevlopment.model.Greeting;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    // GET Request - Returns a Greeting object as JSON
    @GetMapping("/greet")
    public Greeting getGreeting() {
        return new Greeting(1L, "Hello from GET");
    }

    // POST Request - Accepts a Greeting JSON and returns JSON response
    @PostMapping
    public Greeting postGreeting(@RequestBody Greeting request) {
        return new Greeting(2L, "Hello from POST, received: " + request.getMessage());
    }

    // PUT Request - Accepts a Greeting JSON and updates it
    @PutMapping
    public Greeting putGreeting(@RequestBody Greeting request) {
        return new Greeting(request.getId(), "Updated: " + request.getMessage());
    }

    // DELETE Request - Accepts a Greeting JSON (optional) and deletes it
    @DeleteMapping
    public Greeting deleteGreeting(@RequestBody(required = false) Greeting request) {
        if (request != null) {
            return new Greeting(request.getId(), "Deleted: " + request.getMessage());
        } else {
            return new Greeting(0L, "No data provided");
        }
    }
}

