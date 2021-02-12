package org.exemple.filmql.businessobject;

import lombok.*;
import org.exemple.filmql.type.FilmStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * A film representation.
 */
@Getter
@RequiredArgsConstructor
public class Film {

  @NonNull private final String id;
  @NonNull private final String frenchTitle;
  @NonNull private final String originalTitle;
  @NonNull private final LocalDate releaseDate;
  @NonNull private final FilmStatus status;
  private final List<Actor> actors = new ArrayList<>();
  @Setter(value = AccessLevel.PACKAGE)
  private Director director;

  /** add an {@link Actor} to the film. */
  public Film withActor(@NonNull Actor actor) {
    actors.add(actor);
    return this;
  }
}
