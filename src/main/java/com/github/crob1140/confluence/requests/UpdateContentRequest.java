package com.github.crob1140.confluence.requests;

import com.github.crob1140.confluence.content.Content;
import com.github.crob1140.confluence.content.ContentBody;
import com.github.crob1140.confluence.content.ContentBodyType;
import com.github.crob1140.confluence.content.ContentStatus;
import com.github.crob1140.confluence.content.Label;
import com.github.crob1140.confluence.content.LabelPrefix;
import com.github.crob1140.confluence.content.Metadata;
import com.github.crob1140.confluence.content.StandardContentType;
import com.github.crob1140.confluence.content.Version;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.ws.rs.HttpMethod;

/**
 * This class represents a request to update content in the Confluence Cloud server.
 */
public class UpdateContentRequest extends ConfluenceRequest {

  private String id;
  private Content content;

  private UpdateContentRequest(Builder builder) {
    this.id = builder.id;

    Content.Builder contentBuilder = new Content.Builder();
    if (builder.ancestorId != null) {
      Content ancestor = new Content.Builder().setId(builder.ancestorId).build();
      contentBuilder.setAncestors(Collections.singletonList(ancestor));
    }

    if (builder.bodyContent != null) {
      contentBuilder.setBody(new ContentBody(builder.bodyType, builder.bodyContent));
    }

    if (!builder.labels.isEmpty()) {
      contentBuilder.setMetadata(new Metadata(builder.labels));
    }

    this.content = contentBuilder
        .setTitle(builder.title)
        .setStatus(builder.status)
        .setType(builder.type)
        .setVersion(new Version(builder.versionNumber))
        .build();
  }


  /**
   * This method returns the path of the request relative to the Confluence wiki root.
   *
   * @return The path of the request relative to the Confluence wiki root.
   */
  @Override
  public String getRelativePath() {
    return "rest/api/content/" + id;
  }

  /**
   * This method returns the HTTP method used by this request.
   */
  @Override
  public String getMethod() {
    return HttpMethod.PUT;
  }

  /**
   * This method returns the query parameters for this request.
   *
   * @return The query parameters for this request.
   */
  @Override
  public Map<String, String> getQueryParams() {
    return new HashMap<>();
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
   * This class can be used to construct an instance of {@link UpdateContentRequest}.
   */
  public static final class Builder {

    private String id;
    private String ancestorId;
    private Integer versionNumber;
    private String type;
    private ContentStatus status;
    private ContentBodyType bodyType;
    private String bodyContent;
    private String title;
    private List<Label> labels = new ArrayList<>();

    /**
     * This method sets the unique identifier of the content to be updated.
     *
     * @param id The unique identifier for the content.
     * @return This instance, for the purposes of method chaining.
     */
    public Builder setId(String id) {
      this.id = id;
      return this;
    }

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
     * This method sets the version number of the content.
     *
     * @param versionNumber The version number of the content.
     * @return This instance, for the purposes of method chaining.
     */
    public Builder setVersion(int versionNumber) {
      this.versionNumber = versionNumber;
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
     * This method adds a label to the content updated by the request, with the global prefix. To
     * specify a different prefix, refer to {@link #addLabel(String, LabelPrefix)} instead.
     *
     * @param label The label to add to the content.
     * @return This instance, for the purposes of method chaining.
     */
    public Builder addLabel(String label) {
      return addLabel(label, LabelPrefix.GLOBAL);
    }

    /**
     * This method adds a label to the content updated by the request with the given value and
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
     * This method sets the body of the content.
     *
     * @param type The body type that is being defined.
     * @param content The value to set for the body type.
     * @return This instance, for the purposes of method chaining.
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
     * This method creates an instance of {@link UpdateContentRequest} using the values that were
     * set on this instance.
     *
     * @return A new instance of {@link UpdateContentRequest} with the values set on this instance.
     * @throws IllegalStateException If the request that would be created would be invalid.
     */
    public UpdateContentRequest build() {
      if (this.id == null) {
        throw new IllegalStateException(
            "You must specify the ID of the content you are trying to update");
      }

      if (this.type == null) {
        throw new IllegalStateException(
            "You must specify the type of content you are trying to update");
      }

      if (this.versionNumber == null) {
        throw new IllegalStateException("You must specify the new version of the content");
      }

      return new UpdateContentRequest(this);
    }
  }
}
