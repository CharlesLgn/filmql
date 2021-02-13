package org.exemple.filmql.service;

import org.exemple.filmql.graphql.GraphQLSchemaBuilder;
import org.exemple.filmql.graphql.GraphQuery;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * the single endpoint of the GraphQLApp
 */
@Path("/graphql")
public class GraphQLServlet extends HttpServlet {

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response runQuery(GraphQuery query) {
    return Response.ok().entity(GraphQLSchemaBuilder.getInstance().run(query)).build();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getQuery(@QueryParam("operationName") String operationName, @QueryParam("query") String query, @QueryParam("variables") String variables) {
    return runQuery(new GraphQuery(operationName, query, variables));
  }
}
