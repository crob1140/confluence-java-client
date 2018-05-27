package com.github.crob1140.confluence;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import com.github.crob1140.confluence.errors.ConfluenceRequestException;
import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * This class performs tests against the methods of {@link ConfluenceClient}.
 */
public class TestConfluenceClient {

  public static final Integer WIRE_MOCK_PORT = 8888;

  @ClassRule
  public static WireMockClassRule wireMockRule = new WireMockClassRule(WIRE_MOCK_PORT);

  @Rule
  public WireMockClassRule instanceRule = wireMockRule;

  private ConfluenceClient client;

  public TestConfluenceClient() {
    WebTarget target = ClientBuilder.newClient().target("http://localhost:" + WIRE_MOCK_PORT);
    this.client = new ConfluenceClient(target);
  }

  /**
   * This test asserts that the client is able to successfully translate a {@link
   * com.github.crob1140.confluence.requests.ConfluenceRequest} into a HTTP request and de-serialize
   * the response object when the server returns a HTTP status code indicating success.
   */
  @Test
  public void testSuccess() throws ConfluenceRequestException {
    stubFor(get(urlEqualTo("/test/path"))
        .withHeader("Accept", equalTo(MediaType.APPLICATION_JSON))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader("Content-Type", MediaType.APPLICATION_JSON)
            .withBody("{" +
                " \"name\": \"test\"," +
                " \"value\": \"TEST\"" +
                "}")));

    TestConfluenceRequest request = new TestConfluenceRequest(HttpMethod.GET, "/test/path",
        TestConfluenceResponse.class);
    TestConfluenceResponse expectedResponse = new TestConfluenceResponse("test", "TEST");
    TestConfluenceResponse actualResponse = (TestConfluenceResponse) client.performRequest(request);

    Assert.assertEquals(expectedResponse, actualResponse);
  }

  /**
   * This test asserts that the client is able to successfully translate a {@link
   * com.github.crob1140.confluence.requests.ConfluenceRequest} into a HTTP request and de-serialize
   * the JSON error object that is returned if the HTTP status code indicates failure and the
   * content type indicates that it is JSON.
   */
  @Test
  public void testJSONError() {
    stubFor(post(urlEqualTo("/test/path"))
        .withHeader("Accept", equalTo(MediaType.APPLICATION_JSON))
        .willReturn(aResponse()
            .withStatus(400)
            .withHeader("Content-Type", MediaType.APPLICATION_JSON)
            .withBody("{" +
                " \"statusCode\" : 400," +
                " \"message\": \"Illegal argument\"" +
                "}")));

    TestConfluenceRequest request = new TestConfluenceRequest(HttpMethod.POST, "/test/path",
        String.class);
    try {
      client.performRequest(request);
      Assert.fail("Should have thrown ConfluenceRequestException but didn't");
    } catch (Exception e) {
      Assert.assertTrue(e instanceof ConfluenceRequestException);
      Assert.assertEquals("Illegal argument", e.getMessage());
      Assert.assertEquals(400, ((ConfluenceRequestException) e).getStatusCode().longValue());
    }
  }

  /**
   * This test asserts that the client is able to successfully translate a {@link
   * com.github.crob1140.confluence.requests.ConfluenceRequest} into a HTTP request and de-serialize
   * the error that is returned if the HTTP status code indicates failure and the content type
   * indicates that the response is not JSON.
   */
  @Test
  public void testHTMLError() {
    stubFor(get(urlEqualTo("/test/path"))
        .withHeader("Accept", equalTo(MediaType.APPLICATION_JSON))
        .willReturn(aResponse()
            .withStatus(404)
            .withHeader("Content-Type", MediaType.TEXT_HTML)
            .withBody("<html>404 Page Not Found</html>")));

    TestConfluenceRequest request = new TestConfluenceRequest(HttpMethod.POST, "/test/path",
        String.class);
    try {
      client.performRequest(request);
      Assert.fail("Should have thrown ConfluenceRequestException but didn't");
    } catch (Exception e) {
      Assert.assertTrue(e instanceof ConfluenceRequestException);
      Assert.assertEquals("Not Found", e.getMessage());
      Assert.assertEquals(404, ((ConfluenceRequestException) e).getStatusCode().longValue());
    }
  }
}
