package graph

import (
	"./resolver"

	"github.com/graphql-go/graphql"
	"log"
)

var Schema = initGraph()

func initGraph() graphql.Schema {
	initLoopDependency()
	field := graphql.Fields{
		"films": &graphql.Field{
			Type:    graphql.NewList(filmType),
			Resolve: resolver.GetFilms,
		},
		"film": &graphql.Field{
			Type:    filmType,
			Resolve: resolver.GetFilmById,
			Args: graphql.FieldConfigArgument{
				"id": &graphql.ArgumentConfig{
					Type: graphql.Int,
				},
			},
		},
		"actor": &graphql.Field{
			Type:    actorType,
			Resolve: resolver.GetActorById,
			Args: graphql.FieldConfigArgument{
				"id": &graphql.ArgumentConfig{
					Type: graphql.Int,
				},
			},
		},
		"director": &graphql.Field{
			Type:    directorType,
			Resolve: resolver.GetDirectorById,
			Args: graphql.FieldConfigArgument{
				"id": &graphql.ArgumentConfig{
					Type: graphql.Int,
				},
			},
		},
		"people": &graphql.Field{
			Type:    graphql.NewList(personType),
			Resolve: resolver.GetPeople,
		},
	}
	rootQuery := graphql.ObjectConfig{Name: "RootQuery", Fields: field}
	schemaConfig := graphql.SchemaConfig{Query: graphql.NewObject(rootQuery)}
	graph, err := graphql.NewSchema(schemaConfig)
	if err != nil {
		log.Fatalf("failed to create new schema, error: %v", err)
	}
	return graph
}

func initLoopDependency() {
	filmType.AddFieldConfig("director", &graphql.Field{
		Type: directorType,
	})
	directorType.AddFieldConfig("films", &graphql.Field{
		Type: graphql.NewList(filmType),
	})
	roleType.AddFieldConfig("film", &graphql.Field{
		Type: graphql.NewList(filmType),
	})
	actorType.AddFieldConfig("roles", &graphql.Field{
		Type: graphql.NewList(roleType),
	})
}
