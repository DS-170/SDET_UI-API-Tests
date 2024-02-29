package api;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Methods {
    public static RequestSpecification request() {
        return new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/api/")
                .setContentType(ContentType.JSON)
                .build();
    }

    public static int getTotalPages() {

        return given()
                .spec(request())
                .when()
                .get("users")
                .then()
                .extract()
                .jsonPath()
                .getInt("total_pages");
    }


    @Step("Поиск пользователя с именем {firstName} и фамилией {lastName}")
    public static String findUserByName(String firstName, String lastName) {
        String userEmail;
        int i = 1;
        do {
            userEmail = given()
                    .spec(request())
                    .queryParam("page", String.valueOf(i))
                    .when()
                    .get("users")
                    .then()
                    .extract()
                    .jsonPath()
                    .getString("data.findAll {data -> data.first_name == '" + firstName + "' && data.last_name == '" + lastName + "'}.email");
            i++;
        }
        while (userEmail.equals("[]") && i <= getTotalPages());
        return userEmail;

    }
}
