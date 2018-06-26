package com.github.crob1140.confluence.content;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * This class represents the metadata for an instance of {@link Content}.
 */
@JsonInclude(Include.NON_NULL)
public class Metadata {

  @JsonProperty
  private List<Label> labels;
  @JsonProperty
  private Version version;

  /**
   * This constructor creates a metadata instance with only the labels defined.
   *
   * @param labels The labels to define.
   */
  public Metadata(List<Label> labels) {
    this.labels = labels;
  }

  /**
   * This method returns the labels on the content corresponding to this metadata.
   *
   * @return The labels on the content corresponding to this metadata.
   */
  public List<Label> getLabels() {
    return this.labels;
  }

  /**
   * This method returns the version of the content corresponding to this metadata.
   *
   * @return The version of the content corresponding to this metadata.
   */
  public Version getVersion() {
    return this.version;
  }
}
