package org.exemple.filmql.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.exemple.filmql.type.FilmStatus;

@Getter
@Setter
@AllArgsConstructor
public class FilmInput {

  private String originalTitle;
  private FilmStatus status;
  private String title;
}
