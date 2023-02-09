package apiTest.day08;

import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PutRequestDemo {
    @BeforeClass
    public void beforeClass() {
        baseURI = "http://eurotech.study";
    }

    @Test
    public void addNewExperience() {

        /*
        {
  "title": "string",
  "company": "string",
  "location": "string",
  "from": "YYYY-MM-DD",
  "to": "YYYY-MM-DD",
  "current": false,
  "description": "string"
}
         */

        Map<String,Object> experienceBody = new HashMap<>();

        experienceBody.put("title", "Director");
        experienceBody.put("company", "Getir");
        experienceBody.put("location", "Aydin");
        experienceBody.put("from", "2007-01-02");
        experienceBody.put("to", "2008-02-10");
        experienceBody.put("current", false);
        experienceBody.put("description", "Ne yoruldu o zamanlar");

        given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .header("x-auth-token",Authorization.getToken())
                .and()
                .body(experienceBody)
                .when()
                .post("/api/profile/experience")
                .then().assertThat().statusCode(201);

    }

    @Test
    public void updateExperiencePutMethod() {
        Map<String,Object> experienceBody = new HashMap<>();

        experienceBody.put("title", "CEO");
        experienceBody.put("company", "Götür");
        experienceBody.put("location", "Ankara/Fener");
        experienceBody.put("from", "2007-01-02");
        experienceBody.put("to", "2008-02-10");
        experienceBody.put("current", false);
        experienceBody.put("description", "Çok yoruldu o zamanlar");

        given().log().all()
                .and()
                .contentType(ContentType.JSON)
                .and()
                .headers(Authorization.getAccessToken("emre@gmail.com","Test12345!"))
                .and()
                .body(experienceBody)
                .when()
                .put("/api/profile/experience/372")
                .then()
                .log().all()
                .assertThat().statusCode(204);

    }

    @Test
    public void upDateExperiencePATCHMethod() {

        Map<String,Object> experienceBody = new HashMap<>();

        experienceBody.put("title", "PATCH_CEO");
        experienceBody.put("company", "Getir_Götür");

        given().log().all()
                .and()
                .contentType(ContentType.JSON)
                .and()
                .headers(Authorization.getAccessToken("emre@gmail.com","Test12345!"))
                .and()
                .pathParam("id", 372)
                .and()
                .body(experienceBody)
                .when()
                .patch("/api/profile/experience/{id}")
                .then()
                .log().all()
                .assertThat().statusCode(204);

    }

    @Test
    public void deleteExperienceDELETE() {
        given().log().all()
                .and()
                .contentType(ContentType.JSON)
                .and()
                .header("x-auth-token",Authorization.getToken())
                .pathParam("id",372)
                .and()
                .delete("/api/profile/experience/{id}")
                .then()
                .log().all()
                .assertThat().statusCode(200);
    }
}
