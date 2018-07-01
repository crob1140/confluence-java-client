package com.github.crob1140.confluence.content.expand;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * This class represents the restrictions that can be expanded in a {@link
 * com.github.crob1140.confluence.content.Content} instance returned from the Confluence Cloud
 * server.
 */
public class ExpandedRestrictionProperties {

  private final Set<String> properties;

  private ExpandedRestrictionProperties(Builder builder) {
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
   * This class can be used to construct an instance of {@link ExpandedRestrictionProperties}.
   */
  public static class Builder {

    private Set<String> properties;

    public Builder() {
      this.properties = new HashSet<>();
    }

    /**
     * This method adds "read.restrictions.user" as a property to be expanded.
     *
     * @return This instance, for the purposes of method chaining.
     */
    public Builder addReadUsers() {
      this.properties.add("read.restrictions.user");
      return this;
    }

    /**
     * This method adds "read.restrictions.group" as a property to be expanded.
     *
     * @return This instance, for the purposes of method chaining.
     */
    public Builder addReadGroups() {
      this.properties.add("read.restrictions.group");
      return this;
    }

    /**
     * This method adds "update.restrictions.user" as a property to be expanded.
     *
     * @return This instance, for the purposes of method chaining.
     */
    public Builder addUpdateUsers() {
      this.properties.add("update.restrictions.user");
      return this;
    }

    /**
     * This method adds "update.restrictions.group as a property to be expanded.
     *
     * @return This instance, for the purposes of method chaining.
     */
    public Builder addUpdateGroups() {
      this.properties.add("update.restrictions.group");
      return this;
    }

    /**
     * This method creates an instance of {@link ExpandedRestrictionProperties} using the values
     * that were set on this instance.
     *
     * @return A new instance of {@link ExpandedRestrictionProperties} with the values set on this
     * instance.
     */
    public ExpandedRestrictionProperties build() {
      return new ExpandedRestrictionProperties(this);
    }
  }
}
