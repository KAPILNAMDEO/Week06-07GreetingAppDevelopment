package com.greetingappadevlopment.repository;

import com.greetingappadevlopment.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<Greeting,Long> {

}
