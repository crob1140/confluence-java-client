package com.github.crob1140.confluence.content.expand;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * This class represents the metadata that can be expanded in a {@link
 * com.github.crob1140.confluence.content.Content} instance returned from the Confluence Cloud
 * server.
 */
public class ExpandedMetadataProperties {

  private final Set<String> properties;

  private ExpandedMetadataProperties(Builder builder) {
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
   * This class can be used to construct an instance of {@link ExpandedMetadataProperties}.
   */
  public static class Builder {

    private Set<String> properties;

    public Builder() {
      this.properties = new HashSet<>();
    }

    /**
     * This method adds "currentuser" as a property to be expanded.
     *
     * @return This instance, for the purposes of method chaining.
     */
    public Builder addCurrentUser() {
      this.properties.add("currentuser");
      return this;
    }

    /**
     * This method adds "properties" as a property to be expanded.
     *
     * @return This instance, for the purposes of method chaining.
     */
    public Builder addProperties() {
      this.properties.add("properties");
      return this;
    }

    /**
     * This method adds "labels" as a property to be expanded.
     *
     * @return This instance, for the purposes of method chaining.
     */
    public Builder addLabels() {
      this.properties.add("labels");
      return this;
    }

    /**
     * This method adds "frontend" as a property to be expanded.
     *
     * @return This instance, for the purposes of method chaining.
     */
    public Builder addFrontEnd() {
      this.properties.add("frontend");
      return this;
    }

    /**
     * This method creates an instance of {@link ExpandedMetadataProperties} using the values that
     * were set on this instance.
     *
     * @return A new instance of {@link ExpandedMetadataProperties} with the values set on this
     * instance.
     */
    public ExpandedMetadataProperties build() {
      return new ExpandedMetadataProperties(this);
    }
  }
}
