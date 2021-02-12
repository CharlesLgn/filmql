package org.exemple.filmql.graphql.typewiring;

import graphql.schema.idl.TypeRuntimeWiring;

import java.util.function.Supplier;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;
import static org.exemple.filmql.graphql.datafetcher.ActorDataFetcher.getActorsByIdDataFetcher;
import static org.exemple.filmql.graphql.datafetcher.DirectorDataFetcher.getDirectorByIdDataFetcher;
import static org.exemple.filmql.graphql.datafetcher.FilmDataFetcher.getFilmByIdDataFetcher;
import static org.exemple.filmql.graphql.datafetcher.FilmDataFetcher.getFilmsDataFetcher;
import static org.exemple.filmql.graphql.datafetcher.PersonDataFetcher.getPeopleDataFetcher;

/**
 * Specification of the data fetchers for all queries.
 */
public class QueryTypeWiring implements Supplier<TypeRuntimeWiring> {

  @Override
  public TypeRuntimeWiring get() {
    return newTypeWiring("Query")
        .dataFetcher("films", getFilmsDataFetcher())
        .dataFetcher("film", getFilmByIdDataFetcher())
        .dataFetcher("director", getDirectorByIdDataFetcher())
        .dataFetcher("actor", getActorsByIdDataFetcher())
        .dataFetcher("people", getPeopleDataFetcher())
        .build();
  }
}
