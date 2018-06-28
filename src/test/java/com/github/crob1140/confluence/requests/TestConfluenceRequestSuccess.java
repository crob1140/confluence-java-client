package com.github.crob1140.confluence.requests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.util.Optional;
import javax.ws.rs.core.MediaType;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class TestConfluenceRequestSuccess {

  protected ConfluenceRequest request;

  private MediaType expectedContentType;
  private String expectedMethod;
  private String expectedPath;
  private Map<String, String> expectedQueryParams;
  private String expectedBodyJson;

  protected TestConfluenceRequestSuccess(ConfluenceRequest request, MediaType expectedContentType,
      String expectedMethod, String expectedPath, Map<String, String> expectedQueryParams,
      String expectedBodyJson) {
    this.request = request;
    this.expectedContentType = expectedContentType;
    this.expectedMethod = expectedMethod;
    this.expectedPath = expectedPath;
    this.expectedQueryParams = expectedQueryParams;
    this.expectedBodyJson = expectedBodyJson;
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

  private static String toJson(Object obj) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(obj);
  }
}
