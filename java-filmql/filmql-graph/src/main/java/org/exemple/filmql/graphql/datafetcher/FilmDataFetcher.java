package org.exemple.filmql.graphql.datafetcher;

import graphql.schema.DataFetcher;
import org.exemple.filmql.businessobject.Director;
import org.exemple.filmql.businessobject.Film;
import org.exemple.filmql.businessobject.Role;
import org.exemple.filmql.falsedata.DataGame;
import org.exemple.filmql.input.FilmInput;
import org.exemple.filmql.type.FilmStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * Repository of all data fetchers responsible
 * for returning one or multiple {@link Film}.
 */
public class FilmDataFetcher {

  private FilmDataFetcher() {
    throw new IllegalAccessError("cannot be instantiate");
  }

  /**
   * data fetcher to get a {@link Film in the data base matching the id.
   */
  public static DataFetcher<Film> getFilmByIdDataFetcher() {
    return env -> {
      String id = env.getArgument("id");
      return DataGame.getFilms().stream()
                     .filter(film -> film.getId().equals(id))
                     .findFirst()
                     .orElse(null);
    };
  }

  /**
   * data fetcher to get all {@link Film} in the data base.
   */
  public static DataFetcher<List<Film>> getFilmsDataFetcher() {
    return env -> DataGame.getFilms();
  }

  /**
   * data fetcher to get all {@link Film} from a {@link Director}.
   */
  public static DataFetcher<List<Film>> getFilmByDirectorDataFetcher() {
    return env -> {
      Director director = env.getSource();
      return director.getFilms();
    };
  }

  /**
   * data fetcher to get a {@link Film} from a {@link Role}.
   */
  public static DataFetcher<Film> getFilmByRoleDataFetcher() {
    return env -> {
      Role role = env.getSource();
      return role.getFilm();
    };
  }

  /**
   * data fetcher to create a {@link Film} and return it.
   */
  public static DataFetcher<Film> createFilmDataFetcher() {
    return env -> {
      Map<String, String> map = env.getArgument("film");
      FilmInput input = new FilmInput(map.get("originalTitle"), FilmStatus.valueOf(map.get("status")),
          map.get("title"));
      Film film = new Film("3", input.getTitle(), input.getOriginalTitle(), LocalDate.now(), input.getStatus());
      DataGame.getFilms().add(film);
      return film;
    };
  }
}
