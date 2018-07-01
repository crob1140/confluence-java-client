package com.github.crob1140.confluence.content.expand;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * This class represents the properties that can be expanded in a {@link
 * com.github.crob1140.confluence.content.ContentBodyFormat} instance returned from the Confluence
 * Cloud server.
 */
public class ExpandedBodyFormatProperties {

  private final Set<String> properties;

  private ExpandedBodyFormatProperties(Builder builder) {
    this.properties = Collections.unmodifiableSet(builder.properties);
  }

  /**
   * This method returns the set of properties that are to be expanded.
   *
   * @return The set of properties to be expanded.
   */
  public Set<String> getProperties() {
    return this.properties;
  }

  /**
   * This class can be used to construct an instance of {@link ExpandedBodyFormatProperties}.
   */
  public static class Builder {

    private Set<String> properties;

    public Builder() {
      this.properties = new HashSet<>();
    }

    /**
     * This method adds "value" as a property to be expanded.
     *
     * @return This instance, for the purposes of method chaining.
     */
    public Builder addValue() {
      this.properties.add("value");
      return this;
    }

    /**
     * This method adds "representation" as a property to be expanded.
     *
     * @return This instance, for the purposes of method chaining.
     */
    public Builder addRepresentation() {
      this.properties.add("representation");
      return this;
    }

    /**
     * This method adds "webresource" as a property to be expanded.
     *
     * @return This instance, for the purposes of method chaining.
     */
    public Builder addWebResource() {
      this.properties.add("webresource");
      return this;
    }

    /**
     * This method adds "embeddedContent" as a property to be expanded.
     *
     * @return This instance, for the purposes of method chaining.
     */
    public Builder addEmbeddedContent() {
      this.properties.add("embeddedContent");
      return this;
    }

    /**
     * This method adds "mediaToken" as a property to be expanded.
     *
     * @return This instance, for the purposes of method chaining.
     */
    public Builder addMediaToken() {
      this.properties.add("mediaToken");
      return this;
    }

    /**
     * This method creates an instance of {@link ExpandedBodyFormatProperties} using the values that
     * were set on this instance.
     *
     * @return A new instance of {@link ExpandedBodyFormatProperties} with the values set on this
     * instance.
     */
    public ExpandedBodyFormatProperties build() {
      return new ExpandedBodyFormatProperties(this);
    }
  }
}
