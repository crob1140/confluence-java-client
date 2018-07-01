package com.github.crob1140.confluence.content.expand;

import com.github.crob1140.confluence.content.ContentBodyType;
import java.util.HashSet;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;

public class TestExpandedContentProperties {

  @Test
  public void testContentProperties() {
    Set<String> expectedExpandProperties = new HashSet<>();
    ExpandedContentProperties.Builder expandedContentPropsBuilder = new ExpandedContentProperties.Builder();

    expandedContentPropsBuilder.addAncestors();
    expectedExpandProperties.add("ancestors");

    expandedContentPropsBuilder.addContainer();
    expectedExpandProperties.add("container");

    expandedContentPropsBuilder.addOperations();
    expectedExpandProperties.add("operations");

    expandedContentPropsBuilder.addSpace();
    expectedExpandProperties.add("space");

    expandedContentPropsBuilder.addVersion();
    expectedExpandProperties.add("version");

    Set<String> actualExpandProperties = expandedContentPropsBuilder.build().getProperties();
    Assert.assertEquals(expectedExpandProperties, actualExpandProperties);
  }

  @Test
  public void testBodyProperties() {
    Set<String> expectedExpandProperties = new HashSet<>();
    ExpandedContentProperties.Builder expandedContentPropsBuilder = new ExpandedContentProperties.Builder();

    ExpandedBodyFormatProperties expandedBodyFormatProps = new ExpandedBodyFormatProperties.Builder()
        .addValue()
        .addRepresentation()
        .addMediaToken()
        .addEmbeddedContent()
        .addWebResource()
        .build();

    expandedContentPropsBuilder.addBody(ContentBodyType.EXPORT_VIEW, expandedBodyFormatProps);
    expectedExpandProperties.add("body.export_view.value");
    expectedExpandProperties.add("body.export_view.representation");
    expectedExpandProperties.add("body.export_view.mediaToken");
    expectedExpandProperties.add("body.export_view.embeddedContent");
    expectedExpandProperties.add("body.export_view.webresource");

    expandedContentPropsBuilder.addBody(ContentBodyType.STORAGE, expandedBodyFormatProps);
    expectedExpandProperties.add("body.storage.value");
    expectedExpandProperties.add("body.storage.representation");
    expectedExpandProperties.add("body.storage.mediaToken");
    expectedExpandProperties.add("body.storage.embeddedContent");
    expectedExpandProperties.add("body.storage.webresource");

    expandedContentPropsBuilder.addBody(ContentBodyType.VIEW, expandedBodyFormatProps);
    expectedExpandProperties.add("body.view.value");
    expectedExpandProperties.add("body.view.representation");
    expectedExpandProperties.add("body.view.mediaToken");
    expectedExpandProperties.add("body.view.embeddedContent");
    expectedExpandProperties.add("body.view.webresource");

    expandedContentPropsBuilder.addBody(ContentBodyType.EXPORT_VIEW, expandedBodyFormatProps);
    expectedExpandProperties.add("body.export_view.value");
    expectedExpandProperties.add("body.export_view.representation");
    expectedExpandProperties.add("body.export_view.mediaToken");
    expectedExpandProperties.add("body.export_view.embeddedContent");
    expectedExpandProperties.add("body.export_view.webresource");

    expandedContentPropsBuilder.addBody(ContentBodyType.STYLED_VIEW, expandedBodyFormatProps);
    expectedExpandProperties.add("body.styled_view.value");
    expectedExpandProperties.add("body.styled_view.representation");
    expectedExpandProperties.add("body.styled_view.mediaToken");
    expectedExpandProperties.add("body.styled_view.embeddedContent");
    expectedExpandProperties.add("body.styled_view.webresource");

    expandedContentPropsBuilder
        .addBody(ContentBodyType.ANONYMOUS_EXPORT_VIEW, expandedBodyFormatProps);
    expectedExpandProperties.add("body.anonymous_export_view.value");
    expectedExpandProperties.add("body.anonymous_export_view.representation");
    expectedExpandProperties.add("body.anonymous_export_view.mediaToken");
    expectedExpandProperties.add("body.anonymous_export_view.embeddedContent");
    expectedExpandProperties.add("body.anonymous_export_view.webresource");

    expandedContentPropsBuilder.addBody(ContentBodyType.EDITOR2, expandedBodyFormatProps);
    expectedExpandProperties.add("body.editor2.value");
    expectedExpandProperties.add("body.editor2.representation");
    expectedExpandProperties.add("body.editor2.mediaToken");
    expectedExpandProperties.add("body.editor2.embeddedContent");
    expectedExpandProperties.add("body.editor2.webresource");

    Set<String> actualExpandProperties = expandedContentPropsBuilder.build().getProperties();
    Assert.assertEquals(expectedExpandProperties, actualExpandProperties);
  }

