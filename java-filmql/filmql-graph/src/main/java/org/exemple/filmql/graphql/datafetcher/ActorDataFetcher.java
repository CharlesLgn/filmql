package org.exemple.filmql.graphql.datafetcher;

import graphql.schema.DataFetcher;
import org.exemple.filmql.businessobject.Actor;
import org.exemple.filmql.businessobject.Director;
import org.exemple.filmql.businessobject.Film;
import org.exemple.filmql.falsedata.DataGame;

import java.util.List;

/**
 * Repository of all data fetchers responsible
 * for returning one or multiple {@link Actor}.
 */
public class ActorDataFetcher {

  private ActorDataFetcher() {
    throw new IllegalAccessError("cannot be instantiate");
  }

  /**
   * Data fetcher to get all {@link Actor} in the data base in a {@link Film}.
   */
  public static DataFetcher<List<Actor>> getActorsByFilmDataFetcher() {
    return env -> {
      Film film = env.getSource();
      return film.getActors();
    };
  }

  /**
   * data fetcher to get the {@link Actor} in the data base matching the id.
   */
  public static DataFetcher<Actor> getActorsByIdDataFetcher() {
    return env -> {
      String id = env.getArgument("id");
      return DataGame.getPeople().stream()
                     .filter(Actor.class::isInstance)
                     .map(Actor.class::cast)
                     .filter(actor -> actor.getId().equals(id))
                     .findFirst()
                     .orElse(null);
    };
  }
}
