package com.github.crob1140.confluence.requests;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.crob1140.confluence.content.search.SearchResult;

/**
 * This class represents the response that is returned for a {@link SearchContentRequest}.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResponse
{

  @JsonProperty
  private List<SearchResult> results;
  @JsonProperty
  private Integer start;
  @JsonProperty
  private Integer limit;
  @JsonProperty
  private Integer size;
  @JsonProperty
  private Integer totalSize;
  @JsonProperty
  private String cqlQuery;
  @JsonProperty
  private Integer searchDuration;

  @SuppressWarnings("unused")
  private SearchResponse() {
    // Required for Jackson deserialization
  }

  /**
   * This constructor initialises the response with the given set of results.
   *
   * @param results The results contained in the response
   */
  public SearchResponse(List<SearchResult> results) {
    this.results = results;
  }

  /**
   * This method returns the matching content contained in the response to a {@link
   * SearchContentRequest}.
   *
   * @return The contained in the response to a {@link SearchContentRequest}.
   */
  public List<SearchResult> getResults() {
    return this.results;
  }
}
