package apiTest.day04;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Task {

    /*
        Given accept type is json
        And query param 29
        Status code 200
        Content Type application Json
        verify user information with using JsonPath
        {
    "id": 29,
    "email": "oyku@gmail.com",
    "name": "oyku",
    "company": "Microsoft",
    "status": "Student or Learning",
    "profileId": 11
}
         */
    String devExUrl = "http://eurotech.study";

    @Test
    public void test1() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().queryParam("id", 29)
                .when().get(devExUrl + "/api/profile/userQuery");

        assertEquals(response.statusCode(),200);
        response.prettyPrint();

        System.out.println("response.path(\"email\") = " + response.path("email"));


        System.out.println("****************** JSON PATH METHOD **************************");

        JsonPath jsonData = response.jsonPath();

        int userId = jsonData.getInt("id");
        System.out.println("userId = " + userId);

        int idJson = jsonData.getInt("id");
        String emailJson = jsonData.getString("email");
        String nameJson = jsonData.getString("name");
        String companyJson = jsonData.getString("company");
        String statusJson = jsonData.getString("status");
        int profileIdJson = jsonData.getInt("profileId");

        System.out.println("idJson = " + idJson);
        System.out.println("emailJson = " + emailJson);
        System.out.println("nameJson = " + nameJson);
        System.out.println("companyJson = " + companyJson);
        System.out.println("statusJson = " + statusJson);
        System.out.println("profileIdJson = " + profileIdJson);


    }





}
