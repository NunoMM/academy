package com.ctw.workstation.simple;

import org.junit.jupiter.api.Assertions;
//import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

class HelloAcademyTest {

    public static Stream<Arguments> hello_academy_valid_name() {
        return Stream.of(
                Arguments.of("Hello Dreamcast Academy", "Dreamcast Academy"),
                Arguments.of("Hello ", ""),
                Arguments.of("Hello", null)
        );
    }

    @ParameterizedTest
    @MethodSource
    void hello_academy_valid_name(String expected, String name) {
        //Given
        HelloAcademyExt helloAcademy = new HelloAcademyExt();

        // When
        String result = helloAcademy.sayHello(name);

        // Then
        //Assertions.assertEquals(expected, result);

        List<String> list = List.of("Hello Dreamcast Academy", "Hello", "");
        //Assertions.assertThat(result)
        //        Assertions.allSatisfy(texto -> assertThat())

    }

    @Test
    void hello_academy_null_name() {
        //Given
        String name = null;
        HelloAcademyExt helloAcademy = new HelloAcademyExt();

        // When
        String result = helloAcademy.sayHello(name);

        // Then
        Assertions.assertEquals("Hello", result);
    }

    @Test
    void hello_academy_invalid_name() {
        //Given
        String name = "";
        HelloAcademyExt helloAcademy = new HelloAcademyExt();

        // When
        String result = helloAcademy.sayHello(name);

        // Then
        Assertions.assertEquals("Hello ", result);
    }


}