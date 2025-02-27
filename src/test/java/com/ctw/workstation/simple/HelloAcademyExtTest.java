package com.ctw.workstation.simple;

import org.apache.commons.lang3.NotImplementedException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class HelloAcademyExtTest {

    @Spy
    ExternalMessageService externalMessageServiceSpy;

    @Mock
    ExternalMessageService externalMessageService;

    @InjectMocks
    HelloAcademyExt helloAcademyExt;

    /*
    @Test
    @DisplayName("Hello from outer space")
    void hello_from_outer_space() {

        // Given
        String name = "Nuno";

        // Mock config
        Mockito.when(externalMessageService.sayHelloFromOuterSpace())
                .thenThrow(new NotImplementedException("This feature is not yet implemented. Please contact support"));


        //Mockito.when(externalMessageServiceSpy.sayHelloFromOuterSpace(Mockito.anyString()))
        //        .thenReturn("Hello %s from outer space".formatted(name));


        // When
        String result = helloAcademyExt.sayHello(null);

        // Then
        assertThat(result).isEqualTo("Hello Nuno from outer space");
    }

    @Test
    @DisplayName("Hello from outer space")
    void hello_from_outer_space_spy() {

        // Given

        String name = "Nuno";

        // Spy config

        Mockito.doReturn("Hello World")
                .when(externalMessageServiceSpy).sayHelloFromOuterSpace();

        // When
        String result = helloAcademyExt.sayHello(name);

        // Then
        assertThat(result).isEqualTo("Hello World");
    }


     */
}