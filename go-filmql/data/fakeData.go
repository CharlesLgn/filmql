package data

import (
	. "../structure"
	"time"
)

type Game struct {
	Films  []Film
	People []Person
}

var datas = Game{
	Films:  []Film{},
	People: []Person{},
}

func (dataGame Game) init() {
	// Film
	fightClub := Film{
		Id:            1,
		FrenchTitle:   "Fight Club",
		OriginalTitle: "Fight Club",
		ReleaseDate:   time.Date(1999, time.September, 10, 0, 0, 0, 0, time.Local),
		Status:        RELEASED,
		Actors:        []Actor{},
		Director:      Director{},
	}
	babylon := Film{
		Id:            2,
		FrenchTitle:   "Babylon",
		OriginalTitle: "Babylon",
		ReleaseDate:   time.Date(2022, time.December, 25, 0, 0, 0, 0, time.Local),
		Status:        IN_PROGRESS,
		Actors:        []Actor{},
		Director:      Director{},
	}
	// Actor
	edwardNortonBirth := time.Date(1969, time.August, 18, 0, 0, 0, 0, time.Local)
	edwardNorton := Actor{
		Id:        1,
		FirstName: "Edward",
		LastName:  "Norton",
		DateOfBirth: &edwardNortonBirth,
		DateOfDeath: nil,
		Roles:     &[]Role{},
	}
	bradPittBirth := time.Date(1963, time.December, 18, 0, 0, 0, 0, time.Local)
	bradPitt := Actor{
		Id:        2,
		FirstName: "Brad",
		LastName:  "Pitt",
		DateOfBirth: &bradPittBirth,
		DateOfDeath: nil,
		Roles:     &[]Role{},
	}
	// Director
	damienChazelleBirth := time.Date(1985, time.January, 19, 0, 0, 0, 0, time.Local)
	damienChazelle := Director{
		Id:        3,
		FirstName: "Damien",
		LastName:  "Chazelle",
		DateOfBirth: &damienChazelleBirth,
		DateOfDeath: nil,
		Films:     &[]Film{},
	}
	davidFincherBirth := time.Date(1962, time.August, 28, 0, 0, 0, 0, time.Local)
	davidFincher := Director{
		Id:        4,
		FirstName: "David",
		LastName:  "Fincher",
		DateOfBirth: &davidFincherBirth,
		DateOfDeath: nil,
		Films:     &[]Film{},
	}
	// init
	datas.Films = append(datas.Films, fightClub)
	datas.Films = append(datas.Films, babylon)
	datas.People = append(datas.People, edwardNorton)
	datas.People = append(datas.People, bradPitt)
	datas.People = append(datas.People, damienChazelle)
	datas.People = append(datas.People, davidFincher)
	edwardNorton.AddRole(fightClub, "Narator")
	bradPitt.AddRole(fightClub, "Tyle Durden")
	bradPitt.AddRole(babylon, "Unknown")
	damienChazelle.AddFilm(babylon)
	davidFincher.AddFilm(fightClub)
}

func GetFilm() []Film {
	if len(datas.Films) == 0 {
		datas.init()
	}
	return datas.Films
}

func GetPeople() []Person {
	if len(datas.People) == 0 {
		datas.init()
	}
	return datas.People
}
