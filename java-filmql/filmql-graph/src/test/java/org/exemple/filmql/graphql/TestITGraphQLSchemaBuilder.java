package org.exemple.filmql.graphql;

import graphql.ExecutionResult;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

/**
 * Test d'intégration associé à {@link GraphQLSchemaBuilder}.
 */
public class TestITGraphQLSchemaBuilder {

  @Test
  public void name() {
    // Given
    String query =
        "query {\n" +
          "films{\n" +
            "originalTitle\n" +
          "}\n" +
        "}";
    // When
    ExecutionResult result = GraphQLSchemaBuilder.getInstance().run(new GraphQuery("", query, ""));
    // Then
    SoftAssertions.assertSoftly(soft -> {
      soft.assertThat(result.getErrors()).isEmpty();
      soft.assertThat(result.getData().toString()).isEqualTo(
          "{" +
            "films=" +
            "[{originalTitle=Fight Club}, {originalTitle=Babylon }]" +
          "}"
      );
    });

  }
}