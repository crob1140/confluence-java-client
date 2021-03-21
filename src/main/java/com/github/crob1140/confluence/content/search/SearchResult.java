package com.github.crob1140.confluence.content.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.crob1140.confluence.content.Content;
import com.github.crob1140.confluence.spaces.Space;
import com.github.crob1140.confluence.users.User;

/**
 * This class represents a search result within an instance of {@link com.github.crob1140.confluence.requests.SearchContentResponse}.
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResult
{

  @JsonProperty
  private Content content;

  @JsonProperty
  private Space space;

  @JsonProperty
  private User user;

  @JsonProperty
  private String title;

  @JsonProperty
  private String url;

  @JsonProperty
  private String excerpt;

  @JsonProperty
  private SearchResultContainer resultGlobalContainer;

  @JsonProperty
  private String entityType;

  @JsonProperty
  private String iconCssClass;

  @JsonProperty
  private String lastModified;

  @JsonProperty
  private String friendlyLastModified;

  @JsonProperty
  private String timestamp;

  @SuppressWarnings("unused")
  private SearchResult() {
    // Required for Jackson deserialization
  }

  /**
   * This constructor creates a new search result with given values.
   *
   * @param content The content for the search result.
   * @param space The space for the search result.
   * @param user The user for the search result.
   * @param title The name for the search result.
   * @param url The url for the search result.
   * @param excerpt The excerpt for the search result.
   * @param resultGlobalContainer The resultGlobalContainer for the search result.
   * @param entityType The entityType for the search result.
   * @param iconCssClass The iconCssClass for the search result.
   * @param lastModified The lastModified for the search result.
   * @param friendlyLastModified The friendlyLastModified for the search result.
   * @param timestamp The timestamp for the search result.
   */
  public SearchResult(Content content, Space space, User user, String title, String url, String excerpt, SearchResultContainer resultGlobalContainer, String entityType, String iconCssClass,
      String lastModified, String friendlyLastModified, String timestamp)
  {
    this.content = content;
    this.space = space;
    this.user = user;
    this.title = title;
    this.url = url;
    this.excerpt = excerpt;
    this.resultGlobalContainer = resultGlobalContainer;
    this.entityType = entityType;
    this.iconCssClass = iconCssClass;
    this.lastModified = lastModified;
    this.friendlyLastModified = friendlyLastModified;
    this.timestamp = timestamp;
  }

  public Content getContent() {
    return content;
  }

  public Space getSpace() {
    return space;
  }

  public User getUser() {
    return user;
  }

  public String getTitle() {
    return title;
  }

  public String getUrl() {
    return url;
  }

  public String getExcerpt() {
    return excerpt;
  }

  public SearchResultContainer getResultGlobalContainer() {
    return resultGlobalContainer;
  }

  public String getEntityType() {
    return entityType;
  }

  public String getIconCssClass() {
    return iconCssClass;
  }

  public String getLastModified() {
    return lastModified;
  }

  public String getFriendlyLastModified() {
    return friendlyLastModified;
  }

  public String getTimestamp() {
    return timestamp;
  }

}
