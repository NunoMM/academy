package com.ctw.workstation.simple;

import io.quarkus.logging.Log;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
class MathOperationsTest {

    private static MathOperations mathOperations;

    @BeforeAll
    static void beforeAll() {
        Log.info("Starting tests");
        mathOperations = new MathOperations();
    }

    @BeforeEach
    void beforeEach() {
        Log.info("After a test");
    }

    @AfterAll
    static void afterAll() {
        Log.info("Ending tests");
    }

    @AfterEach
    void afterEach() {
        Log.info("After a test");
    }

    /*
    @ParameterizedTest
    //@EmptySource
    //@NullSource
    //@NullAndEmptySource
    @ValueSource(int a = [1, 3], int b = [5, 6])
    @Order(1)
    void test_valid_add(int a, int b) {
        // Given
        // When
        // Then
        Assertions.assertEquals(7, mathOperations.add(a, b));
    }
    */

    /*
    @Test
    @Order(2)
    void test_valid_divide() {
        //Given
        int a = 3;
        int b = 3;
        MathOperations mathOperations = new MathOperations();

        // When
        int result = mathOperations.divide(a, b);

        // Then
        Assertions.assertAll(
                () -> assertEquals(5, mathOperations.divide(1, 0)));
    }
    */

    @Test
    @Order(3)
    void test_0_divide() {
        //Given
        MathOperations mathOperations = new MathOperations();

        Supplier<String> supplier = () -> "Dreamcast Academy";

        // When
        // Then
        Assertions.assertAll(
                () -> Assertions.assertThrows(ArithmeticException.class, () -> mathOperations.divide(1, 0)));
                //() -> Assertions.assertThrows(IllegalAccessError.class, () -> mathOperations.divide(1, 0)));
    }


}
