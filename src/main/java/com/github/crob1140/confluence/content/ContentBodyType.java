package com.github.crob1140.confluence.content;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This enumerable represents the possible types that can be defined for an instance of {@link
 * ContentBody}
 */
public enum ContentBodyType {
  ANONYMOUS_EXPORT_VIEW("anonymous_export_view"),
  EDITOR2("editor2"),
  EXPORT_VIEW("export_view"),
  STORAGE("storage"),
  STYLED_VIEW("styled_view"),
  VIEW("view");

  private String identifier;

  ContentBodyType(String identifier) {
    this.identifier = identifier;
  }

  /**
   * This method returns the unique identifier for the body type.
   *
   * @return The unique identifier for the body type.
   */
  @JsonValue
  public String getIdentifier() {
    return this.identifier;
  }
}
