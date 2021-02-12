package org.exemple.filmql.graphql.typewiring;

import graphql.schema.idl.TypeRuntimeWiring;
import org.exemple.filmql.graphql.datafetcher.FilmDataFetcher;

import java.util.function.Supplier;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

/**
 * Specification of the data fetchers for all mutations.
 */
public class MutationTypeWiring implements Supplier<TypeRuntimeWiring> {

  @Override
  public TypeRuntimeWiring get() {
    return newTypeWiring("Mutation")
        .dataFetcher("createFilm", FilmDataFetcher.createFilmDataFetcher())
        .build();
  }
}
