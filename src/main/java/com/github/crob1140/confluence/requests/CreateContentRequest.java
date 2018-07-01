package com.github.crob1140.confluence.requests;

import com.github.crob1140.confluence.content.Content;
import com.github.crob1140.confluence.content.ContentBody;
import com.github.crob1140.confluence.content.ContentBodyType;
import com.github.crob1140.confluence.content.ContentStatus;
import com.github.crob1140.confluence.content.Label;
import com.github.crob1140.confluence.content.LabelPrefix;
import com.github.crob1140.confluence.content.Metadata;
import com.github.crob1140.confluence.content.StandardContentType;
import com.github.crob1140.confluence.content.expand.ExpandedContentProperties;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.ws.rs.HttpMethod;

/**
 * This class represents a request to create content in the Confluence Cloud server.
 */
public class CreateContentRequest extends ConfluenceRequest {

  // Query params
  private final ContentStatus responseStatusFilter;
  private final ExpandedContentProperties expandedResponseProperties;

  // Body
  private Content content;

  private CreateContentRequest(Builder builder) {
    this.responseStatusFilter = builder.responseStatusFilter;
    this.expandedResponseProperties = builder.expandedResponseProperties;

    Content.Builder contentBuilder = new Content.Builder();
    if (builder.ancestorId != null) {
      Content ancestor = new Content.Builder().setId(builder.ancestorId).build();
      contentBuilder.setAncestors(Collections.singletonList(ancestor));
    }

    if (builder.bodyContent != null) {
      contentBuilder.setBody(new ContentBody(builder.bodyType, builder.bodyContent));
    }

    this.content = contentBuilder
        .setId(builder.id)
        .setTitle(builder.title)
        .setStatus(builder.status)
        .setSpaceKey(builder.spaceKey)
        .setType(builder.type)
        .setMetadata(new Metadata(builder.labels))
        .build();
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
    return HttpMethod.POST;
  }

  /**
   * This method returns the query parameters for this request.
   *
   * @return The query parameters for this request.
   */
  @Override
  public Map<String, String> getQueryParams() {
    Map<String, String> queryParams = new HashMap<>();

    if (this.responseStatusFilter != null) {
      queryParams.put("status", responseStatusFilter.getIdentifier());
    }

    if (this.expandedResponseProperties != null) {
      queryParams.put("expand", this.expandedResponseProperties.getProperties()
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
    return Optional.of(this.content);
  }

  /**
   * This method returns the class of the object in the body of the response for this request.
   *
   * @return The class of the object in the body of response for this request.
   */
  @Override
  public Class<?> getReturnType() {
    return Content.class;
  }

  /**
   * This class can be used to construct an instance of {@link CreateContentRequest}.
   */
  public static class Builder {

    private ContentStatus responseStatusFilter;
    private ContentBodyType bodyType;
    private String bodyContent;
    private String ancestorId;
    private String id;
    private String spaceKey;
    private ContentStatus status;
    private String title;
    private String type;
    private List<Label> labels = new ArrayList<>();
    private ExpandedContentProperties expandedResponseProperties;

    /**
     * This method sets the ancestor for the content by ID.
     *
     * @param id The ID of the ancestor.
     * @return This instance, for the purposes of method chaining.
     */
    public Builder setAncestor(String id) {
      this.ancestorId = id;
      return this;
    }

    /**
     * This method sets the unique identifier for the content.
     *
     * @param id The unique identifier for the content.
     * @return This instance, for the purposes of method chaining.
     */
    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    /**
     * This method sets the title of the content.
     *
     * @param title The title of the content.
     * @return This instance, for the purposes of method chaining.
     */
    public Builder setTitle(String title) {
      this.title = title;
      return this;
    }

    /**
     * This method sets the space that this content shall belong to by key.
     *
     * @param spaceKey The key of the space that this content shall belong to.
     * @return This instance, for the purposes of method chaining.
     */
    public Builder setSpaceKey(String spaceKey) {
      this.spaceKey = spaceKey;
      return this;
    }

    /**
     * This method sets the status of the content.
     *
     * @param status The status of the content.
     * @return This instance, for the purposes of method chaining.
     */
    public Builder setStatus(ContentStatus status) {
      this.status = status;
      return this;
    }

    /**
     * This method sets the body of the content.
     *
     * @param type The body type that is being defined.
     * @param content The value to set for the body type.
     */
    public Builder setBody(ContentBodyType type, String content) {
      this.bodyType = type;
      this.bodyContent = content;
      return this;
    }

    /**
     * This method defines the type of the content. This should be used when setting the content
     * type to a custom type defined by an app. For setting standard content types, refer to {@link
     * #setType(StandardContentType)} instead.
     *
     * @param type The type of the content.
     * @return This instance, for the purposes of method chaining.
     */
    public Builder setType(String type) {
      this.type = type;
      return this;
    }

    /**
     * This method defines the type of the content. This may match one of the values defined in
     * {@link StandardContentType}, or may be a custom content type defined by an app.
     *
     * @param type The type of the content.
     * @return This instance, for the purposes of method chaining.
     */
    public Builder setType(StandardContentType type) {
      this.type = type.getIdentifier();
      return this;
    }

    /**
     * This method sets the status filter for the {@link Content} that is returned as a response to
     * the request.
     *
     * @param status The status filter for the returned content.
     * @return This instance, for the purposes of method chaining.
     */
    public Builder setResponseStatusFilter(ContentStatus status) {
      this.responseStatusFilter = status;
      return this;
    }

    /**
     * This method adds a label to the content created by the request, with the global prefix. To
     * specify a different prefix, refer to {@link #addLabel(String, LabelPrefix)} instead.
     *
     * @param label The label to add to the content.
     * @return This instance, for the purposes of method chaining.
     */
    public Builder addLabel(String label) {
      return addLabel(label, LabelPrefix.GLOBAL);
    }

    /**
     * This method adds a label to the content created by the request with the given value and
     * prefix.
     *
     * @param label The label to add to the content.
     * @param prefix The prefix of the label.
     * @return This instance, for the purposes of method chaining.
     */
    public Builder addLabel(String label, LabelPrefix prefix) {
      this.labels.add(new Label(prefix, label));
      return this;
    }

    /**
     * This method sets the properties to be expanded in the {@link Content} instance that is
     * returned as a response to this request.
     *
     * @param expandedResponseProperties the properties to expand in the {@link Content} instance
     * that is returned as a response to this request.
     */
    public Builder setExpandedResponseProperties(
        ExpandedContentProperties expandedResponseProperties) {
      this.expandedResponseProperties = expandedResponseProperties;
      return this;
    }

    /**
     * This method creates an instance of {@link CreateContentRequest} using the values that were
     * set on this instance.
     *
     * @return A new instance of {@link CreateContentRequest} with the values set on this instance.
     * @throws IllegalStateException If the request that would be created would be invalid.
     */
    public CreateContentRequest build() throws IllegalStateException {
      if (this.type == null || this.type.equals("")) {
        throw new IllegalStateException("You must specify the type of content you want to create");
      }

      if (this.spaceKey == null) {
        throw new IllegalStateException(
            "You must specify the space that the content is being created in");
      }

      if (this.status == ContentStatus.DRAFT && this.id == null) {
        throw new IllegalStateException("You must provide an ID when creating a draft");
      }
      return new CreateContentRequest(this);
    }
  }
}
