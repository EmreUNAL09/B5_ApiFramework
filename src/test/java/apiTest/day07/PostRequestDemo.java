package apiTest.day07;

import io.restassured.http.ContentType;

import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

public class PostRequestDemo {
    /* Task
    Given accept type and Content type is JSON
    And request JSON body is
    {
  "email": "usain@eurotech.com",
  "password": "Test1234",
  "name": "Usain",
  "google": "UsainG",
  "facebook": "UsainF",
  "github": "Usain21"
}
    When user send POST request to 'api/users'
    Then status code 200
    And token should be created
     */

    @BeforeClass
    public void beforeClass() {
        baseURI = "http://eurotech.study";
    }

    @Test
    public void postNewUser() {
        String jsonBody = "{\n" +
                "  \"email\": \"usain@eurotech.com\",\n" +
                "  \"password\": \"Test1234\",\n" +
                "  \"name\": \"Usain\",\n" +
                "  \"google\": \"UsainG\",\n" +
                "  \"facebook\": \"UsainF\",\n" +
                "  \"github\": \"Usain22\"\n" +
                "}";
        Response response = given().accept(ContentType.JSON)  //hey json send me body as json format
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(jsonBody)
                .when()
                .post("api/users");

        assertEquals(response.statusCode(),200);
        response.prettyPrint();
        assertTrue(response.body().asString().contains("token"));

    }

    @Test
    public void postNewUser2(){
        Map<String,Object> requestMap = new HashMap<>();
        requestMap.put("email", "usain@eurotech.net");
        requestMap.put("password", "Test1234");
        requestMap.put("name", "Usain");
        requestMap.put("google", "UsainG");
        requestMap.put("facebook", "UsainF");
        requestMap.put("github", "Usain23");

        Response response = given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(requestMap)  //serialization  java kodunun jsona dönüştürülmesi
                .when()
                .post("api/users");

        assertEquals(response.statusCode(),200);
        response.prettyPrint();
        assertTrue(response.body().asString().contains("token"));
    }

    @Test
    public void postNewUser3() {

        NewUserInfo newUserInfo = new NewUserInfo();

        newUserInfo.setEmail("usain@eurotech.set");
        newUserInfo.setPassword("Test1234");
        newUserInfo.setName("UsainSet");
        newUserInfo.setGoogle("UsainG");
        newUserInfo.setFacebook("UsainF");
        newUserInfo.setGithub("Usain24");

        Response response = given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(newUserInfo) //serialization  java kodunun jsona dönüştürülmesi
                .when()
                .post("api/users");

        assertEquals(response.statusCode(),200);
        response.prettyPrint();
        assertTrue(response.body().asString().contains("token"));

    }

    @Test
    public void postNewUser4(){
        NewUserInfo newUserInfo = new NewUserInfo("usain@eurotech.con",
                "Test1234","UsainCons","UsainG","UsainF","Usain25");

        Response response = given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(newUserInfo) //serialization  java kodunun jsona dönüştürülmesi
                .when()
                .post("api/users");

        assertEquals(response.statusCode(),200);
        response.prettyPrint();
        assertTrue(response.body().asString().contains("token"));


    }
}
