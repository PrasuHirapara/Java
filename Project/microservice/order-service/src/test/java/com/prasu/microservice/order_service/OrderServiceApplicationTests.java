package com.prasu.microservice.order_service;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.mysql.MySQLContainer;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderServiceApplicationTests {

    @ServiceConnection
    static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.3.0");
    @LocalServerPort
    int port;

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    static {
        mySQLContainer.start();
    }

	@Test
	void shouldCreateOrder() {
        String payload = """
                {
                    "skuCode": "iphone_15",
                    "price": 10000,
                    "quantity": 1
                }
                """;

        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post("/api/order")
                .then()
                .statusCode(201)
                .body("skuCode", Matchers.equalTo("iphone_15"));
	}

}
