package main

import (
	"./graph"

	"fmt"
)

func main() {
	query := `
  {
    actor(id: 1) {
      firstName
      dateOfBirth
      lastName
      roles {
        characterName
      }
    }
  }
	`
	rJSON, _ := graph.Run(query)
	fmt.Printf("%s \n", rJSON)
}
