package main

import (
	"./graph"

	"github.com/gorilla/mux"

	"encoding/json"
	"log"
	"net/http"
)

func main() {
	get8000()
}

func get8000() {
	log.Println("RestMan is starting")
	router := mux.NewRouter()
	router.HandleFunc("/filmql/graphql", RunQueryGet).Methods("GET")
	router.HandleFunc("/filmql/graphql", RunQueryPost).Methods("POST")
	log.Println("Server start !")
	log.Fatal(http.ListenAndServe(":8000", router))
}

func RunQueryGet(writer http.ResponseWriter, request *http.Request) {
	v := request.URL.Query()
	graphQuery := GraphQuery{
		OperationName: v.Get("operationName"),
		Query:         v.Get("query"),
		Variables:     v.Get("variables"),
	}
	result := graph.Run(graphQuery.Query)
	_ = json.NewEncoder(writer).Encode(result)
}

func RunQueryPost(writer http.ResponseWriter, request *http.Request) {
	var graphQuery GraphQuery
	err := json.NewDecoder(request.Body).Decode(&graphQuery)
	if err != nil {
		http.Error(writer, err.Error(), http.StatusInternalServerError)
		return
	}
	result := graph.Run(graphQuery.Query)
	_ = json.NewEncoder(writer).Encode(result)
}

type GraphQuery struct {
	OperationName string `json:"operationName"`
	Query         string `json:"query"`
	Variables     string `json:"variables"`
}
