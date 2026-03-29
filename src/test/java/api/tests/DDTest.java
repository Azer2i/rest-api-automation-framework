package api.tests;

import api.enpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DDTest {

    @Test(priority = 1, dataProvider = "data", dataProviderClass = DataProviders.class)
    public void testPostuser(String user_id, String title, String body) {
        User userPayload = new User();
        userPayload.setUser_id(Integer.parseInt(user_id));
        userPayload.setTitle(title);
        userPayload.setBody(body);

        Response response = UserEndPoints.createUser(userPayload);
        Assert.assertEquals(response.getStatusCode(), 201);
    }
    @Test
    public void testPostUser_InvalidUser() {
        User userPayload = new User();
        userPayload.setUser_id(999999999); // mövcud deyil
        userPayload.setTitle("test");
        userPayload.setBody("test");

        Response response = UserEndPoints.createUser(userPayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 422);
    }

//    @Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
//    public void testDeleteUser(String user) {
//        Response response = UserEndPoints.deleteUser(8403588);
//        Assert.assertEquals(response.getStatusCode(), 200);
//    }
}
