package cl.example.demoBCI.controller;

import cl.example.demoBCI.dto.UserRequestTO;
import cl.example.demoBCI.dto.UserResponseTO;
import cl.example.demoBCI.entity.UserInfo;
import cl.example.demoBCI.exception.ResourceNotFoundException;
import cl.example.demoBCI.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/usuario")
public class UserController {

    @Autowired
    private UserService userservice;

    @PostMapping(path="/crear")
    public ResponseEntity<UserInfo> createUser(@RequestBody UserInfo userRequest) {
        return ResponseEntity.ok(userservice.createUser(userRequest));

    }

}
