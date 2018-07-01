package com.github.crob1140.confluence.requests;

import com.github.crob1140.confluence.content.ContentBodyType;
import com.github.crob1140.confluence.content.ContentStatus;
import com.github.crob1140.confluence.content.LabelPrefix;
import com.github.crob1140.confluence.content.StandardContentType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.MediaType;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestCreateContentRequestSuccess extends TestConfluenceRequestSuccess {

  private String description;

  public TestCreateContentRequestSuccess(String description, CreateContentRequest request,
      MediaType expectedContentType, String expectedMethod, String expectedPath,
      Map<String, String> expectedQueryParams, String expectedBodyJson) {
    super(request, expectedContentType, expectedMethod, expectedPath, expectedQueryParams,
        expectedBodyJson);
    this.description = description;
  }

  @Parameters(name = "{0}")
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{{
        "Request construction succeeds with just the mandatory fields",
        new CreateContentRequest.Builder()
            .setType(StandardContentType.PAGE)
            .setSpaceKey("TESTSPACE")
            .setBody(ContentBodyType.VIEW, "<html>TEST</html>")
            .build(),
        MediaType.APPLICATION_JSON_TYPE,
        HttpMethod.POST,
        "rest/api/content",
        new HashMap<String, String>(),
        "{" +
            "   \"type\" : \"page\"," +
            "   \"space\" : {" +
            "       \"key\" : \"TESTSPACE\"" +
            "   }," +
            "   \"body\" : {" +
            "       \"view\" : {" +
            "           \"value\" : \"<html>TEST</html>\"" +
            "       }" +
            "   }" +
            "}"
    }, {
        "Only the last body set is included in the request",
        new CreateContentRequest.Builder()
            .setType(StandardContentType.ATTACHMENT)
            .setSpaceKey("TESTSPACE")
            .setBody(ContentBodyType.EDITOR2, "<html>TEST</html>")
            .setBody(ContentBodyType.STORAGE, "<html>TEST</html>")
            .setBody(ContentBodyType.VIEW, "<html>TEST</html>")
            .setBody(ContentBodyType.EXPORT_VIEW, "<html>TEST</html>")
            .setBody(ContentBodyType.STYLED_VIEW, "<html>TEST</html>")
            .setBody(ContentBodyType.ANONYMOUS_EXPORT_VIEW, "<html>TEST</html>")
            .build(),
        MediaType.APPLICATION_JSON_TYPE,
        HttpMethod.POST,
        "rest/api/content",
        new HashMap<>(),
        "{" +
            "   \"type\" : \"attachment\"," +
            "   \"space\" : {" +
            "       \"key\" : \"TESTSPACE\"" +
            "   }," +
            "   \"body\" : {" +
            "       \"anonymous_export_view\" : {" +
            "           \"value\" : \"<html>TEST</html>\"" +
            "       }" +
            "   }" +
            "}"
    }, {
        "Any status filter that is set should be included in the \"status\" query parameter",
        new CreateContentRequest.Builder()
            .setType(StandardContentType.COMMENT)
            .setSpaceKey("TESTSPACE")
            .setAncestor("123")
            .setBody(ContentBodyType.STORAGE, "<html>TEST</html>")
            .setResponseStatusFilter(ContentStatus.HISTORICAL)
            .build(),
        MediaType.APPLICATION_JSON_TYPE,
        HttpMethod.POST,
        "rest/api/content",
        new QueryParamMapBuilder().addEntry("status", "historical").build(),
        "{" +
            "   \"type\" : \"comment\"," +
            "   \"space\" : {" +
            "       \"key\" : \"TESTSPACE\"" +
            "   }," +
            "   \"body\" : {" +
            "       \"storage\" : {" +
            "           \"value\" : \"<html>TEST</html>\"" +
            "       }" +
            "   }" +
            "}"
    }, {
        "Any labels that are added should be included in the request",
        new CreateContentRequest.Builder()
            .setType(StandardContentType.PAGE)
            .setSpaceKey("TESTSPACE")
            .setBody(ContentBodyType.STYLED_VIEW, "<html>TEST</html>")
            .addLabel("global-label")
            .addLabel("team-label", LabelPrefix.TEAM)
            .addLabel("my-label", LabelPrefix.MY)
            .build(),
        MediaType.APPLICATION_JSON_TYPE,
        HttpMethod.POST,
        "rest/api/content",
        new HashMap<>(),
        "{" +
            "   \"type\" : \"page\"," +
            "   \"space\" : {" +
            "       \"key\" : \"TESTSPACE\"" +
            "   }," +
            "   \"body\" : {" +
            "       \"styled_view\" : {" +
            "           \"value\" : \"<html>TEST</html>\"" +
            "       }" +
            "   }," +
            "   \"metadata\" : {" +
            "     \"labels\" : [{" +
            "       \"prefix\" : \"global\"," +
            "       \"name\" : \"global-label\"" +
            "     }, {" +
            "       \"prefix\" : \"team\"," +
            "       \"name\" : \"team-label\"" +
            "     }, {" +
            "       \"prefix\" : \"my\"," +
            "       \"name\" : \"my-label\"" +
            "     }]" +
            "   }" +
            "}"
    }});
  }
}
