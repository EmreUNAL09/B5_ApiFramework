package apiTest.day06;

import com.google.gson.Gson;
import org.testng.annotations.Test;

import java.util.Map;

import static org.testng.AssertJUnit.assertEquals;

public class GsonTest {

    @Test
    public void jsonToMap() {
        Gson gson = new Gson();

        String myJsonBody = "{\n" +
                "    \"id\": 528,\n" +
                "    \"email\": \"eurotech@gmail.com\",\n" +
                "    \"name\": \"Teacher\",\n" +
                "    \"company\": \"Eurotech Study\",\n" +
                "    \"status\": \"Instructor\",\n" +
                "    \"profileId\": 276\n" +
                "}";

        System.out.println("myJsonBody = " + myJsonBody);

        //gson converting to map
        Map<String,Object> dataMap = gson.fromJson(myJsonBody, Map.class);
        System.out.println("dataMap = " + dataMap);

        //gson converting to object class
        EurotechUser oneUser = gson.fromJson(myJsonBody, EurotechUser.class);
        System.out.println("oneUser.getName() = " + oneUser.getName());
        assertEquals(oneUser.getName(), "Teacher");

        //Serialization => Java collection of Pojo to JSON
        EurotechUser eurotechUser = new EurotechUser(11,"icardi@gmail.com","wanda","gs","player",23.0);
        String jsonUser = gson.toJson(eurotechUser);
        System.out.println("jsonUser = " + jsonUser);
    }
}
