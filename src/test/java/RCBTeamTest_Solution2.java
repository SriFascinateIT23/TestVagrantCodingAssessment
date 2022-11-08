import com.testvagrant.codingassessment.constants.FrameworkConstants;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RCBTeamTest_Solution2 {
    String jsonBody;
    JsonPath jsonPath;

    @BeforeClass
    public JsonPath readJsonFile() {
        byte[] jsonResponse = new byte[0];
        try {
            jsonResponse = Files.readAllBytes(Paths.get(FrameworkConstants.JSON_FILE_PATH+FrameworkConstants.JSON_FILE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }

        jsonBody = new String(jsonResponse);

        return jsonPath=new JsonPath(jsonBody);
    }

    @Test
    public void validateForeignPlayersList() {
       System.out.println(readJsonFile().getList("player.findAll{it.country !='India'}"));
       Assert.assertEquals(readJsonFile().getList("player.findAll{it.country !='India'}").size(),4,"Foreign players count should be matched");

    }

    @Test
    public void validatePresenceOfWicketKeeper() {
        System.out.println(readJsonFile().getList("player.findAll{it.role=='Wicket-keeper'}"));
        Assert.assertTrue(readJsonFile().getList("player.findAll{it.role=='Wicket-keeper'}").size()>0,"RCB team should contain at least 1 wicket-keeper");

    }
}
