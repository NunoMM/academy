package com.ctw.workstation.simple;

import com.ctw.workstation.config.CtwAcademyResource;
import com.ctw.workstation.config.CtwAcademyTestProfile;
import com.ctw.workstation.config.WiremockResource;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import jakarta.inject.Inject;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@TestProfile(CtwAcademyTestProfile.class)
class HelloAcademyExtApiTest {

    @Inject
    HelloAcademyExt helloAcademyExt;

    /*
    @Test
    @DisplayName("Saying hello to external api")
    void hello_external_api() {

        // given
        String name = "Nuno";

        // when
        String result = helloAcademyExt.sayHello(name);
        // then
        assertThat(result).isEqualTo("Hello Nuno!");

    }

     */


}