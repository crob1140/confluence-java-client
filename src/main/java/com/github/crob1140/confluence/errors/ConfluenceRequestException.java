package com.github.crob1140.confluence.errors;

import java.util.Optional;

/**
 * This class represents an error response returned from the Confluence server.
 */
public class ConfluenceRequestException extends Exception {

  private Integer statusCode;
  private ErrorData data;

  /**
   * This constructor creates a new instance using the given status code and message.
   *
   * @param statusCode The HTTP status code of the error response.
   * @param message The message contained within the error response.
   */
  public ConfluenceRequestException(Integer statusCode, String message) {
    super(message);
    this.statusCode = statusCode;
  }

  /**
   * This constructor creates a new instance using the given status code, message and data.
   *
   * @param statusCode The HTTP status code of the error response.
   * @param message The message contained within the error response.
   * @param data The data contained within the error response.
   */
  public ConfluenceRequestException(Integer statusCode, String message, ErrorData data) {
    this(statusCode, message);
    this.data = data;
  }

  /**
   * This method returns the HTTP status code returned with the error.
   *
   * @return The HTTP status code for the error
   */
  public Integer getStatusCode() {
    return this.statusCode;
  }

  /**
   * This method returns the data contained within the error response.
   *
   * @return The data contained within the error response.
   */
  public Optional<ErrorData> getData() {
    return Optional.ofNullable(this.data);
  }
}
