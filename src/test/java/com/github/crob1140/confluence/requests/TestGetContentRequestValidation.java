package com.github.crob1140.confluence.requests;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestGetContentRequestValidation {

  @Rule
  public final ExpectedException exception = ExpectedException.none();

  private String description;
  private GetContentRequest.Builder requestBuilder;
  private Class<Exception> expectedExceptionClass;
  private String expectedExceptionMessage;

  public TestGetContentRequestValidation(String description,
      GetContentRequest.Builder requestBuilder, Class<Exception> expectedExceptionClass,
      String expectedExceptionMessage) {
    this.description = description;
    this.requestBuilder = requestBuilder;
    this.expectedExceptionClass = expectedExceptionClass;
    this.expectedExceptionMessage = expectedExceptionMessage;
  }

  @Parameters(name = "{0}")
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{{
        "Requests cannot be created with negative limits",
        new GetContentRequest.Builder().setLimit(-1),
        IllegalStateException.class,
        "The limit must be a positive number"
    }, {
        "Requests cannot be created with a limit of zero",
        new GetContentRequest.Builder().setLimit(0),
        IllegalStateException.class,
        "The limit must be a positive number"
    }, {
        "Requests cannot be created with negative start positions",
        new GetContentRequest.Builder().setStartPosition(-1),
        IllegalStateException.class,
        "The start position must be a positive number"
    }, {
        "Requests cannot be created with a start position of zero",
        new GetContentRequest.Builder().setStartPosition(0),
        IllegalStateException.class,
        "The start position must be a positive number"
    }});
  }

  @Test
  public void testExpectedExceptionThrown() {
    exception.expect(this.expectedExceptionClass);
    exception.expectMessage(this.expectedExceptionMessage);
    this.requestBuilder.build();
  }
}
