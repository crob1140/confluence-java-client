package com.github.crob1140.confluence.spaces;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents a space in the Confluence Cloud server.
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Space {

  @JsonProperty
  private Integer id;
  @JsonProperty
  private String name;
  @JsonProperty
  private SpaceType type;
  @JsonProperty
  private SpaceStatus status;
  @JsonProperty
  private String key;

  @SuppressWarnings("unused")
  private Space() {
    // Required for Jackson deserialization
  }

  /**
   * This constructor creates a space containing with only the key defined.
   *
   * @param key The key of the space.
   */
  public Space(String key) {
    this.key = key;
  }

  /**
   * This method returns the unique identifer for the space.
   *
   * @return The unique identifier for the space.
   */
  public Integer getId() {
    return id;
  }

  /**
   * This method returns the name of the space.
   *
   * @return The name of the space.
   */
  public String getName() {
    return name;
  }

  /**
   * This method returns the type of the space.
   *
   * @return The type of the space.
   */
  public SpaceType getType() {
    return type;
  }

  /**
   * This method returns the status of the space.
   *
   * @return The status of the space.
   */
  public SpaceStatus getStatus() {
    return status;
  }

  /**
   * This method returns the key of the space.
   *
   * @return The key of the space.
   */
  public String getKey() {
    return key;
  }
}
