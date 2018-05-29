package com.github.crob1140.confluence.users;

/**
 * This class represents a user in the Confluence Cloud server.
 */
public class User {

  private String username;
  private String userKey;
  private String accountId;
  private UserType type;
  private ProfilePicture profilePicture;
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
