package org.exemple.filmql.businessobject;

import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * A actor representation.
 */
@Getter
public class Actor extends Person {

  private final List<Role> roles = new ArrayList<>();

  public Actor(String id, String firstName, String lastName, LocalDate birthDate, LocalDate deathDate) {
    super(id, firstName, lastName, birthDate, deathDate);
  }

  /**
   * add a {@link Role} to the {@link Actor} film's list
   * When you add a film to the list, you directly set the
   * director to the {@link Film}.
   */
  public Actor addRole(Film film, String characterName) {
    roles.add(new Role(characterName, film));
    film.withActor(this);
    return this;
  }


  @Override
  public String getTypeName() {
    return "Actor";
  }
}
