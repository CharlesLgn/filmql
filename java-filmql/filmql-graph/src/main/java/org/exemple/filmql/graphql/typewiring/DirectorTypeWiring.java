package org.exemple.filmql.graphql.typewiring;

import graphql.schema.idl.TypeRuntimeWiring;
import org.exemple.filmql.businessobject.Director;
import org.exemple.filmql.graphql.datafetcher.FilmDataFetcher;

import java.util.function.Supplier;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

/**
 * Specification of the data fetchers and possible type resolver for {@link Director} type.
 */
public class DirectorTypeWiring implements Supplier<TypeRuntimeWiring> {

  @Override
  public TypeRuntimeWiring get() {
    return newTypeWiring("Director")
        .dataFetcher("films", FilmDataFetcher.getFilmByDirectorDataFetcher())
        .build();
  }
}
