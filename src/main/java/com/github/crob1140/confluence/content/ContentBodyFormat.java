package com.github.crob1140.confluence.content;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents the format of each body type contained within an instance of {@link
 * ContentBody}.
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContentBodyFormat {

  @JsonProperty
  private String value;
  @JsonProperty
  private String representation;

  @SuppressWarnings("unused")
  private ContentBodyFormat() {
    // Required for Jackson deserialization
  }

  /**
   * This constructor creates a format with the given value and representation.
   *
   * @param value The value of the format.
   * @param representation The representation of the format.
   */
  public ContentBodyFormat(String value, String representation) {
    this.value = value;
    this.representation = representation;
  }

  public String getValue( ) {
    return value;
  }

  public String getRepresentation( ) {
    return representation;
  }

}
