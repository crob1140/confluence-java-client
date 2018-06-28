package com.github.crob1140.confluence.errors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents an error contained within an instance of {@link ErrorData}.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Error {

  @JsonProperty
  private ErrorMessage message;

  /**
   * This method returns the message contained within the error.
   *
   * @return The message contained within the error.
   */
  public ErrorMessage getMessage() {
    return this.message;
  }
}
