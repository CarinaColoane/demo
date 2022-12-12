package cl.example.demoBCI.service;

import cl.example.demoBCI.entity.UserInfo;
import cl.example.demoBCI.entity.UserPhone;
import cl.example.demoBCI.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    @Autowired
    private final UserRepository userRepository;

    @Override
    public UserInfo createUser(UserInfo userRequest){

        // TODO: make validations

        List<UserPhone> phones =
                userRequest.getPhones().stream().map(userPhone -> userPhone
                        .builder()
                        .userId(userRequest)
                        .number(userPhone.getNumber())
                        .cityCode(userPhone.getCityCode())
                        .countryCode(userPhone.getCountryCode())
                        .build()).collect(Collectors.toList());
        userRequest.setPhones(phones);

        userRequest.setActive(true);

        UUID tokenUUID = UUID.randomUUID();
        userRequest.setToken(String.valueOf(tokenUUID));

        return userRepository.save(userRequest);

    }

}
