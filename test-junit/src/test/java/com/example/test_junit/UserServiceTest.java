package com.example.test_junit;

import com.example.test_junit.model.User;
import com.example.test_junit.repo.UserRepo;
import com.example.test_junit.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.mockito.Mockito.when;

public class UserServiceTest {
    @Mock
    UserRepo userRepo;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void initialize() {
        MockitoAnnotations.initMocks(this);
    }

    @ParameterizedTest
    @CsvSource({
            "1",
            "2"
    })
    public void getUserTest(int id) {
        when(userRepo.findById(ArgumentMatchers.anyInt())).thenReturn(Optional.of(new User(id, "test", "test")));
        User u = userService.getUser(id).getBody();
        Assertions.assertNotNull(u);
    }
}
