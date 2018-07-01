package com.github.crob1140.confluence;

import com.github.crob1140.confluence.requests.ConfluenceRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * This class represents a configurable instance of {@link ConfluenceRequest} that can be used for
 * testing purposes.
 */
public class TestConfluenceRequest extends ConfluenceRequest {

  private String method;
  private String path;
  private Class<?> returnType;

  /**
   * This constructor creates a new test request object with the given method, path and return
   * type.
   *
   * @param method The HTTP method to use for the request (see {@link javax.ws.rs.HttpMethod for
   * possible values}.
   * @param path The path to use for the request.
   * @param returnType The type to use when de-serializing the response for this request.
   */
  public TestConfluenceRequest(String method, String path, Class<?> returnType) {
    this.method = method;
    this.path = path;
    this.returnType = returnType;
  }

  /**
   * This method returns the path of the request relative to the Confluence wiki root.
   *
   * @return The path of the request relative to the Confluence wiki root.
   */
  @Override
  public String getRelativePath() {
    return this.path;
  }

  /**
   * This method returns the HTTP method used by this request.
   */
  @Override
  public String getMethod() {
    return this.method;
  }

  /**
   * This method returns the query parameters for this request.
   *
   * @return The query parameters for this request.
   */
  @Override
  public Map<String, String> getQueryParams() {
    return new HashMap<>();
  }

  /**
   * This method returns the entity that is sent in the body of the request.
   *
   * @return The entity that is sent in the body of the request.
   */
  @Override
  public Optional<Object> getBodyEntity() {
    return Optional.empty();
  }

  /**
   * This method returns the class of the object in the body of the response for this request.
   *
   * @return The class of the object in the body of response for this request.
   */
  @Override
  public Class<?> getReturnType() {
    return returnType;
  }
}
