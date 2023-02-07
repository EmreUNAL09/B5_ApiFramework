package apiTest.day05;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class DevExTestHamcrestMacthers {

    @BeforeClass
    public void beforeClass(){
        baseURI = "http://eurotech.study";
        String devExUrl = "http://eurotech.study";

    }
    @Test
    public void getOneUser(){
        /* Task
        Given accept content type application json
        And query param id 528
        When user sends GET request to /api/profile/userQuery
        Then status code is 200
         */
        given().accept(ContentType.JSON)
                .queryParam("id",528)
                .when().get("/api/profile/userQuery")
                .then().statusCode(200)
                .and().assertThat().contentType("application/json; charset=utf-8");
    }

    @Test
    public void getOneUserHamcrestMacthers(){
        given().accept(ContentType.JSON)
                .queryParam("id",528)
                .when().get("/api/profile/userQuery")
                .then().assertThat().statusCode(200)
                .and().assertThat().contentType("application/json; charset=utf-8")
                .and().assertThat().body("id", equalTo(528),
                                    "email", equalTo("eurotech@gmail.com"),
                                            "name", equalTo("Teacher"),
                                            "company",equalTo("Eurotech Study"),
                                            "status", equalTo("Instructor"),
                                            "profileId", equalTo(276));
    }

    @Test
    public void hamcrest2(){
        given().accept(ContentType.JSON)
                .queryParam("id",25)
                .when()
                .log().all()
                .get("api/profile/userQuery")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .header("Content-Type",equalTo("application/json; charset=utf-8"))
                .and()
                .header("ETag",equalTo("W/\"71-gLRrgzE02ZoB4TdrNnm1Irq0Rhc\""))
                .and()
                .header("Date",notNullValue())
                .assertThat()
                .body("id",equalTo(25),
                        "name",equalTo("Jr. Dev"),
                        "email",equalTo("jrdev@gmail.com")).log().all();
    }

    @Test
    public void hamcrestBodyTest3(){
        given().accept(ContentType.JSON)
                .when().log().all()
                .get("/api/profile")
                .then().assertThat().statusCode(200)
                .and().contentType("application/json; charset=utf-8")
                .and().body("user.email",hasItem("talisca@gmail.com")).log().all();

    }

    @Test
    public void hamcrestBodyTest4(){
        /*
        * Rashid
        * Eminem
        * arianaGrande
        * yslvester
        * */
        given().accept(ContentType.JSON)
                .when().log().all()
                .get("/api/profile")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .contentType("application/json; charset=utf-8")
                .and()
                .body("user.name",hasItems("Rashid","Eminem","arianaGrande","sylvester"))
                .log().all();

    }

    @Test
    public void hamcrestBodyTest5(){
        given().accept(ContentType.JSON)
                .when()
                .log().all()
                .get("/api/profile")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .assertThat()
                .body("company[1]",equalTo("Eurotech"), "skills[1][4]",equalTo("API"));

    }






}
