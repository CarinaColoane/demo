package cl.example.demoBCI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/test")
public class HelloWorldController {

    @GetMapping(path="/hello")
    public String helloWorld() {
        return "Hello World";
    }

}
