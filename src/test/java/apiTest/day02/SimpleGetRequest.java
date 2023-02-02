package apiTest.day02;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleGetRequest {

    //Gerkin language sintaxını kullanıyoruz (given,when,then...)

    String devExUrl = "http://eurotech.study";

    @Test
    public void test1() {
        Response response = RestAssured.get(devExUrl + "/api/profile");

        //print status code
        System.out.println("response.statusCode() = " + response.statusCode());

        //print body
        response.prettyPrint();
    }

    @Test
    public void test2() {
        Response response = RestAssured.given()
                .accept(ContentType.JSON)
                .when()
                .get(devExUrl + "/api/profile");
        System.out.println("response.statusCode() = " + response.statusCode());

        //Status Code Assertion
        Assert.assertEquals(response.statusCode(),200);
        //response.prettyPrint();

        Assert.assertEquals(response.contentType(),"application/json; charset=utf-8");
    }

    @Test
    public void test3(){
        //Verify test case with using RestAssured Library
        RestAssured.given()
                .accept(ContentType.JSON)
                .when()
                .get(devExUrl+"/api/profile")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .contentType("application/json; charset=utf-8");
    }

    @Test
    public void test4(){
        //Verify that body has Stephen Curry
        Response response = RestAssured.given()
                .accept(ContentType.JSON)
                .when()
                .get(devExUrl + "/api/profile");

        Assert.assertEquals(response.statusCode(),200);

        //System.out.println("response.body().asString() = " + response.body().asString());

        //Contains method
        Assert.assertTrue(response.body().asString().contains("Stephen Curry"));

    }
}
