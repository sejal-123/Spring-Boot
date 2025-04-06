package com.example.test_junit;

import com.example.test_junit.repo.UserRepo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserRepoTest {

    @Autowired
    UserRepo userRepo;

    @Test
    public void test1() {
        assertEquals(4, 2+2);
    }

    @BeforeAll
    public static void beforeAllMethod() {
        System.out.println("This will get executed only once before executing all testcases");
    }

    @BeforeEach
    public void beforeEachMethod() {
        System.out.println("This will get executed every time before executing each testcase");
    }

    @Test
    public void testUser() {
        assertNotNull(userRepo.findAll());
        assertNotNull(userRepo.findById(1));
        assertNotNull(userRepo.findById(3));
    }

    @ParameterizedTest
    @CsvSource({
            "sejal",
            "varun",
//            "dhruv"
    })
    public void findByUsername(String name) {
        assertNotNull(userRepo.findByUsername(name));
    }

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "2,3,5",
//            "3,4,10"
    })
    public void test2(int a, int b, int expected) {
        assertEquals(expected, a+b);
    }

}
