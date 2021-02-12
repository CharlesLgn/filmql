package org.exemple.filmql.businessobject;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * A role representation.
 */
@Getter
@AllArgsConstructor
public class Role {

  private final String characterName;
  private final Film film;
}
