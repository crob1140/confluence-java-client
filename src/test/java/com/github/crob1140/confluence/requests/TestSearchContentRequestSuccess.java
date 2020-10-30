package com.github.crob1140.confluence.requests;

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

import com.github.crob1140.confluence.content.ContentStatus;
import com.github.crob1140.confluence.content.SortDirection;
import com.github.crob1140.confluence.content.StandardContentType;
import com.github.crob1140.confluence.content.search.CqlContext;
import com.github.crob1140.confluence.content.search.Excerpt;

@RunWith(Parameterized.class)
public class TestSearchContentRequestSuccess
    extends TestConfluenceRequestSuccess {

  public TestSearchContentRequestSuccess(String description, SearchContentRequest request,
      MediaType expectedContentType, String expectedMethod, String expectedPath,
      Map<String, String> expectedQueryParams, String expectedBodyJson) {
    super(request, expectedContentType, expectedMethod, expectedPath, expectedQueryParams,
        expectedBodyJson);
  }

  @Parameters(name = "{0}")
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{{
        "Request construction succeeds with just the mandatory fields",
        new SearchContentRequest.Builder()
            .setCql("text~'my search phrase'")
            .build(),
        MediaType.APPLICATION_JSON_TYPE,
        HttpMethod.GET,
        "rest/api/content/search",
        new QueryParamMapBuilder().addEntry("cql", "text~'my search phrase'").build(),
        ""
    }, {
        "Any limit that is provided is added to the query parameters",
        new SearchContentRequest.Builder()
            .setLimit(123)
            .setCql("text~'my search phrase'")
            .build(),
        MediaType.APPLICATION_JSON_TYPE,
        HttpMethod.GET,
        "rest/api/content/search",
        new QueryParamMapBuilder()
            .addEntry("limit", "123")
            .addEntry("cql", "text~'my search phrase'")
            .build(),
        ""
    }, {
        "Any start position that is provided is added to the query parameters",
        new SearchContentRequest.Builder()
            .setStartPosition(123)
            .setCql("text~'my search phrase'")
            .build(),
        MediaType.APPLICATION_JSON_TYPE,
        HttpMethod.GET,
        "rest/api/content/search",
        new QueryParamMapBuilder()
            .addEntry("start", "123")
            .addEntry("cql", "text~'my search phrase'")
            .build(),
        ""
    }, {
        "Any CQL clause that is provided is added to the query parameters",
        new SearchContentRequest.Builder()
            .setCql("text~'my search phrase'")
            .build(),
        MediaType.APPLICATION_JSON_TYPE,
        HttpMethod.GET,
        "rest/api/content/search",
        new QueryParamMapBuilder()
            .addEntry("cql", "text~'my search phrase'")
            .build(),
        ""
    }, {
        "Any CQL context that is provided is added to the query parameters",
        new SearchContentRequest.Builder()
            .setCqlContext(new CqlContext("spaceKey", "contentId"))
            .setCql("text~'my search phrase'")
            .build(),
        MediaType.APPLICATION_JSON_TYPE,
        HttpMethod.GET,
        "rest/api/content/search",
        new QueryParamMapBuilder()
            .addEntry("cqlcontext", "%7B%22spaceKey%22%3A%22spaceKey%22%2C%22contentId%22%3A%22contentId%22%7D")
            .addEntry("cql", "text~'my search phrase'")
            .build(),
        ""
    }, {
        "Any excerpt that is provided is added to the query parameters",
        new SearchContentRequest.Builder()
            .setExcerpt(Excerpt.HIGHLIGHT)
            .setCql("text~'my search phrase'")
            .build(),
        MediaType.APPLICATION_JSON_TYPE,
        HttpMethod.GET,
        "rest/api/content/search",
        new QueryParamMapBuilder()
            .addEntry("excerpt", "highlight")
            .addEntry("cql", "text~'my search phrase'").build(),
        ""
    }, {
        "Any includeArchivedSpaces that is provided is added to the query parameters",
        new SearchContentRequest.Builder()
            .includeArchivedSpaces(true)
            .setCql("text~'my search phrase'")
            .build(),
        MediaType.APPLICATION_JSON_TYPE,
        HttpMethod.GET,
        "rest/api/content/search",
        new QueryParamMapBuilder()
            .addEntry("includeArchivedSpaces", "true")
            .addEntry("cql", "text~'my search phrase'").build(),
        ""
    }});
  }
}
