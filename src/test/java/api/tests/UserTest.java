package api.tests;

import api.enpoints.UserEndPoints;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTest {
    Faker faker;
    User userpayload;

    @BeforeClass
    public void setup() {
        faker = new Faker();
        userpayload = new User();
        userpayload.setUser_id(8414031);
        userpayload.setTitle(faker.lorem().sentence());
        userpayload.setBody(faker.lorem().paragraph());
    }

    @Test(priority = 1)
    public void test_1() {
        Response response = UserEndPoints.createUser(userpayload);
        response.then().log().body();
        Assert.assertEquals(response.getStatusCode(), 201);

    }

    @Test(priority = 2)
    public void testGetTitle() {
        Response response = UserEndPoints.readUser(274960);
        response.then().log().body();
        Assert.assertEquals(response.statusCode(), 200);

    }

    @Test(priority = 3)
    public void updateUser() {
        userpayload.setTitle(faker.lorem().sentence());
        userpayload.setBody(faker.lorem().paragraph());
        Response response = UserEndPoints.updateUser(274960, userpayload);
        response.then().log().body().statusCode(200);
        Assert.assertEquals(response.getStatusCode(), 200);


    }
    @Test(priority = 4)
    public void delete(){
        Response response = UserEndPoints.deleteUser(274960);
        Assert.assertEquals(response.getStatusCode(),204);
    }


}
