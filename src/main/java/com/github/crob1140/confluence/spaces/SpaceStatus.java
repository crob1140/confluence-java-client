package com.github.crob1140.confluence.spaces;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This enumerable represents the possible values for the status of a {@link Space} instance.
 */
public enum SpaceStatus {
  CURRENT("current"),
  ARCHIVED("archived");

  private String identifier;

  SpaceStatus(String identifier) {
    this.identifier = identifier;
  }

  /**
   * This method returns the unique identifier for the space status.
   *
   * @return The unique identifier for the body type.
   */
  @JsonValue
  public String getIdentifier() {
    return this.identifier;
  }
}
