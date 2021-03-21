package com.github.crob1140.confluence.requests;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.MediaType;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.github.crob1140.confluence.content.search.CqlContext;
import com.github.crob1140.confluence.content.search.Excerpt;

@RunWith(Parameterized.class)
public class TestSearchRequestSuccess
    extends TestConfluenceRequestSuccess {

  public TestSearchRequestSuccess(String description, SearchRequest request,
      MediaType expectedContentType, String expectedMethod, String expectedPath,
      Map<String, String> expectedQueryParams, String expectedBodyJson) {
    super(request, expectedContentType, expectedMethod, expectedPath, expectedQueryParams,
        expectedBodyJson);
  }

  @Parameters(name = "{0}")
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{{
        "Request construction succeeds with just the mandatory fields",
        new SearchRequest.Builder()
            .setCql("text~'my search phrase'")
            .build(),
        MediaType.APPLICATION_JSON_TYPE,
        HttpMethod.GET,
        "rest/api/search",
        new QueryParamMapBuilder().addEntry("cql", "text~'my search phrase'").build(),
        ""
    }, {
        "Any limit that is provided is added to the query parameters",
        new SearchRequest.Builder()
            .setLimit(123)
            .setCql("text~'my search phrase'")
            .build(),
        MediaType.APPLICATION_JSON_TYPE,
        HttpMethod.GET,
        "rest/api/search",
        new QueryParamMapBuilder()
            .addEntry("limit", "123")
            .addEntry("cql", "text~'my search phrase'")
            .build(),
        ""
    }, {
        "Any start position that is provided is added to the query parameters",
        new SearchRequest.Builder()
            .setStartPosition(123)
            .setCql("text~'my search phrase'")
            .build(),
        MediaType.APPLICATION_JSON_TYPE,
        HttpMethod.GET,
        "rest/api/search",
        new QueryParamMapBuilder()
            .addEntry("start", "123")
            .addEntry("cql", "text~'my search phrase'")
            .build(),
        ""
    }, {
        "Any CQL clause that is provided is added to the query parameters",
        new SearchRequest.Builder()
            .setCql("text~'my search phrase'")
            .build(),
        MediaType.APPLICATION_JSON_TYPE,
        HttpMethod.GET,
        "rest/api/search",
        new QueryParamMapBuilder()
            .addEntry("cql", "text~'my search phrase'")
            .build(),
        ""
    }, {
        "Any CQL context that is provided is added to the query parameters",
        new SearchRequest.Builder()
            .setCqlContext(new CqlContext("spaceKey", "contentId"))
            .setCql("text~'my search phrase'")
            .build(),
        MediaType.APPLICATION_JSON_TYPE,
        HttpMethod.GET,
        "rest/api/search",
        new QueryParamMapBuilder()
            .addEntry("cqlcontext", "%7B%22spaceKey%22%3A%22spaceKey%22%2C%22contentId%22%3A%22contentId%22%7D")
            .addEntry("cql", "text~'my search phrase'")
            .build(),
        ""
    }, {
        "Any excerpt that is provided is added to the query parameters",
        new SearchRequest.Builder()
            .setExcerpt(Excerpt.HIGHLIGHT)
            .setCql("text~'my search phrase'")
            .build(),
        MediaType.APPLICATION_JSON_TYPE,
        HttpMethod.GET,
        "rest/api/search",
        new QueryParamMapBuilder()
            .addEntry("excerpt", "highlight")
            .addEntry("cql", "text~'my search phrase'").build(),
        ""
    }, {
        "Any includeArchivedSpaces that is provided is added to the query parameters",
        new SearchRequest.Builder()
            .includeArchivedSpaces(true)
            .setCql("text~'my search phrase'")
            .build(),
        MediaType.APPLICATION_JSON_TYPE,
        HttpMethod.GET,
        "rest/api/search",
        new QueryParamMapBuilder()
            .addEntry("includeArchivedSpaces", "true")
            .addEntry("cql", "text~'my search phrase'").build(),
        ""
    }});
  }
}
