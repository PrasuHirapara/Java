package com.prasu.microservice.inventory_service;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.testcontainers.mysql.MySQLContainer;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InventoryServiceApplicationTests {

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
	void shouldReadInventory() {
        boolean trueResponse = RestAssured.given()
                .when()
                .get("/api/inventory?skuCode=iphone_15&quantity=50")
                .then()
                .log().all()
                .statusCode(HttpStatus.OK.value())
                .extract().response().as(Boolean.class);

        assertTrue(trueResponse);

        boolean falseResponse = RestAssured.given()
                .when()
                .get("/api/inventory?skuCode=iphone_15&quantity=500")
                .then()
                .log().all()
                .statusCode(HttpStatus.OK.value())
                .extract().response().as(Boolean.class);

        assertFalse(falseResponse);
	}

}
