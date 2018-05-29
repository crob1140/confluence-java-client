# Confluence Java Client
[![Build Status](https://travis-ci.org/crob1140/confluence-java-client.svg?branch=master)](https://travis-ci.org/crob1140/confluence-java-client)
[![Test Coverage](https://codecov.io/gh/crob1140/confluence-java-client/branch/master/graph/badge.svg)](https://codecov.io/gh/crob1140/confluence-java-client)

A simple Java client for the Confluence Cloud REST API

## Usage

Create a new client instance:
```java
WebTarget wikiTarget = ClientBuilder.newClient().target("http://www.sample.atlassian.net/wiki");
AuthMethod basicAuth = new BasicAuth("username", "password");
Confluence client = new ConfluenceClient(wikiTarget, basicAuth);
```

Create some content:
```java
Content content = client.createContent(new CreateContentRequest.Builder()
    .setType(StandardContentType.PAGE)
    .setSpaceKey("SAMPLE")
    .setBody(ContentBodyType.STORAGE, "<html>SAMPLE</html>")
    .build());
```
## Contribution
This client is a work-in-progress, and API methods will be added iteratively.
If there is a particular feature you would like added, feel free to raise it as an issue, or fork the repository and create a pull request with your own changes.
## License
MIT