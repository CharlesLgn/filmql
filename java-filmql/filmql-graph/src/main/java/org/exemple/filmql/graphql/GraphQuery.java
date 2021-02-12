package org.exemple.filmql.graphql;

import java.io.Serializable;

/** GraphQL query representation. */
public class GraphQuery implements Serializable {

  private final String operationName;
  private final String query;
  private final String variables;

  public GraphQuery(String operationName, String query, String variables) {
    this.operationName = operationName;
    this.query = query;
    this.variables = variables;
  }

  public GraphQuery() {
    this("", "", "");
  }

  public String getOperationName() {
    return operationName;
  }

  public String getQuery() {
    return query;
  }

  public String getVariables() {
    return variables;
  }
}
