import com.testvagrant.codingassessment.constants.FrameworkConstants;
import com.testvagrant.codingassessment.util.JsonUtil;
import org.testng.Assert;
import com.jayway.jsonpath.*;
import org.testng.annotations.Test;

import java.util.List;

public class RCBTeamTest_Solution1 {
    String jsonResponseString = JsonUtil.getJsonAsString(JsonUtil.getJsonFileContent(FrameworkConstants.JSON_FILE_PATH,FrameworkConstants.JSON_FILE_NAME));

    @Test
    public void validateForeignPlayersCount() {
        List<String> foreignPlayersCountry = JsonPath.read(jsonResponseString,"$..player[?(@.country!='India')]");
        Assert.assertEquals(foreignPlayersCountry.size(),FrameworkConstants.EXPECTED_FOREIGN_PLAYERS,"Foreign players count should be matched");
    }

    @Test
    public void validateWicketKeepersPresence() {
        List<String> wicketKeepers = JsonPath.read(jsonResponseString,"$..player[?(@.role=='Wicket-keeper')]");
        Assert.assertNotNull(wicketKeepers.size(),"Team should contain at least 1 Wicket-keeper");
    }
}
