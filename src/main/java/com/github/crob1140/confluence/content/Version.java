package com.github.crob1140.confluence.content;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.crob1140.confluence.users.User;

/**
 * This class represents a version information for an instance of {@link Content}.
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Version {

  @JsonProperty
  private User by;
  @JsonProperty
  private Integer number;

  /**
   * This method returns the user that created the content.
   *
   * @return The user that created the content.
   */
  public User getBy() {
    return by;
  }

  /**
   * This method returns the number of the version.
   *
   * @return The number of the version.
   */
  public Integer getNumber() {
    return number;
  }
}
