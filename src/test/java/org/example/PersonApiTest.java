package org.example;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import java.io.File;

public class PersonApiTest {

    private final static String URL = "http://localhost:8093/";
    private final static String BASE_PATH = "api/person/";
    private final static String GET = "get";
    private final static String ADD = "add";
    private final static String JSON_SCHEMA = "src/test/resources/jsonSchema/person.json";

    @Test
    public void getALL() {
        RestAssured
                .given()
                .when()
                    .get(URL + BASE_PATH + GET + "-all")
                .then()
                    .statusCode(200)
                    .extract()
                    .response()
                    .body()
                    .print();
    }

    @Test
    public void getFirst() {
        RestAssured
                .given()
                    .queryParam("id", 1)
                .when()
                    .get(URL + BASE_PATH + GET)
                .then()
                    .statusCode(200)
                    .assertThat()
                    .body(JsonSchemaValidator.matchesJsonSchema(new File(JSON_SCHEMA)))
                    .extract()
                    .response()
                    .body()
                    .print();
    }

    @Test
    public void add() {
        RestAssured
                .given()
                    .contentType("application/json")
                    .body("{\n" +
                        "\"first_name\": \"Ассур\",\n" +
                        "\"second_name\": \"Бодивич\",\n" +
                        "\"third_name\": \"Тестовян\",\n" +
                        "\"age\": \"56\",\n" +
                        "\"phone\": \"8 921 123 45 67\",\n" +
                        "\"nationality\": \"Армянин\"\n" +
                        "}")
                .when()
                    .post(URL + BASE_PATH + ADD)
                .then()
                    .statusCode(200);
    }
}
