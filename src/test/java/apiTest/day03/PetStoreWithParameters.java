package apiTest.day03;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.testng.Assert.*;

import org.testng.annotations.Test;

public class PetStoreWithParameters {

//    @BeforeClass
//    public void beforeClass(){
//        baseURI="http://eurotech.study";
//    }
//
//    @Test
//    public void testName(){
//        Response response = RestAssured.get("/api/profile");
//        response.prettyPrint();
//    }

    String petURl = "https://petstore.swagger.io/v2";

    @Test
    public void pathParamPetStore(){

        //First Way
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get(petURl + "/pet/13");

        response.prettyPrint();
        assertEquals(response.statusCode(),200);
    }
    @Test
    public void pathParamPet2(){
        //Second Way

        int petID = 13;

        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id", petID)   // Path Param içindeki string tanımlama key ile get kısmında süslü
                // parantez içinde bulunan key birbirini tam olarak karşılamalıdır.
                .when().get(petURl + "/pet/{id}");

        assertEquals(response.statusCode(),200);

    }

}
