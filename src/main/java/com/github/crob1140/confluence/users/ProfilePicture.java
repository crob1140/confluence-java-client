package com.github.crob1140.confluence.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents the profile picture for a {@link User} in the Confluence Cloud server.
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfilePicture {

  @JsonProperty
  private String path;
  @JsonProperty
  private Integer width;
  @JsonProperty
  private Integer height;
  @JsonProperty
  private Boolean isDefault;

  /**
   * This method returns the path of the profile picture.
   *
   * @return The path of the profile picture.
   */
  public String getPath() {
    return this.path;
  }

  /**
   * This method returns the width of the profile picture, in pixels.
   *
   * @return The width of the profile picture.
   */
  public Integer getWidth() {
    return this.width;
  }

  /**
   * This method returns the height of the profile picture, in pixels.
   *
   * @return The height of the profile picture.
   */
  public Integer getHeight() {
    return this.height;
  }

  /**
   * This method returns a flag indicating whether or not this is the default profile picture for
   * the user.
   *
   * @return A flag indicating whether or not this is the default profile picture for the user.
   */
  public Boolean isDefault() {
    return this.isDefault;
  }
}
