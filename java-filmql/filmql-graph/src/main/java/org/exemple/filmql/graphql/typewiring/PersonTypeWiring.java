package org.exemple.filmql.graphql.typewiring;

import graphql.TypeResolutionEnvironment;
import graphql.schema.GraphQLObjectType;
import graphql.schema.TypeResolver;
import graphql.schema.idl.TypeRuntimeWiring;
import org.exemple.filmql.businessobject.Actor;
import org.exemple.filmql.businessobject.Director;
import org.exemple.filmql.businessobject.Person;

import java.util.function.Supplier;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

/**
 * Specification of the data fetchers and possible type resolver for {@link Person} type.
 */
public class PersonTypeWiring implements Supplier<TypeRuntimeWiring> {

  @Override
  public TypeRuntimeWiring get() {
    return newTypeWiring("Person").typeResolver(new PersonTypeResolver())
                                  .build();
  }

  /**
   * Specification of possible type resolver for {@link Person} type.
   * It is used to know if a {@link Person} is an {@link Actor} or a {@link Director}.
   */
  private static class PersonTypeResolver implements TypeResolver {
    @Override
    public GraphQLObjectType getType(TypeResolutionEnvironment env) {
      Person person = env.getObject();
      return env.getSchema().getObjectType(person.getTypeName());
    }
  }
}
