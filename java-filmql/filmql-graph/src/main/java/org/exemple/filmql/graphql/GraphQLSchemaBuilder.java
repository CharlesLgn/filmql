package org.exemple.filmql.graphql;

import com.google.common.io.Resources;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.exemple.filmql.graphql.typewiring.*;

import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Builder of the GraphQlSchema.
 * It's used as a singleton du to performance issue.
 */
public class GraphQLSchemaBuilder {

  public static GraphQLSchemaBuilder getInstance() {
    return GraphQLSchemaHolder.INSTANCE.get();
  }

  private GraphQL graphQL;

  @SuppressWarnings("UnstableApiUsage")
  private GraphQLSchemaBuilder() {
    try {
      URL url = Resources.getResource("schema.graphql");
      String sdl = Resources.toString(url, StandardCharsets.UTF_8);
      GraphQLSchema graphQLSchema = buildSchema(sdl);
      this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private GraphQLSchema buildSchema(String sdl) {
    TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
    RuntimeWiring runtimeWiring = buildWiring();
    SchemaGenerator schemaGenerator = new SchemaGenerator();
    return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
  }

  private RuntimeWiring buildWiring() {
    return RuntimeWiring.newRuntimeWiring()
                        .scalar(ExtendedScalars.Date)
                        .type(new QueryTypeWiring().get())
                        .type(new MutationTypeWiring().get())
                        .type(new ActorTypeWiring().get())
                        .type(new DirectorTypeWiring().get())
                        .type(new FilmTypeWiring().get())
                        .type(new RoleTypeWiring().get())
                        .type(new PersonTypeWiring().get())
                        .build();
  }

  /** Run the GraphQL query and return the result as {@link ExecutionResult}. */
  public ExecutionResult run(GraphQuery query) {
    return graphQL.execute(query.getQuery());
  }

  /** Singleton holder */
  private enum GraphQLSchemaHolder {
    INSTANCE(new GraphQLSchemaBuilder());

    private final GraphQLSchemaBuilder instance;

    GraphQLSchemaHolder(GraphQLSchemaBuilder instance) {
      this.instance = instance;
    }

    private GraphQLSchemaBuilder get() {
      return instance;
    }
  }
}
