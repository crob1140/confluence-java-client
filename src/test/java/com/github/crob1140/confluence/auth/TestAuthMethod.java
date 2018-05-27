package com.github.crob1140.confluence.auth;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * This class performs tests against the implementations of {@link AuthMethod}.
 */
@RunWith(Parameterized.class)
public class TestAuthMethod {

  private AuthMethod method;
  private String expectedAuthHeader;

  public TestAuthMethod(AuthMethod method, String expectedAuthHeader) {
    this.method = method;
    this.expectedAuthHeader = expectedAuthHeader;
  }

  @Parameters(name = "{index}: {1}")
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {new BasicAuth("username", "password"), "Basic dXNlcm5hbWU6cGFzc3dvcmQ="},
        {new TokenAuth("testtoken"), "Bearer testtoken"},
    });
  }

  /**
   * This test asserts that the Authorization header value that is generated using the {@link
   * AuthMethod} under test matches the expected value.
   */
  @Test
  public void test() {
    Assert.assertEquals(expectedAuthHeader, this.method.getAuthHeaderValue());
  }
}
