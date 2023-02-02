package apiTest.day03;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class Task {

    @Test
    public void petStoreVerifyWithPet(){

        String petURl ="https://petstore.swagger.io/v2";

 /*  TASK https://petstore.swagger.io/#/pet/findPetsByStatus
        Given accept content type Json
        And path param is 70068092
        When user GET s request to /pet/70068092
        Then verify response code is 200
        verify id is 70068092
        verify name is "doggie"
         */

        int petID = 70068092;

        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("ID", petID)
                .when().get(petURl + "/pet/{ID}");

        assertEquals(response.statusCode(),200);

        int actualId = response.path("id");
        assertEquals(actualId,70068092);

        assertTrue(response.body().asString().contains("doggie"));

        //response.prettyPrint();

    }
}
