package resolver

import (
  "../../data"
  "github.com/graphql-go/graphql"
)

func GetFilmById(p graphql.ResolveParams) (interface{}, error) {
  for _, film := range data.GetFilm() {
    if film.Id == p.Args["id"] {
      return film, nil
    }
  }
  return nil, nil
}

func GetFilms(p graphql.ResolveParams) (interface{}, error) {
  return data.GetFilm(), nil
}