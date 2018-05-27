package com.github.crob1140.confluence.errors;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * This class represents the data contained within an instance of {@link ErrorResponse}.
 */
public class ErrorData {

  @JsonProperty
  private Boolean authorized;
  @JsonProperty
  private Boolean valid;
  @JsonProperty
  private Boolean successful;
  @JsonProperty
  private List<Error> errors;

  /**
   * This method returns a flag indicating whether or not the request failed due to invalid.
   * authorisation.
   *
   * @return A flag indicating whether or not the request failed due to invalid. * authorisation.
   */
  public Boolean isAuthorized() {
    return this.authorized;
  }

  /**
   * This method returns a flag indicating whether or not the request was invalid.
   *
   * @return A flag indicating whether or not the request was invalid.
   */
  public Boolean isValid() {
    return this.valid;
  }

  /**
   * This method returns a flag indicating whether or not the request completed successfully.
   *
   * @return A flag indicating whether or not the request completed successfully.
   */
  public Boolean isSuccessful() {
    return this.successful;
  }

  /**
   * This method returns all of the associated errors.
   *
   * @return The associated errors
   */
  public List<Error> getErrors() {
    return this.errors;
  }
}
