package com.github.crob1140.confluence.content;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This enumerable defines the possible statuses for an instance of {@link Content}.
 */
public enum ContentStatus {
  CURRENT("current"),
  TRASHED("trashed"),
  HISTORICAL("historical"),
  DRAFT("draft");

  private String identifier;

  ContentStatus(String identifier) {
    this.identifier = identifier;
  }

  /**
   * This method returns the unique identifier of the status.
   *
   * @return The unique identifier of the status.
   */
  @JsonValue
  public String getIdentifier() {
    return this.identifier;
  }
}
