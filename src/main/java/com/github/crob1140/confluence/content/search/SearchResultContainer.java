package com.github.crob1140.confluence.content.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.crob1140.confluence.content.LabelPrefix;
import com.github.crob1140.confluence.content.Metadata;

/**
 * This class represents a global result container contained within an instance of {@link com.github.crob1140.confluence.requests.SearchContentRequest}.
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResultContainer
{

  @JsonProperty
  private String title;

  @JsonProperty
  private String displayUrl;

  @SuppressWarnings("unused")
  private SearchResultContainer() {
    // Required for Jackson deserialization
  }

  /**
   * This constructor creates a new global result container with the given spaceKey and contentId.
   *
   * @param title The title of this global result container.
   * @param displayUrl The displayUrl of this global result container.
   */
  public SearchResultContainer(String title, String displayUrl) {
    this.title = title;
    this.displayUrl = displayUrl;
  }

  /**
   * This method returns the title of this global result container.
   *
   * @return The title of this global result container.
   */
  public String getTitle() {
    return title;
  }

  /**
   * This method returns the displayUrl of this global result container.
   *
   * @return The displayUrl of this global result container.
   */
  public String getDisplayUrl() {
    return displayUrl;
  }
}
