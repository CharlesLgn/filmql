FROM golang:latest
WORKDIR /
RUN apt-get update && apt-get upgrade -y
ENV GOBIN /go/bin

COPY . /filmql
RUN ls

EXPOSE 8000

RUN go get github.com/gorilla/mux\
 && go get github.com/graphql-go/graphql\
 && go run /filmql/main.go
