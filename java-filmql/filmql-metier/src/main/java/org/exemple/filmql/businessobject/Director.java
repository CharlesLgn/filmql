package org.exemple.filmql.businessobject;

import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * A film director representation.
 */
@Getter
public class Director extends Person {

  List<Film> films = new ArrayList<>();

  public Director(String id, String firstName, String lastName, LocalDate birthDate, LocalDate deathDate) {
    super(id, firstName, lastName, birthDate, deathDate);
  }

  /**
   * add a {@link Film} to the {@link Director} film's list
   * When you add a film to the list, you directly set the
   * director to the {@link Film}.
   */
  public Director addFilm(@NonNull Film film) {
    films.add(film);
    film.setDirector(this);
    return this;
  }

  @Override
  public String getTypeName() {
    return "Director";
  }
}
