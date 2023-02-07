package apiTest.day05;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static org.testng.AssertJUnit.assertEquals;

public class JsonToJavaCollection {
    @BeforeClass
    public void beforeClass(){
        baseURI = "http://eurotech.study";
    }

    @Test
    public void test1(){
        Response response = given().accept(ContentType.JSON)
                .and()
                .queryParam("id", 25)
                .when()
                .get("/api/profile/userQuery");
        assertEquals(response.statusCode(),200);

        //Converting json to java
        Map<String,Object> jsonDataMap = response.body().as(Map.class);
        System.out.println("jsonDataMap = " + jsonDataMap);

    }

    @Test
    public void test2() {
        Response response = get("/api/profile");
        assertEquals(response.statusCode(),200);

        //de-serialization
        List<Map<String,Object>> allBody = response.body().as(List.class);
        System.out.println("allBody = " + allBody);

        //print and verify
        System.out.println("allBody.get(3).get(\"company\") = " + allBody.get(3).get("company"));

        String expectedCompany ="Al-Hilal";
        String actualCompany = (String) allBody.get(3).get("company");
        assertEquals(actualCompany,expectedCompany);

        Map<String,Object> secondUserInfo = allBody.get(1);
        System.out.println("secondUserInfo = " + secondUserInfo);
    }

    @Test
    public void getOneUser() {
        Response response = get("/api/profile");
        assertEquals(response.statusCode(),200);

        List<Map<String,Object>> allBody = response.body().as(List.class);

        //verify ... users detail
        Map<String,Object> userTestAccount = (Map<String,Object>) allBody.get(1).get("user");
        System.out.println("userTestAccount = " + userTestAccount);

        assertEquals(userTestAccount.get("id"),37.0);
        assertEquals(userTestAccount.get("email"),"testaccount@gmail.com");
        assertEquals(userTestAccount.get("name"),"TestAccount");

        allBody.get(1).get("company");
        String actualCompany = (String) allBody.get(1).get("company");

        assertEquals(actualCompany,"Eurotech");

    }
}
