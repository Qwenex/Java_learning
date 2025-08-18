package org.example;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import java.io.File;

public class PersonApiTest {

    private final static String URL = "http://localhost:8093/";
    private final static String BASE_PATH = "api/person/";
    private final static String GET_PERSON = "get";
    private final static String GET_ALL_PERSON = "get-all";
    private final static String ADD_PERSON = "add";
    private final static String JSON_SCHEMA = "src/test/resources/jsonSchema/person.json";

    @Test(description = "Получение всех пользователей")
    public void getAllUsers() {
        RestAssured
                .given()
                .when()
                    .get(URL + BASE_PATH + GET_ALL_PERSON)
                .then()
                    .statusCode(200)
                    .extract()
                    .response()
                    .body()
                    .print();
    }

    @Test(description = "Проверка первого пользователя под соответсвие JsonSchema")
    public void checkFirstUser() {
        RestAssured
                .given()
                    .queryParam("id", 1)
                .when()
                    .get(URL + BASE_PATH + GET_PERSON)
                .then()
                    .statusCode(200)
                    .assertThat()
                    .body(JsonSchemaValidator.matchesJsonSchema(new File(JSON_SCHEMA)))
                    .extract()
                    .response()
                    .body()
                    .print();
    }

    @Test(description = "Добавление нового пользователя")
    public void addNewUser() {
        RestAssured
                .given()
                    .contentType("application/json")
                    .body("{\"first_name\": \"Ассур\"," +
                            "\"second_name\": \"Бодивич\"," +
                            "\"third_name\": \"Тестовян\"," +
                            "\"age\": \"56\"," +
                            "\"phone\": \"8 921 123 45 67\"," +
                            "\"nationality\": \"Армянин\"}"
                    )
                .when()
                    .post(URL + BASE_PATH + ADD_PERSON)
                .then()
                    .statusCode(200);
    }

}