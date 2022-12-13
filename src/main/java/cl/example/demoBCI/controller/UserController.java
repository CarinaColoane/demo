package cl.example.demoBCI.controller;

import cl.example.demoBCI.entity.UserInfo;
import cl.example.demoBCI.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userservice;

    @PostMapping(path="/create")
    public ResponseEntity<UserInfo> createUser(@Valid @RequestBody UserInfo userRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userservice.createUser(userRequest));
    }

}
