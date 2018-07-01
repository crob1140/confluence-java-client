package com.github.crob1140.confluence.content;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.crob1140.confluence.spaces.Space;
import java.util.List;

/**
 * This class represents content within the Confluence Cloud server.
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Content {

  @JsonProperty
  private String id;
  @JsonProperty
  private String type;
  @JsonProperty
  private ContentStatus status;
  @JsonProperty
  private String title;
  @JsonProperty
  private Space space;
  @JsonProperty
  private List<Content> ancestors;
  @JsonProperty
  private ContentBody body;
  @JsonProperty
  private Metadata metadata;

  @SuppressWarnings("unused")
  private Content() {
    // Required for Jackson deserialization
  }

  private Content(Builder builder) {
    this.id = builder.id;
    this.type = builder.type;
    this.status = builder.status;
    this.title = builder.title;
    this.space = builder.space;
    this.ancestors = builder.ancestors;
    this.body = builder.body;
    this.metadata = builder.metadata;
  }

  /**
   * This method returns the unique identifier for the content.
   *
   * @return The unique identifier for the content.
   */
  public String getId() {
    return id;
  }

  /**
   * This method returns the type of the content. This may match one of the values defined in {@link
   * StandardContentType}, or may be a custom content type defined by an app.
   *
   * @return The type of the content
   */
  public String getType() {
    return type;
  }

  /**
   * This method returns the status of the content.
   *
   * @return The status of the content
   */
  public ContentStatus getStatus() {
    return status;
  }

  /**
   * This method returns the title of the content.
   *
   * @return The title of the content
   */
  public String getTitle() {
    return title;
  }

  /**
   * This method returns the space that this content is in.
   *
   * @return The space that this content is in.
   */
  public Space getSpace() {
    return space;
  }

  /**
   * This method returns the ancestors of this content.
   *
   * @return The ancestors of this content.
   */
  public List<Content> getAncestors() {
    return ancestors;
  }

  /**
   * This method returns the body of this content.
   *
   * @return The body of this content.
   */
  public ContentBody getBody() {
    return body;
  }

  /**
   * This method returns the metadata of this content.
   *
   * @return The metadata of this content.
   */
  public Metadata getMetadata() {
    return metadata;
  }

  /**
   * This class can be used to construct an instance of {@link Content} for the purposes of creating
   * or modifying some content on the Confluence Cloud server.
   */
  public static class Builder {

    private String id;
    private String type;
    private ContentStatus status;
    private String title;
    private Space space;
    private List<Content> ancestors;
    private ContentBody body;
    private Metadata metadata;

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
     * <p>This method sets the type of the content.</p>
     *
     * <p>This method should only be used for custom types. Please use {@link
     * #setType(StandardContentType)} when setting one of the standard content types.</p>
     *
     * @param type The type of the content.
     * @return This instance, for the purposes of method chaining.
     */
    public Builder setType(String type) {
      this.type = type;
      return this;
    }

    /**
     * This method sets the type of the content.
     *
     * @param type The type of the content.
     * @return This instance, for the purposes of method chaining.
     */
    public Builder setType(StandardContentType type) {
      this.type = type.getIdentifier();
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
     * This method sets the space of the content by key.
     *
     * @param spaceKey The key of the space that the content will belong to.
     * @return This instance, for the purposes of method chaining.
     */
    public Builder setSpaceKey(String spaceKey) {
      this.space = new Space(spaceKey); // TODO: can you provide id or name instead?
      return this;
    }

    /**
     * This method sets the body of the content.
     *
     * @param body The body of the content.
     * @return This instance, for the purposes of method chaining.
     */
    public Builder setBody(ContentBody body) {
      this.body = body;
      return this;
    }

    /**
     * This method sets the ancestors of the content.
     *
     * @param ancestors The ancestors of the content.
     * @return This instance, for the purposes of method chaining.
     */
    public Builder setAncestors(List<Content> ancestors) {
      this.ancestors = ancestors;
      return this;
    }

    /**
     * This method sets the metadata of the content.
     *
     * @param metadata The metadata of the content.
     * @return This instance, for the purposes of method chaining.
     */
    public Builder setMetadata(Metadata metadata) {
      this.metadata = metadata;
      return this;
    }

    /**
     * This method creates an instance of {@link Content} using the values that were set on this
     * instance.
     *
     * @return A new instance of {@link Content} with the values set on this instance.
     */
    public Content build() {
      return new Content(this);
    }
  }
}
