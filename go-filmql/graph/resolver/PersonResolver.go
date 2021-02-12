package resolver

import (
  "../../data"
  . "../../structure"

  "github.com/graphql-go/graphql"
)

func GetActorById(p graphql.ResolveParams) (interface{}, error) {
  for _, person := range data.GetPeople() {
    actor, ok := person.(Actor)
    if ok && actor.Id == p.Args["id"] {
      return actor, nil
    }
  }
  return nil, nil
}

func GetDirectorById(p graphql.ResolveParams) (interface{}, error) {
  for _, person := range data.GetPeople() {
    director, ok := person.(Director)
    if ok && director.Id == p.Args["id"] {
      return director, nil
    }
  }
  return nil, nil
}

func GetPeople(p graphql.ResolveParams) (interface{}, error) {
  return data.GetPeople(), nil
}