package com.github.crob1140.confluence.content;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents the format of each body type contained within an instance of {@link
 * ContentBody}.
 */
public class ContentBodyFormat {

  @JsonProperty
  private String value;
  @JsonProperty
  private String representation;

  /**
   * This constructor creates a format containing only the value.
   *
   * @param value The value of the format.
   */
  public ContentBodyFormat(String value) {
    this.value = value;
  }
}
