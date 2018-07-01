package com.github.crob1140.confluence.requests;

import com.github.crob1140.confluence.content.ContentBodyType;
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
public class TestUpdateContentRequestSuccess extends TestConfluenceRequestSuccess {

  public TestUpdateContentRequestSuccess(String description, UpdateContentRequest request,
      MediaType expectedContentType, String expectedMethod, String expectedPath,
      Map<String, String> expectedQueryParams, String expectedBodyJson) {
    super(request, expectedContentType, expectedMethod, expectedPath, expectedQueryParams,
        expectedBodyJson);
  }

  @Parameters(name = "{0}")
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{{
        "Request construction succeeds with just the mandatory fields",
        new UpdateContentRequest.Builder()
            .setId("123")
            .setVersion(2)
            .setType(StandardContentType.PAGE)
            .build(),
        MediaType.APPLICATION_JSON_TYPE,
        HttpMethod.PUT,
        "rest/api/content/123",
        new HashMap<String, String>(),
        "{" +
            "   \"version\" : {" +
            "     \"number\" : 2" +
            "   }" +
            "}"
    }, {
        "Only the last body set is included in the request",
        new UpdateContentRequest.Builder()
            .setId("123")
            .setVersion(2)
            .setType(StandardContentType.PAGE)
            .setBody(ContentBodyType.EDITOR2, "<html>TEST</html>")
            .setBody(ContentBodyType.STORAGE, "<html>TEST</html>")
            .setBody(ContentBodyType.VIEW, "<html>TEST</html>")
            .setBody(ContentBodyType.EXPORT_VIEW, "<html>TEST</html>")
            .setBody(ContentBodyType.STYLED_VIEW, "<html>TEST</html>")
            .setBody(ContentBodyType.ANONYMOUS_EXPORT_VIEW, "<html>TEST</html>")
            .build(),
        MediaType.APPLICATION_JSON_TYPE,
        HttpMethod.PUT,
        "rest/api/content/123",
        new HashMap<>(),
        "{" +
            "   \"body\" : {" +
            "       \"anonymous_export_view\" : {" +
            "           \"value\" : \"<html>TEST</html>\"" +
            "       }" +
            "   }," +
            "   \"version\" : {" +
            "     \"number\" : 2" +
            "   }" +
            "}"
    }, {
        "Any labels that are added should be included in the request",
        new UpdateContentRequest.Builder()
            .setId("123")
            .setVersion(2)
            .setType(StandardContentType.PAGE)
            .addLabel("global-label")
            .addLabel("team-label", LabelPrefix.TEAM)
            .addLabel("my-label", LabelPrefix.MY)
            .build(),
        MediaType.APPLICATION_JSON_TYPE,
        HttpMethod.PUT,
        "rest/api/content/123",
        new HashMap<>(),
        "{" +
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
            "   }," +
            "   \"version\" : {" +
            "     \"number\" : 2" +
            "   }" +
            "}"
    }});
  }
}
