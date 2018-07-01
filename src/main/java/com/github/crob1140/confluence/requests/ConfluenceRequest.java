package com.github.crob1140.confluence.requests;

import java.util.Map;
import java.util.Optional;
import javax.ws.rs.core.MediaType;

/**
 * This class represents a HTTP request performed against the Confluence REST API
 */
public abstract class ConfluenceRequest {

  /**
   * This method returns the path of the request relative to the Confluence wiki root.
   *
   * @return The path of the request relative to the Confluence wiki root.
   */
  public abstract String getRelativePath();

  /**
   * This method returns the HTTP method used by this request.
   */
  public abstract String getMethod();

  /**
   * This method returns the query parameters for this request.
   *
   * @return The query parameters for this request.
   */
  public abstract Map<String, String> getQueryParams();

  /**
   * This method returns the entity that is sent in the body of the request.
   *
   * @return The entity that is sent in the body of the request.
   */
  public abstract Optional<Object> getBodyEntity();

  /**
   * This method returns the content type of this request.
   *
   * @return The content type accepted by this request.
   */
  public MediaType getContentType() {
    return MediaType.APPLICATION_JSON_TYPE;
  }

  /**
   * This method returns the media type that is expected for the response.
   *
   * @return The media type that is expected for the response.
   */
  public MediaType getAcceptedResponseType() {
    return MediaType.APPLICATION_JSON_TYPE;
  }

  /**
   * This method returns the class of the object in the body of the response for this request.
   *
   * @return The class of the object in the body of response for this request.
   */
  public abstract Class<?> getReturnType();
}
