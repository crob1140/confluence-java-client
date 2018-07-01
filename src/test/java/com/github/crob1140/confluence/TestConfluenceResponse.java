package com.github.crob1140.confluence;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This class represents a simple response object that be used for testing purposes.
 */
public class TestConfluenceResponse {

  @JsonProperty
  private String name;
  @JsonProperty
  private String value;

  // Required for Jackson deserialization
  @SuppressWarnings("unused")
  private TestConfluenceResponse() {
  }

  /**
   * This constructor creates a new test response with the given name and value.
   *
   * @param name The value to set for the "name" field.
   * @param value The value to set for the "value" field.
   */
  TestConfluenceResponse(String name, String value) {
    this.name = name;
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TestConfluenceResponse that = (TestConfluenceResponse) o;
    return Objects.equals(name, that.name) &&
        Objects.equals(value, that.value);
  }
}
