package apiTest.day07;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;
import static org.hamcrest.Matchers.*;

public class Task {
    @BeforeClass
    public void beforeClass() {
        baseURI="http://eurotech.study";
    }

    @Test
    public void postCreateNewUser() {
        String jsonRegisterBody = "{\n" +
                "  \"email\": \"task_email@emre.com\",\n" +
                "  \"password\": \"Test1234\",\n" +
                "  \"name\": \"ElifZeynep_task\",\n" +
                "  \"google\": \"googleEmre_task\",\n" +
                "  \"facebook\": \"facebookEmre_task\",\n" +
                "  \"github\": \"githubEmre_task\"\n" +
                "}";
        Response response = given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(jsonRegisterBody)
                .when()
                .post("api/users");
        assertEquals(response.statusCode(), 200);
        assertTrue(response.body().asString().contains("token"));

        String token = response.path("token");

        String jsonProfileBody = "{\n" +
                "  \"company\": \"task_company\",\n" +
                "  \"website\": \"task_web\",\n" +
                "  \"location\": \"task_Aydin\",\n" +
                "  \"status\": \"task_status\",\n" +
                "  \"skills\": \"HTML,CSS,Javascript\",\n" +
                "  \"githubusername\": \"task_github\",\n" +
                "  \"youtube\": \"task_youtube\",\n" +
                "  \"twitter\": \"task_twitter\",\n" +
                "  \"facebook\": \"task_face\",\n" +
                "  \"linkedin\": \"task_linkedin\",\n" +
                "  \"instagram\": \"task_insta\"\n" +
                "}";

        response = given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .header("x-auth-token", token)
                .body(jsonProfileBody)
                .when()
                .post("api/profile");
        assertEquals(response.statusCode(), 200);

    }

        @Test
        public void testName() {


            // VERIFY
            //int id = response.path("user.id");
            Response response = given().accept(ContentType.JSON)
                    .and()
                    .queryParam("name", "ElifZeynep_task")
                    .when()
                    .get("api/profile/userQuery");
            assertEquals(response.statusCode(), 200);

            assertEquals(response.path("company"), "task_company");
            //assertEquals(response.path("website"), "task_web");
            //assertEquals(response.path("location"), "task_Aydin");
            assertEquals(response.path("status"), "task_status");
            //assertEquals(response.path("skills"), "HTML,CSS,Javascript");
            //assertEquals(response.path("githubusername"), "task_github");
//            assertEquals(response.path("youtube"), "task_youtube");
//            assertEquals(response.path("twitter"), "task_twitter");
//            assertEquals(response.path("facebook"), "task_face");
//            assertEquals(response.path("linkedin"), "task_linkedin");
//            assertEquals(response.path("instagram"), "task_insta");

            given().accept(ContentType.JSON)
                    .and()
                    .queryParam("name", "ElifZeynep_task")
                    .when()
                    .get("api/profile/userQuery")
                    .then()
                    .assertThat()
                    .body("email", equalTo("task_email@emre.com"),
                            "name", equalTo("ElifZeynep_task"))

//                    .body("email", equalTo("task_email@emre.com"),
//                            "password", equalTo("Test1234"),
//                            "name", equalTo("ElifZeynep_task"),
//                            "google", equalTo("googleEmre_task"),
//                            "facebook", equalTo("facebookEmre_task"),
//                            "github", equalTo("githubEmre_task"))
                    .log().all();

    }
}
