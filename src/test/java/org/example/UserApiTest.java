package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class UserApiTest {

    /**
     * Получение Bearer токена
     * @return Токен
     */
    public String getAuthToken() {
        Response response = RestAssured.given()
                .contentType(ContentType.URLENC)
                .body(PropertyConfig.getProperty("userAdmin.properties", "admin.formData"))
                .when()
                .post(PropertyConfig.getProperty("userEndpoints.properties", "auth.url"))
                .then()
                .statusCode(200)
                .extract()
                .response();

        return response.path("access_token");
    }

    @Test(description = "Тест получения имени пользователя")
    public void testGetCurrentUser() {
        String token = getAuthToken();
        RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get(PropertyConfig.getProperty("userEndpoints.properties", "getMe.url"))
                .then()
                .statusCode(200)
                .body("username", equalTo(PropertyConfig.getProperty("userAdmin.properties", "admin.username")));
    }

    @Test(description = "Тест получения имени пользователя с неправильным токеном")
    public void testGetCurrentUserWrongToken() {
        String token = getAuthToken();
        RestAssured.given()
                .header("Authorization", "Bearer " + token + "123")
                .when()
                .get(PropertyConfig.getProperty("userEndpoints.properties", "getMe.url"))
                .then()
                .statusCode(401);
    }

    @Test(description = "Тест создания пользователя")
    public void testCreateUser() {
        String token = getAuthToken();
        RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.URLENC)
                .formParam("username", "user3")
                .formParam("password", "password3")
                .when()
                .post(PropertyConfig.getProperty("userEndpoints.properties", "userCreate.url"))
                .then()
                .statusCode(200);

    }

    @Test(description = "Тест создания пользователя без токена")
    public void testCreateUserWithoutToken() {
        RestAssured.given()
                .contentType(ContentType.URLENC)
                .formParam("username", "user1")
                .formParam("password", "password1")
                .when()
                .post(PropertyConfig.getProperty("userEndpoints.properties", "userCreate.url"))
                .then()
                .statusCode(401);

    }
}