package com.github.crob1140.confluence.content.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.crob1140.confluence.content.LabelPrefix;
import com.github.crob1140.confluence.content.Metadata;

/**
 * This class represents a CQL search context contained within an instance of {@link com.github.crob1140.confluence.requests.SearchContentRequest}.
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CqlContext
{

  @JsonProperty
  private String spaceKey;

  @JsonProperty
  private String contentId;

  @SuppressWarnings("unused")
  private CqlContext() {
    // Required for Jackson deserialization
  }

  /**
   * This constructor creates a new CQL context with the given spaceKey and contentId.
   *
   * @param spaceKey The spaceKey to search in.
   * @param contentId The contentId to search in.
   */
  public CqlContext(String spaceKey, String contentId) {
    this.spaceKey = spaceKey;
    this.contentId = contentId;
  }

  /**
   * This method returns the spaceKey of this CQL context.
   *
   * @return The spaceKey of this label.
   */
  public String getSpaceKey() {
    return spaceKey;
  }

  /**
   * This method returns the contentId of this CQL context.
   *
   * @return The contentId of this label.
   */
  public String getContentId() {
    return contentId;
  }
}
