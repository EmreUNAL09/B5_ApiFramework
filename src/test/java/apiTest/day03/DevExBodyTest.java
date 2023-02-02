package apiTest.day03;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DevExBodyTest {

    String devExUrl = "http://eurotech.study";
    String petURl ="https://petstore.swagger.io/v2";

    @Test
    public void devExVerifyWithPath() {

        /*
        Verify that all information
        "id": 681,
    "email": "instructorihsan@eurotech.com",
    "name": "Ihsan",
    "company": "EuroTech",
    "status": "Instructor",
    "profileId": 402
        */

        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().queryParam("id", 681)
                .when().get(devExUrl + "/api/profile/userQuery");

        assertEquals(response.statusCode(),200);
        response.prettyPrint();

        System.out.println("response.path(\"id\") = " + response.path("id"));
        System.out.println("response.path(\"email\") = " + response.path("email"));
        System.out.println("response.path(\"name\") = " + response.path("name"));
        System.out.println("response.path(\"company\") = " + response.path("company"));
        System.out.println("response.path(\"status\") = " + response.path("status"));
        System.out.println("response.path(\"profileId\") = " + response.path("profileId"));

        int actualId= response.path("id");
        assertEquals(actualId,681);
        assertEquals(response.path("email"),"instructorihsan@eurotech.com");
        assertEquals(response.path("name"),"Ihsan");
        assertEquals(response.path("company"),"EuroTech");
    }

    @Test
    public void petStoreVerifyWithPet(){

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

        // response.prettyPrint();

    }
}
