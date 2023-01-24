package com.foy.maxach.test.testtask.services;

import com.foy.maxach.test.testtask.exceptions.UserNotFoundException;
import com.foy.maxach.test.testtask.models.User;
import com.foy.maxach.test.testtask.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

public class UserServiceTest {

    private static UserService userService;

    @MockBean
    private static UserRepository userRepository;


    @BeforeAll
    static void setup() {
        userRepository = Mockito.mock(UserRepository.class);
        userService = new UserService(userRepository);
    }


    @Test
    void getUserById_success() {
        String id = "1";

        User sourceUser = User.builder()
                .id(id)
                .firstname("Firstname")
                .lastname("Lastname")
                .dateOfBirth("01.01.2000")
                .build();

        Mockito.doReturn(Optional.of(sourceUser))
                .when(userRepository)
                .findById(id);

        User actualUser = userService.getById(id);

        User expectedUser = User.builder()
                .id(id)
                .firstname("Firstname")
                .lastname("Lastname")
                .dateOfBirth("01.01.2000")
                .age(23)
                .build();

        Assertions.assertEquals(actualUser, expectedUser);
    }


    @Test
    void getUserById_failure() {
        String id = "1";

        Mockito.doReturn(Optional.empty())
                .when(userRepository)
                .findById(Mockito.eq(id));

        String expectedMessage = "User with id: '1' not found";

        String actualMessage = Assertions.assertThrows(UserNotFoundException.class, () ->
                userService.getById(id)).getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }

}
