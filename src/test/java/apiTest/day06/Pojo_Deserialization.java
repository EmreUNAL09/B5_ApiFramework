package apiTest.day06;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static org.testng.AssertJUnit.assertEquals;


public class Pojo_Deserialization {

    @BeforeClass
    public void beforeClass() {
        baseURI = "http://eurotech.study";
    }

    @Test
    public void oneUserEurotech() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and()
                .queryParam("id", 528)
                .when()
                .get("/api/profile/userQuery");

        System.out.println("response.statusCode() = " + response.statusCode());

        //Json to our Eurotech class object
        EurotechUser oneUser = response.body().as(EurotechUser.class);

        //print all information
        System.out.println("oneUser.getId() = " + oneUser.getId());
        System.out.println("oneUser.getEmail() = " + oneUser.getEmail());
        System.out.println("oneUser.getName() = " + oneUser.getName());
        System.out.println("oneUser.getCompany() = " + oneUser.getCompany());
        System.out.println("oneUser.getStatus() = " + oneUser.getStatus());
        System.out.println("oneUser.getProfileId() = " + oneUser.getProfileId());

        //Verify all information
        assertEquals(oneUser.getId(),528.0);
        assertEquals(oneUser.getEmail(), "eurotech@gmail.com");
        assertEquals(oneUser.getName(), "Teacher");
        assertEquals(oneUser.getCompany(), "Eurotech Study");
        assertEquals(oneUser.getStatus(), "Instructor");
        assertEquals(oneUser.getProfileId(), 276);
    }
}
