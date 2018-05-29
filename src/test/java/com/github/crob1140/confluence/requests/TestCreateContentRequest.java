package com.github.crob1140.confluence.requests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.crob1140.confluence.content.ContentBodyType;
import com.github.crob1140.confluence.content.ContentStatus;
import com.github.crob1140.confluence.content.LabelPrefix;
import com.github.crob1140.confluence.content.StandardContentType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.MediaType;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.skyscreamer.jsonassert.JSONAssert;

@RunWith(Parameterized.class)
public class TestCreateContentRequest {

  private String description;
  private CreateContentRequest request;
  private MediaType expectedContentType;
  private String expectedMethod;
  private String expectedPath;
  private Map<String, String> expectedQueryParams;
  private String expectedBodyJson;

  public TestCreateContentRequest(String description, CreateContentRequest request,
      MediaType expectedContentType, String expectedMethod, String expectedPath,
      Map<String, String> expectedQueryParams,
      String expectedBodyJson) {
    this.description = description;
    this.request = request;
    this.expectedContentType = expectedContentType;
    this.expectedMethod = expectedMethod;
    this.expectedPath = expectedPath;
    this.expectedQueryParams = expectedQueryParams;
    this.expectedBodyJson = expectedBodyJson;
  }

  @Parameters(name = "{0}")
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {
            "Request construction succeeds with just the mandatory fields",
            new CreateContentRequest.Builder()
                .setType(StandardContentType.PAGE)
                .setSpaceKey("TESTSPACE")
                .setBody(ContentBodyType.VIEW, "<html>TEST</html>")
                .build(),
            MediaType.APPLICATION_JSON_TYPE,
            HttpMethod.POST,
            "/wiki/rest/api/content",
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
        "/wiki/rest/api/content",
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
        "/wiki/rest/api/content",
        buildQueryParamMap(new QueryParam("status", Arrays.asList("historical"))),
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
        "/wiki/rest/api/content",
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
    }
    });
  }

  private static String toJson(Object obj) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(obj);
  }

  private static Map<String, Set<String>> buildQueryParamMap(QueryParam... params) {
    return Stream.of(params).collect(Collectors.toMap(p -> p.paramName, p -> p.values));
  }

  /**
   * This test asserts that the content type of the request matches the expected value.
   */
  @Test
  public void testContentType() {
    Assert.assertEquals(this.expectedContentType, request.getContentType());
  }

  /**
   * This test asserts that the method of the request matches the expected value.
   */
  @Test
  public void testMethod() {
    Assert.assertEquals(this.expectedMethod, request.getMethod());
  }

  /**
   * This test asserts that the path of the request matches the expected value.
   */
  @Test
  public void testPath() {
    Assert.assertEquals(this.expectedPath, request.getRelativePath());
  }

  /**
   * This test asserts that the query parameters of the request match the expected value.
   */
  @Test
  public void testQueryParams() {
    Assert.assertEquals(this.expectedQueryParams, request.getQueryParams());
  }

  /**
   * This test asserts that the body of the request matches the expected value.
   */
  @Test
  public void testBody() throws JsonProcessingException, JSONException {
    Optional<Object> bodyEntity = request.getBodyEntity();
    if (bodyEntity.isPresent()) {
      JSONAssert.assertEquals(this.expectedBodyJson, toJson(bodyEntity.get()), false);
    }
  }

  private static class QueryParam {

    private String paramName;
    private Set<String> values;

    public QueryParam(String paramName, Collection<String> values) {
      this.paramName = paramName;
      this.values = new HashSet<>(values);
    }
  }
}
