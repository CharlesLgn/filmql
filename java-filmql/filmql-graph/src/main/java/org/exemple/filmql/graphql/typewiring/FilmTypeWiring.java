package org.exemple.filmql.graphql.typewiring;

import graphql.schema.idl.TypeRuntimeWiring;
import org.exemple.filmql.businessobject.Film;
import org.exemple.filmql.graphql.datafetcher.DirectorDataFetcher;

import java.util.function.Supplier;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;
import static org.exemple.filmql.graphql.datafetcher.ActorDataFetcher.getActorsByFilmDataFetcher;

/**
 * Specification of the data fetchers and possible type resolver for {@link Film} type.
 */
public class FilmTypeWiring implements Supplier<TypeRuntimeWiring> {

  @Override
  public TypeRuntimeWiring get() {
    return newTypeWiring("Film")
        .dataFetcher("actors", getActorsByFilmDataFetcher())
        .dataFetcher("director", DirectorDataFetcher.getDirectorByFilmDataFetcher())
        .build();
  }
}
