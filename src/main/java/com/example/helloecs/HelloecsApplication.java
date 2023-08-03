package com.example.helloecs;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class HelloecsApplication {

  private final TestRepository testRepository;

  @GetMapping
  public String applicationStatus() {
    return "Application is up and running abcde!";
  }

  @GetMapping("/{name}")
  public String welcome(@PathVariable String name) {
    testRepository.save(Test.builder().name(name).build());
    return "Hi " + name + " Welcome to AWS ECS Example";
  }

  public static void main(String[] args) {
    SpringApplication.run(HelloecsApplication.class, args);
  }
}
