package org.exemple.filmql.graphql.datafetcher;

import graphql.schema.DataFetcher;
import org.exemple.filmql.businessobject.Actor;
import org.exemple.filmql.businessobject.Role;

import java.util.List;

/**
 * Repository of all data fetchers responsible
 * for returning one or multiple {@link Role}.
 */
public class RoleDataFetcher {

  private RoleDataFetcher() {
    throw new IllegalAccessError("cannot be instantiate");
  }

  /**
   * data fetcher to get all {@link Role} of an {@link Actor}.
   */
  public static DataFetcher<List<Role>> getRolesByActorDataFetcher() {
    return env -> {
      Actor actor = env.getSource();
      return actor.getRoles();
    };
  }
}
