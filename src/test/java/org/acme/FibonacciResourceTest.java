package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class FibonacciResourceTest {

    @Test
    public void testCalculateFibonacciEndpoint() {
        given()
            .when().get("/fibonacci/{number}", 5)
            .then()
            .statusCode(200)
            .contentType(ContentType.TEXT)
            .body(is("5"));
    }

    @Test
    public void testCalculateFibonacciEndpointWithNegativeInput() {
        given()
            .when().get("/fibonacci/{number}", -1)
            .then()
            .statusCode(500); // Expecting Bad Request status for negative input
    }
}
