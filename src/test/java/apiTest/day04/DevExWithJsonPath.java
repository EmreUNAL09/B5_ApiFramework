package apiTest.day04;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;

public class DevExWithJsonPath {

    String devExUrl = "http://eurotech.study";

    @Test
    public void test1() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().queryParam("id", 74)
                .when().get(devExUrl + "/api/profile/userQuery");

        assertEquals(response.statusCode(),200);
        response.prettyPrint();

        System.out.println("response.path(\"email\") = " + response.path("email"));


        System.out.println("****************** JSON PATH METHOD **************************");

        JsonPath jsonData = response.jsonPath();

        int userId = jsonData.getInt("id");
        System.out.println("userId = " + userId);

        String emailJson = jsonData.getString("email");
        String nameJson = jsonData.getString("name");
        String companyJson = jsonData.getString("company");
        String statusJson = jsonData.getString("status");
        int profileIdJson = jsonData.getInt("profileId");

        System.out.println("emailJson = " + emailJson);
        System.out.println("nameJson = " + nameJson);
        System.out.println("companyJson = " + companyJson);
        System.out.println("statusJson = " + statusJson);
        System.out.println("profileIdJson = " + profileIdJson);

    }

    @Test
    public void test2() {
        Response response = RestAssured.get(devExUrl + "/api/profile");
        assertEquals(response.statusCode(),200);

        JsonPath jsonPath = response.jsonPath();

        int secondUserId = jsonPath.getInt("id[1]");
        System.out.println("secondUserId = " + secondUserId);

        List<Object> allCompany = jsonPath.getList("company");
        System.out.println("allCompany = " + allCompany);

        Map<String,Object> secondUserInfo = jsonPath.getMap("user[1]");
        System.out.println("secondUserInfo = " + secondUserInfo);
        System.out.println("secondUserInfo.get(\"name\") = " + secondUserInfo.get("name"));


        List<String> secondUserSkill = jsonPath.getList("skills[1]");
        System.out.println("secondUserSkill = " + secondUserSkill);


        System.out.println("****************** GPATH METHOD **************************");

        //GET all user names which has github as null

        List<Object> listGitHubNull = jsonPath.getList("user.findAll{it.github==null}.name");
        //it means if.                                  github!==null şeklinde de aratılabilir.
        System.out.println("listGitHubNull = " + listGitHubNull);


        List<Object> listName = jsonPath.getList("user.findAll{it.id<10}.name");
        System.out.println("listName = " + listName);
    }
}
