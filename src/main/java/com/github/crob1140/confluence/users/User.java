package com.github.crob1140.confluence.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents a user in the Confluence Cloud server.
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

  @JsonProperty
  private String username;
  @JsonProperty
  private String userKey;
  @JsonProperty
  private String accountId;
  @JsonProperty
  private UserType type;
  @JsonProperty
  private ProfilePicture profilePicture;
  @JsonProperty
  private String displayName;

  /**
   * This method returns the username of the user.
   *
   * @return The username of the user.
   */
  public String getUsername() {
    return username;
  }

  /**
   * This method returns the key of the user.
   *
   * @return The key of the user.
   */
  public String getUserKey() {
    return userKey;
  }

  /**
   * This method returns the account ID of the user.
   *
   * @return The account ID of the user.
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * This method returns the type of the user.
   *
   * @return The type of the user.
   */
  public UserType getType() {
    return type;
  }

  /**
   * This method returns the profile picture of the user.
   *
   * @return The profile picture of the user.
   */
  public ProfilePicture getProfilePicture() {
    return profilePicture;
  }

  /**
   * This method returns the display name of the user.
   *
   * @return The display name of the user.
   */
  public String getDisplayName() {
    return displayName;
  }
}
