package com.github.crob1140.confluence.content.expand;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * This class represents the descendants that can be expanded in a {@link
 * com.github.crob1140.confluence.content.Content} instance returned from the Confluence Cloud
 * server.
 */
public class ExpandedDescendantsProperties {

  private final Set<String> properties;

  private ExpandedDescendantsProperties(Builder builder) {
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
   * This class can be used to construct an instance of {@link ExpandedDescendantsProperties}.
   */
  public static class Builder {

    private Set<String> properties;

    public Builder() {
      this.properties = new HashSet<>();
    }

    /**
     * This method adds "page" to the list of descendant types to be expanded.
     *
     * @return This instance, for the purposes of method chaining.
     */
    public Builder addPage() {
      this.properties.add("page");
      return this;
    }

    /**
     * This method adds "attachment" to the list of descendant types to be expanded.
     *
     * @return This instance, for the purposes of method chaining.
     */
    public Builder addAttachment() {
      this.properties.add("attachment");
      return this;
    }

    /**
     * This method adds "comment" to the list of descendant types to be expanded.
     *
     * @return This instance, for the purposes of method chaining.
     */
    public Builder addComment() {
      this.properties.add("comment");
      return this;
    }

    /**
     * This method creates an instance of {@link ExpandedDescendantsProperties} using the values
     * that were set on this instance.
     *
     * @return A new instance of {@link ExpandedDescendantsProperties} with the values set on this
     * instance.
     */
    public ExpandedDescendantsProperties build() {
      return new ExpandedDescendantsProperties(this);
    }
  }
}
