package com.github.crob1140.confluence.spaces;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents a plain space description within the Confluence Cloud server.
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SpaceDescriptionPlain
{

  @JsonProperty
  private String value;

  @JsonProperty
  private String representation;

  @SuppressWarnings("unused")
  private SpaceDescriptionPlain() {
    // Required for Jackson deserialization
  }

  public SpaceDescriptionPlain(String value, String representation) {
    this.value = value;
    this.representation = representation;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getRepresentation() {
    return representation;
  }

  public void setRepresentation(String representation) {
    this.representation = representation;
  }
}
