package apiTest.day03;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.testng.Assert.*;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetDevEx {

    /*
        Given accept type is Json
        When user send GETS request to /api/profile
        Then verify that response status code is 200
        and verify that body contains "Microsoft"
         */

    String devExUrl = "http://eurotech.study";

    @Test
    public void test1(){
        Response response = RestAssured.given()
                .accept(ContentType.JSON)
                .when()
                .get(devExUrl + "/api/profile");

        assertEquals(response.statusCode(),200);

        assertTrue(response.body().asString().contains("Microsoft"));

    }

    @Test
    public void test2(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get(devExUrl + "/api/profile");

        System.out.println("response.header(\"Content-Type\") = " + response.header("Content-Type"));
        System.out.println("response.header(\"Content-Length\") = " + response.header("Content-Length"));

        assertEquals(response.header("Content-Type"),"application/json; charset=utf-8");
        assertEquals(response.header("Content-Length"),"278733");

        //Date bütün headerler içinde var mı kontrol ettik.
        assertTrue(response.headers().hasHeaderWithName("Date"));

    }
}
