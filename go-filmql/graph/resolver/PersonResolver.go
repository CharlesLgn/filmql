package resolver

import (
  "../../data"
  . "../../structure"
  "log"

  "github.com/graphql-go/graphql"
)

func GetActorById(p graphql.ResolveParams) (interface{}, error) {
  log.Println("get actor by id", p.Args["id"])
  for _, person := range data.GetPeople() {
    actor, ok := person.(Actor)
    if ok && actor.Id == p.Args["id"] {
      return actor, nil
    }
  }
  return nil, nil
}

func GetDirectorById(p graphql.ResolveParams) (interface{}, error) {
  log.Println("get director by id", p.Args["id"])
  for _, person := range data.GetPeople() {
    director, ok := person.(Director)
    if ok && director.Id == p.Args["id"] {
      return director, nil
    }
  }
  return nil, nil
}

func GetPeople(p graphql.ResolveParams) (interface{}, error) {
  log.Println("get all people")
  return data.GetPeople(), nil
}