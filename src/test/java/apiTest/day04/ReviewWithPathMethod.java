package apiTest.day04;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;

public class ReviewWithPathMethod {

    String devExUrl = "http://eurotech.study";

    @Test
    public void getAllProfiles() {

        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get(devExUrl + "/api/profile");

        assertEquals(response.statusCode(),200);
        //response.prettyPrint();

        //Finding first element's ID
        int firstId = response.path("id[0]");
        System.out.println("firstId = " + firstId);

        System.out.println("--------------------------------------");

        //Finding last element's ID
        int lastId = response.path("id[-2]");
        System.out.println("lastId = " + lastId);

        System.out.println("--------------------------------------");

        //Finding second element's COMPANY
        String secondCompany = response.path("company[1]");
        System.out.println("secondCompany = " + secondCompany);

        System.out.println("--------------------------------------");

        //GET first skills as List
        List<String> firstSkills = response.path("skills[0]");
        for (String skill : firstSkills) {
            System.out.println("skill = " + skill);
        }
        //System.out.println("firstSkills.size() = " + firstSkills.size());
        Object firstSkillsSecondSkill = response.path("skills[0][1]");
        System.out.println("firstSkillsSecondSkill = " + firstSkillsSecondSkill);

        System.out.println("--------------------------------------");

        //MAP
        Map<String,Object> firstUserMap = response.path("user[0]");
        System.out.println("firstUserMap = " + firstUserMap);

        for (String user : firstUserMap.keySet()) {
            //System.out.println("user = " + user); //Bu yöntem sadece KEY veriyor.
            System.out.println(user + ":" + firstUserMap.get(user));
        }

        System.out.println("--------------------------------------");

        Object firstUserId = response.path("user[0].id");
        System.out.println("firstUserId = " + firstUserId);

        Object secontUserId = response.path("user[1].id");
        System.out.println("secontUserId = " + secontUserId);

        System.out.println("--------------------------------------");

        //GET all user ID
        List<String> userIDs = response.path("user.id");
        System.out.println("userIDs.size() = " + userIDs.size());
        System.out.println("userIDs = " + userIDs);

        System.out.println("--------------------------------------");

        List<Integer> allIDs= response.path("id");

        for (Integer id : allIDs) {
            System.out.println("id = " + id);
        }















    }
}
