package structure

import "time"

type Person interface {
  getId() int
}

type Actor struct {
  Id int
  FirstName string
  LastName string
  DateOfBirth *time.Time
  DateOfDeath *time.Time
  Roles *[]Role
}

type Director struct {
  Id int
  FirstName string
  LastName string
  DateOfBirth *time.Time
  DateOfDeath *time.Time
  Films *[]Film
}

func (director Director) AddFilm(film Film) {
  *director.Films = append(*director.Films, film)
  film.setDirector(director)
}

func (actor Actor) AddRole(film Film, characterName string)  {
  role := Role{
    Film:          film,
    CharacterName: characterName,
  }
  *actor.Roles = append(*actor.Roles, role)
  film.addActor(actor)
}

func (actor Actor) getId() int {
  return actor.Id
}

func (director Director) getId() int {
  return director.Id
}