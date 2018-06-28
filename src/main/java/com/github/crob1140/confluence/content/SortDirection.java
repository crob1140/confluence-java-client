package com.github.crob1140.confluence.content;

/**
 * This enumerable represents the possible directions that can be used in an order-by clause
 */
public enum SortDirection {
  ASCENDING("asc"), DESCENDING("desc");

  private String identifier;

  SortDirection(String identifier) {
    this.identifier = identifier;
  }

  /**
   * This method returns the identifier for the direction.
   *
   * @return The identifier for the direction.
   */
  public String getIdentifier() {
    return this.identifier;
  }
}
