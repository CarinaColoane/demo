package cl.example.demoBCI.service;

import cl.example.demoBCI.entity.UserInfo;
import cl.example.demoBCI.exception.PatternException;
import cl.example.demoBCI.exception.UserExistsException;
import cl.example.demoBCI.repository.UserRepository;
import cl.example.demoBCI.util.Validation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    @Autowired
    private final UserRepository userRepository;

    @Override
    public UserInfo createUser(UserInfo userRequest) {

        // Validation
        String email = userRequest.getEmail();
        if (!userRepository.existByEmail(email) && !Validation.isValidEmail(email))
            throw new UserExistsException("registered or bad email");

        if (!Validation.isValidPassword(userRequest.getPassword()))
            throw new PatternException("invalid password");

        if (userRequest.getPhones().size() != 0) {
            userRequest.getPhones().stream().map(phone -> {
               if (!Validation.isValidPhone(phone.getNumber()))
                   throw new PatternException("have an error entering the phone number");
                return null;
            });
        }

        // Insertion
        userRequest.setActive(true);

        UUID tokenUUID = UUID.randomUUID();
        userRequest.setToken(String.valueOf(tokenUUID));

        return userRepository.save(userRequest);
    }

}
