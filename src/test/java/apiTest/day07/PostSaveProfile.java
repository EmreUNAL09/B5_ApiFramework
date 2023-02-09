package apiTest.day07;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;
import static org.hamcrest.Matchers.*;

public class PostSaveProfile {
    @BeforeClass
    public void beforeClass() {
        baseURI = "http://eurotech.study";
    }

    @Test
    public void postNewUser(){
        //Create new user
        //Verify with token
        //Save user profile with using token

        NewUserInfo newUserInfo = new NewUserInfo("usainprofile@eurotech.con",
                "Test1234","UsainProfile","UsainG","UsainF","Usain25");

        Response response = given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .body(newUserInfo)
                .when()
                .post("api/users");
        assertEquals(response.statusCode(),200);
        assertTrue(response.body().asString().contains("token"));

        String token = response.path("token");

        String profileBody = "{\n" +
                "  \"company\": \"EurotechB5\",\n" +
                "  \"website\": \"euroTech@study.net\",\n" +
                "  \"location\": \"Aydin\",\n" +
                "  \"status\": \"Jr. QA\",\n" +
                "  \"skills\": \"HTML,CSS,Javascript\",\n" +
                "  \"githubusername\": \"B5gitHub\",\n" +
                "  \"youtube\": \"B5youtube\",\n" +
                "  \"twitter\": \"B5twitter\",\n" +
                "  \"facebook\": \"string\",\n" +
                "  \"linkedin\": \"string\",\n" +
                "  \"instagram\": \"string\"\n" +
                "}";

        response = given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .header("x-auth-token",token)
                .body(profileBody)
                .when()
                .post("api/profile");

        assertEquals(response.statusCode(),200);
        response.prettyPrint();

    }

    @Test
    public void postNewUserAndVerify() {
        String email = "fb@fener.com";
        String password = "Test1234";
        String name = "Jardel";
        String google = "jgoogle";
        String facebook = "jface";
        String github = "jgithub";

        String company = "Simens";

        Map<String,Object> requestMap = new HashMap<>();
        requestMap.put("email",email);
        requestMap.put("password",password);
        requestMap.put("name",name);
        requestMap.put("google",google);
        requestMap.put("facebook",facebook);
        requestMap.put("github",github);

        Response response = given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(requestMap)
                .when()
                .post("api/users");
        assertEquals(response.statusCode(),200);

        String token = response.path("token");

        Map<String,Object> profileBody = new HashMap<>();
        profileBody.put("company",company);
        profileBody.put("website","b");
        profileBody.put("location","c");
        profileBody.put("status","d");
        profileBody.put("skills","e");
        profileBody.put("githubusername","f");
        profileBody.put("youtube","g");
        profileBody.put("twitter","h");
        profileBody.put("facebook","i");
        profileBody.put("linkedin","j");
        profileBody.put("instagram","k");

        response = given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .header("x-auth-token",token)
                .body(profileBody)
                .when()
                .post("api/profile");

        assertEquals(response.statusCode(),200);

        //Verify body
        int id = response.path("user.id");
        response = given().accept(ContentType.JSON)
                .and()
                .queryParam("id", id)
                .when()
                .get("api/profile/userQuery");
        assertEquals(response.statusCode(),200);

        //Verify with path
        assertEquals(response.path("name"), name);
        assertEquals(response.path("company"),company);

        //Verify using hamcrest matchers
        given().accept(ContentType.JSON)
                .and()
                .queryParam("id", id)
                .when()
                .get("api/profile/userQuery")
                .then()
                .assertThat()
                .body("email", Matchers.equalTo(email),"company",Matchers.equalTo(company))
                .log().all();


        //TASK

        //register new user
        //save new user profile
        //verify user informations using JSONPATH and Hamcrest Matcher
        //at least 2 different user



    }
}
