package com.github.crob1140.confluence.requests;

import com.github.crob1140.confluence.content.ContentStatus;
import com.github.crob1140.confluence.content.SortDirection;
import com.github.crob1140.confluence.content.StandardContentType;
import com.github.crob1140.confluence.content.expand.ExpandedContentProperties;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.ws.rs.HttpMethod;

/**
 * This class represents a request to get content from the Confluence Cloud server.
 */
public class GetContentRequest extends ConfluenceRequest {

  // Query params
  private final Integer limit;
  private final String orderByField;
  private final SortDirection orderByDirection;
  private final LocalDate postingDay;
  private final String spaceKey;
  private final Integer start;
  private final ContentStatus status;
  private final String title;
  private final String trigger;
  private final String type;
  private final ExpandedContentProperties expandedProperties;

  private GetContentRequest(Builder builder) {
    limit = builder.limit;
    orderByField = builder.orderByField;
    orderByDirection = builder.orderByDirection;
    postingDay = builder.postingDay;
    spaceKey = builder.spaceKey;
    start = builder.start;
    status = builder.status;
    title = builder.title;
    trigger = builder.trigger;
    type = builder.type;
    expandedProperties = builder.expandedProperties;
  }

  /**
   * This method returns the path of the request relative to the Confluence wiki root.
   *
   * @return The path of the request relative to the Confluence wiki root.
   */
  @Override
  public String getRelativePath() {
    return "rest/api/content";
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

    if (this.limit != null) {
      queryParams.put("limit", Integer.toString(this.limit));
    }

    if (this.orderByField != null) {
      queryParams.put("orderBy", this.orderByField + " " + this.orderByDirection.getIdentifier());
    }

    if (this.postingDay != null) {
      queryParams.put("postingDay", this.postingDay.format(DateTimeFormatter.ISO_LOCAL_DATE));
    }

    if (this.spaceKey != null) {
      queryParams.put("spaceKey", this.spaceKey);
    }

    if (this.start != null) {
      queryParams.put("start", Integer.toString(this.start));
    }

    if (this.status != null) {
      queryParams.put("status", this.status.getIdentifier());
    }

    if (this.title != null) {
      queryParams.put("title", this.title);
    }

    if (this.trigger != null) {
      queryParams.put("trigger", this.trigger);
    }

    if (this.type != null) {
      queryParams.put("type", this.type);
    }

    if (this.expandedProperties != null) {
      queryParams.put("expand", this.expandedProperties.getProperties()
          .stream().collect(Collectors.joining(",")));
    }

    return queryParams;
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
    return GetContentResponse.class;
  }

  /**
   * This class can be used to construct an instance of {@link GetContentRequest}.
   */
  public static final class Builder {

    private Integer limit;
    private String orderByField;
    private SortDirection orderByDirection;
    private LocalDate postingDay;
    private String spaceKey;
    private Integer start;
    private ContentStatus status;
    private String title;
    private String trigger;
    private String type;
    private ExpandedContentProperties expandedProperties;

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
     * This method sets the order-by clause for the query.
     *
     * @param field the name of the field to order the results by
     * @param direction the direction in which the results should be sorted
     * @return This instance, for the purposes of method chaining.
     */
    public Builder orderBy(String field, SortDirection direction) {
      this.orderByField = field;
      this.orderByDirection = direction;
      return this;
    }

    /**
     * This method sets the required posting day for results. Only content that was created on the
     * given date will be returned as results.
     *
     * @param postingDay the posting date
     * @return This instance, for the purposes of method chaining.
     */
    public Builder setPostingDay(LocalDate postingDay) {
      this.postingDay = postingDay;
      return this;
    }

    /**
     * This method sets the space key for results. Only content within the given space will be
     * returned.
     *
     * @param spaceKey the key of the space
     * @return This instance, for the purposes of method chaining.
     */
    public Builder setSpaceKey(String spaceKey) {
      this.spaceKey = spaceKey;
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
     * This method sets the required status for results. Only content with the given status will be
     * returned as results.
     *
     * @param status the status of results
     * @return This instance, for the purposes of method chaining.
     */
    public Builder setStatus(ContentStatus status) {
      this.status = status;
      return this;
    }

    /**
     * This methods sets the required title for results. Only content with the given title will be
     * returned as results.
     *
     * @param title the title of results
     * @return This instance, for the purposes of method chaining.
     */
    public Builder setTitle(String title) {
      this.title = title;
      return this;
    }

    /**
     * This methods sets the event to trigger as a result of this request.
     *
     * @param trigger the trigger of results
     * @return This instance, for the purposes of method chaining.
     */
    public Builder setTrigger(String trigger) {
      this.trigger = trigger;
      return this;
    }

    /**
     * This method sets the type of content to return. Only content with the given type will be
     * returned as results.
     *
     * @param type the type of results
     * @return This instance, for the purposes of method chaining.
     */
    public Builder setType(String type) {
      this.type = type;
      return this;
    }

    /**
     * This method sets the type of content to return. Only content with the given type will be
     * returned as results.
     *
     * @param type the type of results
     * @return This instance, for the purposes of method chaining.
     */
    public Builder setType(StandardContentType type) {
      this.type = type.getIdentifier();
      return this;
    }

    /**
     * This method sets the properties to be expanded in the results of this request.
     *
     * @param expandedProperties the properties to expand in the results of this request.
     */
    public Builder setExpandedProperties(ExpandedContentProperties expandedProperties) {
      this.expandedProperties = expandedProperties;
      return this;
    }

    /**
     * This method creates an instance of {@link GetContentRequest} using the values that were set
     * on this instance.
     *
     * @return A new instance of {@link GetContentRequest} with the values set on this instance.
     */
    public GetContentRequest build() throws IllegalStateException {
      if (this.limit != null && this.limit <= 0) {
        throw new IllegalStateException("The limit must be a positive number");
      }

      if (this.start != null && this.start <= 0) {
        throw new IllegalStateException("The start position must be a positive number");
      }

      return new GetContentRequest(this);
    }
  }
}
