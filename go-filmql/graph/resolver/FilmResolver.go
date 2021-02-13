package resolver

import (
  "../../data"
  "github.com/graphql-go/graphql"
  "log"
)

func GetFilmById(p graphql.ResolveParams) (interface{}, error) {
  log.Println("get film by id", p.Args["id"])
  for _, film := range data.GetFilm() {
    if film.Id == p.Args["id"] {
      return film, nil
    }
  }
  return nil, nil
}

func GetFilms(p graphql.ResolveParams) (interface{}, error) {
  log.Println("get all film")
  return data.GetFilm(), nil
}