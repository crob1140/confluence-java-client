package com.github.crob1140.confluence.errors;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * This class represents the message contained within an instance of {@link Error}.
 */
public class ErrorMessage {

  @JsonProperty
  private String translation;

  @JsonProperty
  private String key;

  @JsonProperty
  private List<Object> args; // TODO: whats in the array???

  /**
   * This method returns the translation for the error message.
   *
   * @return The translation for the error message.
   */
  public String getTranslation() {
    return this.translation;
  }

  /**
   * This method returns the arguments for the error message.
   *
   * @return The arguments for the error message.
   */
  public List<Object> getArgs() {
    return this.args;
  }
}
