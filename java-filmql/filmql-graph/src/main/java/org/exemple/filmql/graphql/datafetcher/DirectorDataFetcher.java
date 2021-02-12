package org.exemple.filmql.graphql.datafetcher;

import graphql.schema.DataFetcher;
import org.exemple.filmql.businessobject.Director;
import org.exemple.filmql.businessobject.Film;
import org.exemple.filmql.falsedata.DataGame;

/**
 * Repository of all data fetchers responsible
 * for returning one or multiple {@link Director}.
 */
public class DirectorDataFetcher {

  private DirectorDataFetcher() {
    throw new IllegalAccessError("cannot be instantiate");
  }

  /**
   * data fetcher to get the {@link Director} from a {@link Film}.
   */
  public static DataFetcher<Director> getDirectorByFilmDataFetcher() {
    return env -> {
      Film film = env.getSource();
      return film.getDirector();
    };
  }

  /**
   * data fetcher to get the {@link Director} in the data base matching the id..
   */
  public static DataFetcher<Director> getDirectorByIdDataFetcher() {
    return env -> {
      String id = env.getArgument("id");
      return DataGame.getPeople().stream()
                     .filter(Director.class::isInstance)
                     .map(Director.class::cast)
                     .filter(actor -> actor.getId().equals(id))
                     .findFirst()
                     .orElse(null);
    };
  }
}
