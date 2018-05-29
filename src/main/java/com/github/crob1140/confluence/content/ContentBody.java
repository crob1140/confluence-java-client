package com.github.crob1140.confluence.content;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents the body of a content object in the Confluence Cloud server.
 */
public class ContentBody {

  @JsonProperty
  private ContentBodyFormat anonymous_export_view;
  @JsonProperty
  private ContentBodyFormat editor2;
  @JsonProperty
  private ContentBodyFormat export_view;
  @JsonProperty
  private ContentBodyFormat storage;
  @JsonProperty
  private ContentBodyFormat styled_view;
  @JsonProperty
  private ContentBodyFormat view;

  /**
   * This constructor creates the content body using the value defined for a given type.
   *
   * @param type The body type that is being defined.
   * @param value The value for the given body type.
   */
  public ContentBody(ContentBodyType type, String value) {
    switch (type) {
      case ANONYMOUS_EXPORT_VIEW:
        this.anonymous_export_view = new ContentBodyFormat(value);
        break;
      case EDITOR2:
        this.editor2 = new ContentBodyFormat(value);
        break;
      case EXPORT_VIEW:
        this.export_view = new ContentBodyFormat(value);
        break;
      case STORAGE:
        this.storage = new ContentBodyFormat(value);
        break;
      case STYLED_VIEW:
        this.styled_view = new ContentBodyFormat(value);
        break;
      case VIEW:
        this.view = new ContentBodyFormat(value);
        break;
    }
  }
}
