package io.kaller.messenger;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ChatResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/chat")
          .then()
             .statusCode(200)
             .body(is("hello"));
    }

}