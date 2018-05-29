package com.github.crob1140.confluence.content;

/**
 * This enumerable represents the standard set of types that can be set on an instance of {@link
 * Content}.
 */
public enum StandardContentType {
  PAGE("page"),
  BLOGPOST("blogpost"),
  COMMENT("comment"),
  ATTACHMENT("attachment");

  private String identifier;

  StandardContentType(String name) {
    this.identifier = name;
  }

  /**
   * This method returns the identifier for the type.
   *
   * @return The identifier for the type.
   */
  public String getIdentifier() {
    return this.identifier;
  }
}
