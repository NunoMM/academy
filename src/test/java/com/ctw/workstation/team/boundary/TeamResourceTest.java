package com.ctw.workstation.team.boundary;

import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.entity.TeamRequestDTO;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.bytebuddy.asm.Advice;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.*;

//assertj assertions

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestHTTPEndpoint(TeamResource.class)
class TeamResourceTest {

    private UUID teamId;

    /*
    @Test
    @DisplayName("Fetching all teams")
    @Order(3)
    void fetching_all_teams() {
        given()
            .contentType(ContentType.JSON)
        .when()
            .get("/workstation/teams")
        .then()
                //.assertThat().allSatisfy()
            .statusCode(HttpStatus.SC_OK)
            .body("size()", is(1))
            .log().all();

    }

     */

    /*
    @Test
    @DisplayName("Creating team")
    @Order(1)
    void creat_team() {

        TeamRequestDTO teamDTO = new TeamRequestDTO("string", "string", "string");

        Response response =
        given()
            .contentType(ContentType.JSON)
            .body(teamDTO)
        .when()
            .post()
        .then()
            .assertThat()
            .statusCode(HttpStatus.SC_CREATED)
            .body("id", notNullValue())
            .body("name", equalTo("string"))
            .body("product", equalTo("string"))
            .body("defaultLocation", equalTo("string")).body("createdAt", notNullValue())
            .body("modifiedAt", notNullValue())
            .body("racks", is(nullValue()))
            .log().all()
            .extract().response();

    //teamId = response.id;

    }

     */

    /*
    @Test
    @DisplayName("Fetching team with id")
    @Order(2)
    void fetching_teams_with_id() {

        given()
                    .header("Content-Type", "application/json")
                    .params("id", teamId)
                .when()
                    .get("{id}", teamId)
                .then()
                    .statusCode(200)
                    .body("id", equalTo(teamId))
                    .body("name", notNullValue())
                    .log().all();

    }
    */


}