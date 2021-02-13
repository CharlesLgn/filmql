package graph

import (
	"github.com/graphql-go/graphql"

	"../structure"
)

var filmType = graphql.NewObject(
	graphql.ObjectConfig{
		Name: "Film",
		Fields: graphql.Fields{
			"id": &graphql.Field{
				Type: graphql.Int,
			},
			"originalTitle": &graphql.Field{
				Type: graphql.String,
			},
			"title": &graphql.Field{
				Type: graphql.String,
			},
		},
	},
)

var personType = graphql.NewInterface(
	graphql.InterfaceConfig{
		Name: "Person",
		Fields: graphql.Fields{
			"id": &graphql.Field{
				Type: graphql.Int,
			},
			"dateOfBirth": &graphql.Field{
				Type: graphql.DateTime,
			},
			"dateOfDeath": &graphql.Field{
				Type: graphql.DateTime,
			},
			"firstName": &graphql.Field{
				Type: graphql.String,
			},
			"lastName": &graphql.Field{
				Type: graphql.String,
			},
		},
		ResolveType: func(p graphql.ResolveTypeParams) *graphql.Object {
			_, ok := p.Value.(structure.Director)
			if ok {
				return directorType
			}
			return actorType
		},
	},
)

var actorType = graphql.NewObject(
	graphql.ObjectConfig{
		Name: "Actor",
		Fields: graphql.Fields{
			"id": &graphql.Field{
				Type: graphql.Int,
			},
			"dateOfBirth": &graphql.Field{
				Type: graphql.DateTime,
			},
			"dateOfDeath": &graphql.Field{
				Type: graphql.DateTime,
			},
			"firstName": &graphql.Field{
				Type: graphql.String,
			},
			"lastName": &graphql.Field{
				Type: graphql.String,
			},
		},
	},
)

var directorType = graphql.NewObject(
	graphql.ObjectConfig{
		Name: "Director",
		Fields: graphql.Fields{
			"id": &graphql.Field{
				Type: graphql.Int,
			},
			"dateOfBirth": &graphql.Field{
				Type: graphql.DateTime,
			},
			"dateOfDeath": &graphql.Field{
				Type: graphql.DateTime,
			},
			"firstName": &graphql.Field{
				Type: graphql.String,
			},
			"lastName": &graphql.Field{
				Type: graphql.String,
			},
		},
		IsTypeOf: func(p graphql.IsTypeOfParams) bool {
			_, ok := p.Value.(structure.Director)
			return ok
		},
	},
)

var roleType = graphql.NewObject(
	graphql.ObjectConfig{
		Name: "Role",
		Fields: graphql.Fields{
			"characterName": &graphql.Field{
				Type: graphql.String,
			},
		},
	},
)
