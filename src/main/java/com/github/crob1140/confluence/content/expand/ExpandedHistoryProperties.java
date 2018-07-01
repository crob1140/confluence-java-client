package com.github.crob1140.confluence.content.expand;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * This class represents the history that can be expanded in a {@link
 * com.github.crob1140.confluence.content.Content} instance returned from the Confluence Cloud
 * server.
 */
public class ExpandedHistoryProperties {

  private final Set<String> properties;

  private ExpandedHistoryProperties(Builder builder) {
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
   * This class can be used to construct an instance of {@link ExpandedHistoryProperties}.
   */
  public static class Builder {

    private Set<String> properties;

    public Builder() {
      this.properties = new HashSet<>();
    }

    /**
     * This method adds "lastUpdated" as a property to be expanded.
     *
     * @return This instance, for the purposes of method chaining.
     */
    public Builder addLastUpdated() {
      this.properties.add("lastUpdated");
      return this;
    }

    /**
     * This method adds "previousVersion" as a property to be expanded.
     *
     * @return This instance, for the purposes of method chaining.
     */
    public Builder addPreviousVersion() {
      this.properties.add("previousVersion");
      return this;
    }

    /**
     * This method adds "contributors" as a property to be expanded.
     *
     * @return This instance, for the purposes of method chaining.
     */
    public Builder addContributors() {
      this.properties.add("contributors");
      return this;
    }

    /**
     * This method adds "nextVersion" as a property to be expanded.
     *
     * @return This instance, for the purposes of method chaining.
     */
    public Builder addNextVersion() {
      this.properties.add("nextVersion");
      return this;
    }

    /**
     * This method creates an instance of {@link ExpandedHistoryProperties} using the values that
     * were set on this instance.
     *
     * @return A new instance of {@link ExpandedHistoryProperties} with the values set on this
     * instance.
     */
    public ExpandedHistoryProperties build() {
      return new ExpandedHistoryProperties(this);
    }
  }
}
