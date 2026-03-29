package api.enpoints;

import api.payload.User;
import api.utilities.ConfigReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class UserEndPoints {
    public static Response createUser(User payload) {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + ConfigReader.getProperty("token"))
                .body(payload)
                .when()
                .post(Routes.post_url);
        return response;
    }

    public static Response readUser(int  id) {
        Response response = given()
                .pathParams("id",id)
                .when()
                .get(Routes.get_url);
        return response;
    }

    public static Response updateUser(int id, User payload) {
        Response response = given()
                .pathParams("id", id)
                .body(payload)
                .header("Authorization", "Bearer " + ConfigReader.getProperty("token"))
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .put(Routes.put_url);
        return response;

    }
    public static Response deleteUser(int id){
        Response response = given()
                .pathParams("id",id)
                .header("Authorization", "Bearer " + ConfigReader.getProperty("token"))
                .when()
                .delete(Routes.delete_url);
        return response;
    }


}
