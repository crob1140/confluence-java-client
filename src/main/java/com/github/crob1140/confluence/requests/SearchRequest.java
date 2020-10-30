package com.github.crob1140.confluence.requests;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.ws.rs.HttpMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.crob1140.confluence.content.expand.ExpandedContentProperties;
import com.github.crob1140.confluence.content.search.CqlContext;
import com.github.crob1140.confluence.content.search.Excerpt;

/**
 * This class represents a request to get content from the Confluence Cloud server.
 *
 * @see <a href="https://developer.atlassian.com/server/confluence/advanced-searching-using-cql/">Confluence Query Language (CQL)</a>
 * @see <a href="https://docs.atlassian.com/atlassian-confluence/REST/6.6.0/#search-search">Confluence Search API</a>
 */
public class SearchRequest
    extends ConfluenceRequest {

  /**
   * The CQL query.
   */
  private final String cql;

  /**
   * The execution context for CQL functions, provides current space key and content id. If this is not provided some CQL functions will not be available.
   */
  private final CqlContext cqlContext;

  /**
   * The excerpt strategy to apply to the result, one of: indexed, highlight, none. This defaults to highlight.
   * Default value: highlight
   */
  private final Excerpt excerpt;

  /**
   * Whether to include content in archived spaces in the result, this defaults to false.
   * Default value: false
   */
  private final Boolean includeArchivedSpaces;

  /**
   * The limit of the number of items to return, this may be restricted by fixed system limits.
   * Default value: 25
   */
  private final Integer limit;

  /**
   * The start point of the collection to return.
   * Default value: 0
   */
  private final Integer start;

  /**
   * The properties to expand on the search result, this may cause database requests for some properties.
   */
  private final ExpandedContentProperties expandedProperties;

  private SearchRequest(Builder builder) {
    cql = builder.cql;
    cqlContext = builder.cqlContext;
    excerpt = builder.excerpt;
    includeArchivedSpaces = builder.includeArchivedSpaces;
    limit = builder.limit;
    start = builder.start;
    expandedProperties = builder.expandedProperties;
  }

  /**
   * This method returns the path of the request relative to the Confluence wiki root.
   *
   * @return The path of the request relative to the Confluence wiki root.
   */
  @Override
  public String getRelativePath() {
    return "rest/api/search";
  }

  /**
   * This method returns the HTTP method used by this request.
   */
  @Override
  public String getMethod() {
    return HttpMethod.GET;
  }

  /**
   * This method returns the query parameters for this request.
   *
   * @return The query parameters for this request.
   */
  @Override
  public Map<String, String> getQueryParams() {
    Map<String, String> queryParams = new HashMap<>();

    if (this.cql != null) {
      queryParams.put("cql", this.cql);
    }

    if (this.cqlContext != null) {
      String param = cqlContextToQueryParam(this.cqlContext);
      if(param != null)
      {
        queryParams.put("cqlcontext", param);
      }
    }

    if (this.excerpt != null) {
      queryParams.put("excerpt", this.excerpt.getIdentifier());
    }

    if (this.includeArchivedSpaces != null) {
      queryParams.put("includeArchivedSpaces", this.includeArchivedSpaces.toString());
    }

    if (this.limit != null) {
      queryParams.put("limit", Integer.toString(this.limit));
    }

    if (this.start != null) {
      queryParams.put("start", Integer.toString(this.start));
    }

    if (this.expandedProperties != null) {
      queryParams.put("expand", this.expandedProperties.getProperties()
          .stream().collect(Collectors.joining(",")));
    }

    return queryParams;
  }

  private String cqlContextToQueryParam(CqlContext cqlContext)
  {
    try
    {
      String jsonString = new ObjectMapper().writeValueAsString(cqlContext);
      String urlEncodedJson = URLEncoder.encode(jsonString, StandardCharsets.UTF_8.toString());
      return urlEncodedJson;
    } catch (Exception ex) {
      System.out.println("Skipping invalid CQL context");
    }
    return null;
  }

  /**
   * This method returns the entity that is sent in the body of the request.
   *
   * @return The entity that is sent in the body of the request.
   */
  @Override
  public Optional<Object> getBodyEntity() {
    return Optional.empty();
  }

  /**
   * This method returns the class of the object in the body of the response for this request.
   *
   * @return The class of the object in the body of response for this request.
   */
  @Override
  public Class<?> getReturnType() {
    return SearchContentResponse.class;
  }

  /**
   * This class can be used to construct an instance of {@link SearchRequest}.
   */
  public static final class Builder {

    private String cql;
    private CqlContext cqlContext;
    private Excerpt excerpt;
    private Boolean includeArchivedSpaces;
    private Integer limit;
    private Integer start;
    private ExpandedContentProperties expandedProperties;

    /**
     * This method sets the CQL query.
     *
     * @param cql the Confluence Query Language (CQL) query
     * @return This instance, for the purposes of method chaining.
     */
    public Builder setCql(String cql) {
      this.cql = cql;
      return this;
    }

    /**
     * This method sets the CQL context.
     *
     * @param cqlContext the Confluence Query Language (CQL) context
     * @return This instance, for the purposes of method chaining.
     */
    public Builder setCqlContext(CqlContext cqlContext) {
      this.cqlContext = cqlContext;
      return this;
    }

    /**
     * This method sets excerpt strategy to apply to the result.
     *
     * @param excerpt the excerpt strategy to apply to the result
     * @return This instance, for the purposes of method chaining.
     */
    public Builder setExcerpt(Excerpt excerpt) {
      this.excerpt = excerpt;
      return this;
    }

    /**
     * This method sets whether to include content in archived spaces in the result.
     *
     * @param includeArchivedSpaces whether to include content in archived spaces
     * @return This instance, for the purposes of method chaining.
     */
    public Builder includeArchivedSpaces(Boolean includeArchivedSpaces) {
      this.includeArchivedSpaces = includeArchivedSpaces;
      return this;
    }

    /**
     * This method sets the maximum number of results for the request.
     *
     * @param limit the maximum number of results
     * @return This instance, for the purposes of method chaining.
     */
    public Builder setLimit(Integer limit) {
      this.limit = limit;
      return this;
    }

    /**
     * This method sets the pagination start position for the request.
     *
     * @param start the pagination start position
     * @return This instance, for the purposes of method chaining.
     */
    public Builder setStartPosition(Integer start) {
      this.start = start;
      return this;
    }

    /**
     * This method sets the properties to be expanded in the results of this request.
     *
     * @param expandedProperties the properties to expand in the results of this request.
     * @return This instance, for the purposes of method chaining.
     */
    public Builder setExpandedProperties(ExpandedContentProperties expandedProperties) {
      this.expandedProperties = expandedProperties;
      return this;
    }

    /**
     * This method creates an instance of {@link SearchRequest} using the values that were set
     * on this instance.
     *
     * @return A new instance of {@link SearchRequest} with the values set on this instance.
     */
    public SearchRequest build() throws IllegalStateException {
      if (this.cql == null) {
        throw new IllegalStateException(
            "You must specify a CQL query");
      }

      if (this.limit != null && this.limit <= 0) {
        throw new IllegalStateException("The limit must be a positive number");
      }

      if (this.start != null && this.start <= 0) {
        throw new IllegalStateException("The start position must be a positive number");
      }

      return new SearchRequest(this);
    }
  }

}
