package com.github.crob1140.confluence.users;

import com.fasterxml.jackson.annotation.JsonValue;

public enum UserType {
  KNOWN("known"),
  ANONYMOUS("anonymous");

  private String identifier;

  UserType(String identifier) {
    this.identifier = identifier;
  }

  /**
   * This method returns the unique identifier for the user type.
   *
   * @return The unique identifier for the body type.
   */
  @JsonValue
  public String getIdentifier() {
    return this.identifier;
  }
}
