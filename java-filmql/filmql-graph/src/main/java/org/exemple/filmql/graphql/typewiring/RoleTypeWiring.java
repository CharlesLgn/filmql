package org.exemple.filmql.graphql.typewiring;

import graphql.schema.idl.TypeRuntimeWiring;
import org.exemple.filmql.businessobject.Role;
import org.exemple.filmql.graphql.datafetcher.FilmDataFetcher;

import java.util.function.Supplier;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

/**
 * Specification of the data fetchers and possible type resolver for {@link Role} type.
 */
public class RoleTypeWiring implements Supplier<TypeRuntimeWiring> {

  @Override
  public TypeRuntimeWiring get() {
    return newTypeWiring("Role")
        .dataFetcher("film", FilmDataFetcher.getFilmByRoleDataFetcher())
        .build();
  }
}
