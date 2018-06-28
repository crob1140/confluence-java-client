package com.github.crob1140.confluence.requests;

import com.github.crob1140.confluence.content.ContentStatus;
import com.github.crob1140.confluence.content.SortDirection;
import com.github.crob1140.confluence.content.StandardContentType;
import java.time.LocalDate;
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
public class TestGetContentRequestSuccess extends TestConfluenceRequestSuccess {

  private String description;

  public TestGetContentRequestSuccess(String description, GetContentRequest request,
      MediaType expectedContentType, String expectedMethod, String expectedPath,
      Map<String, String> expectedQueryParams, String expectedBodyJson) {
    super(request, expectedContentType, expectedMethod, expectedPath, expectedQueryParams,
        expectedBodyJson);
    this.description = description;
  }

  @Parameters(name = "{0}")
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{{
        "Request construction succeeds without providing any arguments",
        new GetContentRequest.Builder().build(),
        MediaType.APPLICATION_JSON_TYPE,
        HttpMethod.GET,
        "rest/api/content",
        new HashMap<>(),
        ""
    }, {
        "Any limit that is provided is added to the query parameters",
        new GetContentRequest.Builder().setLimit(123).build(),
        MediaType.APPLICATION_JSON_TYPE,
        HttpMethod.GET,
        "rest/api/content",
        new QueryParamMapBuilder().addEntry("limit", Arrays.asList("123")).build(),
        ""
    }, {
        "Any order-by clause that is provided is added to the query parameters",
        new GetContentRequest.Builder().orderBy("somefield", SortDirection.ASCENDING).build(),
        MediaType.APPLICATION_JSON_TYPE,
        HttpMethod.GET,
        "rest/api/content",
        new QueryParamMapBuilder().addEntry("orderBy", Arrays.asList("somefield asc")).build(),
        ""
    }, {
        "Any posting day that is provided is added to the query parameters",
        new GetContentRequest.Builder().setPostingDay(LocalDate.of(2018, 06, 27)).build(),
        MediaType.APPLICATION_JSON_TYPE,
        HttpMethod.GET,
        "rest/api/content",
        new QueryParamMapBuilder().addEntry("postingDay", Arrays.asList("2018-06-27")).build(),
        ""
    }, {
        "Any space key that is provided is added to the query parameters",
        new GetContentRequest.Builder().setSpaceKey("TESTSPACE").build(),
        MediaType.APPLICATION_JSON_TYPE,
        HttpMethod.GET,
        "rest/api/content",
        new QueryParamMapBuilder().addEntry("spaceKey", Arrays.asList("TESTSPACE")).build(),
        ""
    }, {
        "Any start position that is provided is added to the query parameters",
        new GetContentRequest.Builder().setStartPosition(123).build(),
        MediaType.APPLICATION_JSON_TYPE,
        HttpMethod.GET,
        "rest/api/content",
        new QueryParamMapBuilder().addEntry("start", Arrays.asList("123")).build(),
        ""
    }, {
        "Any status that is provided is added to the query parameters",
        new GetContentRequest.Builder().setStatus(ContentStatus.DRAFT).build(),
        MediaType.APPLICATION_JSON_TYPE,
        HttpMethod.GET,
        "rest/api/content",
        new QueryParamMapBuilder().addEntry("status", Arrays.asList("draft")).build(),
        ""
    }, {
        "Any title that is provided is added to the query parameters",
        new GetContentRequest.Builder().setTitle("Test title").build(),
        MediaType.APPLICATION_JSON_TYPE,
        HttpMethod.GET,
        "rest/api/content",
        new QueryParamMapBuilder().addEntry("title", Arrays.asList("Test title")).build(),
        ""
    }, {
        "Any trigger that is provided is added to the query parameters",
        new GetContentRequest.Builder().setTrigger("viewed").build(),
        MediaType.APPLICATION_JSON_TYPE,
        HttpMethod.GET,
        "rest/api/content",
        new QueryParamMapBuilder().addEntry("trigger", Arrays.asList("viewed")).build(),
        ""
    }, {
        "Any type that is provided is added to the query parameters",
        new GetContentRequest.Builder().setType(StandardContentType.PAGE).build(),
        MediaType.APPLICATION_JSON_TYPE,
        HttpMethod.GET,
        "rest/api/content",
        new QueryParamMapBuilder().addEntry("type", Arrays.asList("page")).build(),
        ""
    }});
  }
}
