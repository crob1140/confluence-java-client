package com.github.crob1140.confluence.spaces;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This enumerable represents the possible values for the type of a {@link Space} instance.
 */
public enum SpaceType {
  GLOBAL("global"),
  PERSONAL("personal");

  private String identifier;

  SpaceType(String identifier) {
    this.identifier = identifier;
  }

  /**
   * This method returns the unique identifier for the space type.
   *
   * @return The unique identifier for the body type.
   */
  @JsonValue
  public String getIdentifier() {
    return this.identifier;
  }
}
