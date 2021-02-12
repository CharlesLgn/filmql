package org.exemple.filmql.graphql.datafetcher;

import graphql.schema.DataFetcher;
import org.exemple.filmql.businessobject.Person;
import org.exemple.filmql.falsedata.DataGame;

import java.util.List;

/**
 * Repository of all data fetchers responsible
 * for returning one or multiple {@link Person}.
 */
public class PersonDataFetcher {

  private PersonDataFetcher() {
    throw new IllegalAccessError("cannot be instantiate");
  }

  /**
   * data fetcher to get all {@link Person} in the data base.
   */
  public static DataFetcher<List<Person>> getPeopleDataFetcher() {
    return env -> DataGame.getPeople();
  }
}
