package com.github.crob1140.confluence.errors;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents the response entity returned from a Confluence Cloud serve when an error
 * occurs.
 */
public class ErrorResponse {

  @JsonProperty
  private Integer statusCode;
  @JsonProperty
  private String message;
  @JsonProperty
  private ErrorData data;

  /**
   * This method returns the HTTP status code of the error response.
   *
   * @return The HTTP status code of the error response.
   */
  public Integer getStatusCode() {
    return this.statusCode;
  }

  /**
   * This method returns the method contained within the error response.
   *
   * @return The message contained within the error response.
   */
  public String getMessage() {
    return this.message;
  }

  /**
   * This method contains the data contained within the error response.
   *
   * @return The data contained within the error response.
   */
  public ErrorData getData() {
    return this.data;
  }
}
