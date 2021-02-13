package graph

import (
  "github.com/graphql-go/graphql"
  "log"
)

func Run(RequestString string) *graphql.Result {
  params := graphql.Params{Schema: Schema, RequestString: RequestString}
  r := graphql.Do(params)
  if len(r.Errors) > 0 {
    log.Fatalf("failed to execute graphql operation, errors: %+v", r.Errors)
  }
  return r
}
