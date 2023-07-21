package com.essai.testautomation;

import com.essai.testautomation.model.rest.postuser.PostUserRequest;
import com.essai.testautomation.utils.PropertyStore;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import static com.essai.testautomation.utils.GlobalConstants.QUERY_PARAM_PAGE;
import static io.restassured.RestAssured.given;

public class ReqResApi {

    private static final String URL = PropertyStore.getProperty("reqresapi.url", "reqresapi.properties");
    private static final String USERS_URL = "/api/users";

    public static Response getUsers(int pageNum) {
        return given()
                .baseUri(URL)
                .queryParam(QUERY_PARAM_PAGE, pageNum)
                .when()
                .get(USERS_URL)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().ifValidationFails()
                .extract().response();
    }

    public static Response postUser(PostUserRequest request) {

        return given()
                .baseUri(URL)
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .post(USERS_URL)
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .log().ifValidationFails()
                .extract().response();
    }


}
