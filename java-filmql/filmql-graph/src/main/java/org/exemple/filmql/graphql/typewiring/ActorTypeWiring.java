package org.exemple.filmql.graphql.typewiring;

import graphql.schema.idl.TypeRuntimeWiring;
import org.exemple.filmql.businessobject.Actor;
import org.exemple.filmql.graphql.datafetcher.RoleDataFetcher;

import java.util.function.Supplier;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

/**
 * Specification of the data fetchers and possible type resolver for {@link Actor} type.
 */
public class ActorTypeWiring implements Supplier<TypeRuntimeWiring> {

  @Override
  public TypeRuntimeWiring get() {
    return newTypeWiring("Actor")
        .dataFetcher("roles", RoleDataFetcher.getRolesByActorDataFetcher())
        .build();
  }
}
