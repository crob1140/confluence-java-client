package com.github.crob1140.confluence.content.search;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This enumerable represents the possible values for the excerpt used in search request of {@link com.github.crob1140.confluence.requests.SearchContentRequest}.
 */
public enum Excerpt
{
  INDEXED("indexed"),
  HIGHLIGHT("highlight"),
  NONE("none");

  private String identifier;

  Excerpt(String identifier) {
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
