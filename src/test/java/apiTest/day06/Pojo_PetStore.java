package apiTest.day06;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Pojo_PetStore {
    @BeforeClass
    public void beforeClass() {
        baseURI = "https://petstore.swagger.io/v2";
    }

    @Test
    public void oneUserPetStore(){
        Response response = given().accept(ContentType.JSON)
                .and()
                .pathParam("username", "miky")
                .when()
                .get("user/{username}");
        System.out.println("response.statusCode() = " + response.statusCode());

        //Json to our Eurotech class object
        PetStoreUser oneUser = response.body().as(PetStoreUser.class);

        //print all information
        System.out.println("oneUser.getId() = " + oneUser.getId());
        System.out.println("oneUser.getEmail() = " + oneUser.getEmail());
        System.out.println("oneUser.getName() = " + oneUser.getFirstName());

        //Verify all information
        assertEquals(oneUser.getId(),9.2233720368547645E18);
        assertEquals(oneUser.getEmail() ,"mike@gmail.com");
        assertEquals(oneUser.getFirstName(), "mike");

    }
}