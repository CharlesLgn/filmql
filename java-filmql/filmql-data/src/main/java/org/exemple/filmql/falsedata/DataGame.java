package org.exemple.filmql.falsedata;

import org.exemple.filmql.businessobject.Actor;
import org.exemple.filmql.businessobject.Director;
import org.exemple.filmql.businessobject.Film;
import org.exemple.filmql.businessobject.Person;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.exemple.filmql.type.FilmStatus.IN_PROGRESS;
import static org.exemple.filmql.type.FilmStatus.RELEASED;

/**
 * to have a data game.
 * it's because it is an exemple that doeesn't need any database.
 * In a real project, please, don't do this
 */
public class DataGame {

  private static final List<Film> FILMS = new ArrayList<>();
  private static final List<Person> PEOPLE = new ArrayList<>();

  static {
    Film fightClub = new Film("1", "Fight Club", "Fight Club", LocalDate.of(1999, Month.SEPTEMBER, 10), RELEASED);
    Film babylon = new Film("2", "Babylon ", "Babylon ", LocalDate.of(2022, Month.DECEMBER, 25), IN_PROGRESS);
    Actor edwardNorton = new Actor("1", "Edward", "Norton", LocalDate.of(1969, Month.AUGUST, 18), null);
    Actor bradPitt = new Actor("2", "Brad", "Pitt", LocalDate.of(1963, Month.DECEMBER, 18), null);
    Director damienChazelle = new Director("3", "Damien", "Chazelle", LocalDate.of(1985, Month.JANUARY, 19), null);
    Director davidFincher = new Director("4","David", "Fincher", LocalDate.of(1962, Month.AUGUST, 28), null);
    FILMS.addAll(asList(fightClub, babylon));
    PEOPLE.addAll(asList(edwardNorton, bradPitt, damienChazelle, davidFincher));
    edwardNorton.addRole(fightClub, "Narator");
    bradPitt.addRole(fightClub, "Tyle Durden");
    bradPitt.addRole(babylon, "Unknown");
    damienChazelle.addFilm(babylon);
    davidFincher.addFilm(fightClub);
  }

  public static List<Film> getFilms() {
    return FILMS;
  }

  public static List<Person> getPeople() {
    return PEOPLE;
  }
}
