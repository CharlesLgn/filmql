package org.exemple.filmql.businessobject;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

/**
 * A person representation
 * @see Actor
 * @see Director
 */
@Getter
@AllArgsConstructor
public abstract class Person {

  private final String id;
  private final String firstName;
  private final String lastName;
  private final LocalDate birthDate;
  private final LocalDate deathDate;

  /**
   * @return the type name for the GraphQL resolver.
   */
  public abstract String getTypeName();
}
