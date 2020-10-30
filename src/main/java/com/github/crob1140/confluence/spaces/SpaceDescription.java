package com.github.crob1140.confluence.spaces;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents a user profile picture within the Confluence Cloud server.
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SpaceDescription
{

  @JsonProperty
  private SpaceDescriptionPlain plain;

  @SuppressWarnings("unused")
  private SpaceDescription() {
    // Required for Jackson deserialization
  }

  public SpaceDescription(SpaceDescriptionPlain plain) {
    this.plain = plain;
  }

  public SpaceDescriptionPlain getPlain() {
    return plain;
  }

  public void setPlain(SpaceDescriptionPlain plain) {
    this.plain = plain;
  }
}