  @Test
  public void testChildrenProperties() {
    Set<String> expectedExpandProperties = new HashSet<>();
    ExpandedContentProperties.Builder expandedContentPropsBuilder = new ExpandedContentProperties.Builder();

    expandedContentPropsBuilder.addChildren(new ExpandedChildrenProperties.Builder()
        .addPage()
        .addComment()
        .addAttachment()
        .build());

    expectedExpandProperties.add("children.page");
    expectedExpandProperties.add("children.comment");
    expectedExpandProperties.add("children.attachment");

    Set<String> actualExpandProperties = expandedContentPropsBuilder.build().getProperties();
    Assert.assertEquals(expectedExpandProperties, actualExpandProperties);
  }

  @Test
  public void testChildTypeProperties() {
    Set<String> expectedExpandProperties = new HashSet<>();
    ExpandedContentProperties.Builder expandedContentPropsBuilder = new ExpandedContentProperties.Builder();

    expandedContentPropsBuilder.addChildTypes(new ExpandedChildTypeProperties.Builder()
        .addPage()
        .addComment()
        .addAttachment()
        .addAll()
        .build());

    expectedExpandProperties.add("childTypes.page");
    expectedExpandProperties.add("childTypes.comment");
    expectedExpandProperties.add("childTypes.attachment");
    expectedExpandProperties.add("childTypes.all");

    Set<String> actualExpandProperties = expandedContentPropsBuilder.build().getProperties();
    Assert.assertEquals(expectedExpandProperties, actualExpandProperties);
  }

  @Test
  public void testDescendantProperties() {
    Set<String> expectedExpandProperties = new HashSet<>();
    ExpandedContentProperties.Builder expandedContentPropsBuilder = new ExpandedContentProperties.Builder();

    expandedContentPropsBuilder.addDescendants(new ExpandedDescendantsProperties.Builder()
        .addPage()
        .addComment()
        .addAttachment()
        .build());

    expectedExpandProperties.add("descendants.page");
    expectedExpandProperties.add("descendants.comment");
    expectedExpandProperties.add("descendants.attachment");

    Set<String> actualExpandProperties = expandedContentPropsBuilder.build().getProperties();
    Assert.assertEquals(expectedExpandProperties, actualExpandProperties);
  }

  @Test
  public void testHistoryProperties() {
    Set<String> expectedExpandProperties = new HashSet<>();
    ExpandedContentProperties.Builder expandedContentPropsBuilder = new ExpandedContentProperties.Builder();

    expandedContentPropsBuilder.addHistory(new ExpandedHistoryProperties.Builder()
        .addContributors()
        .addLastUpdated()
        .addNextVersion()
        .addPreviousVersion()
        .build());

    expectedExpandProperties.add("history.contributors");
    expectedExpandProperties.add("history.lastUpdated");
    expectedExpandProperties.add("history.nextVersion");
    expectedExpandProperties.add("history.previousVersion");

    Set<String> actualExpandProperties = expandedContentPropsBuilder.build().getProperties();
    Assert.assertEquals(expectedExpandProperties, actualExpandProperties);
  }

  @Test
  public void testMetadataProperties() {
    Set<String> expectedExpandProperties = new HashSet<>();
    ExpandedContentProperties.Builder expandedContentPropsBuilder = new ExpandedContentProperties.Builder();

    expandedContentPropsBuilder.addMetadata(new ExpandedMetadataProperties.Builder()
        .addCurrentUser()
        .addFrontEnd()
        .addLabels()
        .addProperties()
        .build());

    expectedExpandProperties.add("metadata.currentuser");
    expectedExpandProperties.add("metadata.frontend");
    expectedExpandProperties.add("metadata.labels");
    expectedExpandProperties.add("metadata.properties");

    Set<String> actualExpandProperties = expandedContentPropsBuilder.build().getProperties();
    Assert.assertEquals(expectedExpandProperties, actualExpandProperties);
  }

  @Test
  public void testRestrictionProperties() {
    Set<String> expectedExpandProperties = new HashSet<>();
    ExpandedContentProperties.Builder expandedContentPropsBuilder = new ExpandedContentProperties.Builder();

    expandedContentPropsBuilder.addRestrictions(new ExpandedRestrictionProperties.Builder()
        .addReadUsers()
        .addReadGroups()
        .addUpdateUsers()
        .addUpdateGroups()
        .build());

    expectedExpandProperties.add("restrictions.read.restrictions.user");
    expectedExpandProperties.add("restrictions.read.restrictions.group");
    expectedExpandProperties.add("restrictions.update.restrictions.user");
    expectedExpandProperties.add("restrictions.update.restrictions.group");

    Set<String> actualExpandProperties = expandedContentPropsBuilder.build().getProperties();
    Assert.assertEquals(expectedExpandProperties, actualExpandProperties);
  }
}
