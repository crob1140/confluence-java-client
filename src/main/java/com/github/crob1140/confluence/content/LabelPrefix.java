package com.github.crob1140.confluence.content;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This enumerable represents the possible values for the prefix in an instance of {@link Label}.
 */
public enum LabelPrefix {
  GLOBAL("global"),
  MY("my"),
  TEAM("team");

  private String identifier;

  LabelPrefix(String identifier) {
    this.identifier = identifier;
  }

  /**
   * This method returns the identifier for the prefix.
   *
   * @return The identifier for the prefix.
   */
  @JsonValue
  public String getIdentifier() {
    return this.identifier;
  }
}
