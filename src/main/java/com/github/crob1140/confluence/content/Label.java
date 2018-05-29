package com.github.crob1140.confluence.content;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents a label contained within an instance of {@link Metadata}.
 */
public class Label {

  @JsonProperty
  private LabelPrefix prefix = LabelPrefix.GLOBAL;
  @JsonProperty
  private String name;

  /**
   * This constructor creates a new label with the given prefix and name.
   *
   * @param prefix The prefix for the label.
   * @param name The name for the label.
   */
  public Label(LabelPrefix prefix, String name) {
    this.prefix = prefix;
    this.name = name;
  }

  /**
   * This method returns the prefix of this label.
   *
   * @return The prefix of this label.
   */
  public LabelPrefix getPrefix() {
    return prefix;
  }

  /**
   * This method returns the name of this label.
   *
   * @return The name of this label.
   */
  public String getName() {
    return name;
  }
}
