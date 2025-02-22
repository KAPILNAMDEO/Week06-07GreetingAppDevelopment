package com.greetingappadevlopment.service;



import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    /*
    public String getGreetingMessage() {
        return "Hello World";
    }
    */
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

}