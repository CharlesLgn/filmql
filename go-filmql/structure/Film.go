package structure

import "time"

type Film struct {
	Id int
	FrenchTitle string
	OriginalTitle string
	ReleaseDate time.Time
	Status FilmStatus
	Actors []Actor
	Director Director
}

type Role struct {
	Film Film
	CharacterName string
}

func (film Film) addActor(actor Actor) {
	film.Actors = append(film.Actors, actor)
}

func (film Film) setDirector(director Director) {
	film.Director = director
}

type FilmStatus string

const (
	IN_PROGRESS FilmStatus = "IN_PROGRESS"
	RELEASED    FilmStatus = "RELEASED"
	ABANDONED   FilmStatus = "ABANDONED"
)