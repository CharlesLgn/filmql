#FilmQL 🎬 ![GraphQL Icon](./logo_small.png) ![Univ Lorriane](./Logo_Univ.png)

![IUT Metz Project 2020](https://img.shields.io/badge/IUT%20Metz-2020-95a5a6.svg) 

[![Ligony Charles](https://img.shields.io/badge/Ligony-Charles-2980b9.svg)](https://github.com/CharlesLgn)

[![French Readme](https://img.shields.io/badge/Readme-FR-e67e22.svg)](./readme-fr.md)
[![English Readme](https://img.shields.io/badge/Readme-EN-e67e22.svg)](./readme.md)
 
Projet graphQL créé en tant que correction du cours.
il est fait dans différent langage afin de montrer différentes implémentations possibles.

***
## Règles du projet :

On va créer une mini base de données pour les films. Vous pouvez monter une base de données, tout stocker en XML ou
créer un faux jeu de données en dur dans votre code pour cet exercice.

###Un film
Il est composé d’un titre français, d’un titre original, d’une année de sortie, un réalisateur, une liste de comédien,
ainsi que l’état d’avancement du film [en cours de réalisation ; sortie ; projet abandonné].

Exemple 1

    Le film Le Parrain, de son titre original The Godfather, est sorti  en 1972. Il est réalisé par Francis Ford Coppola.
    Les acteurs principaux sont Marlon Brando, Al Pacino et Robert Duvall.

Exemple 2

    Le film OSS 117 : Alert rouge en Afrique noire, est en cours de réalisation. Il est réalisé par Nicolas Bedos.
    Les acteurs principaux sont Jean Dujardin et Pierre Niney.

###Un réalisateur
Il est composé d’un nom, d’un prénom, d’une date de naissance,  une date de mort, d’une liste de film

Ex.

    Quentin Tarantino est né le 27 mars 1963. Il a réalisé Pulp Fiction, Reservoir Dogs et Kill Bill.

###Un acteur
Il est composé d’un nom, d’un prénom, d’une date de naissance, une  date de mort, d’une liste de film avec son rôle.

Ex.

    Jim Carrey est né le 17 janvier 1962. Il joue Truman Burbank dans The Truman Show, Joël Barish dans Eternal Sunshine 
of the spotless Mind et Carl Allen dans Yes Man.


### Exercise :

1. Réaliser le schéma des différents types avec leurs champs
2. Créer une query films, qui remonte tous les films (on s’occupera pour cette partie seulement de remonter le type scalar)
3. Créer une query director(id: ID!), qui remonte un réalisateur  selon l’id donnée(on s’occupera pour cette partie
   seulement de remonter le type scalar)
4. Créer une query actor(id: ID!), qui remonte un acteur selon l’id donnée(on s’occupera pour cette partie seulement de
   remonter le type scalar)
5. Ajouter, dans la requête films, le moyen de consulter le réalisateur (on pourra créer une requête se basant sur l’id
   d’un film)
6. Ajouter, dans la requête films, le moyen de consulter les acteurs (on pourra créer un type Rôle composé de l’acteur
   et du titre de son rôle pour cela)
7. Ajouter, dans la requête director(id: ID!), le moyen de consulter les films qu’il a réalisés
8. Ajouter, dans la requête actor(id: ID!), le moyen de consulter les rôles qu’il a incarnés
9. Créer une query people, qui remonte tout le monde. Si c’est un acteur, on pourra voir ses rôles, si c’est un
   réalisateur, on pourra voir ses films.
10. Créer une mutation createFilm(film : FilmInput!) qui ajoute un film en base
11. Créer une mutation createPerson(person: PersonInput!) qui ajoute une personne en base
12. Créer une query search(term : String!), permettant de remonter n’importe quelle donné possédant ce terme. 
    Ex. les termes « har » peut faire remonter : Harry Potter (film), Harrison Ford (Acteur), Neil Patrick Harris (Acteur)

Aller plus loin

13. Utiliser les dataloader pour améliorer les performances de la partie 5 ; 6 ; 7 ; 8
14. Créer une subscription permettant de voir les nouveaux films ajouter
15. Réaliser une partie front qui appelle vos API

***

Donné supplémentaire : schéma de base de données

![database schema](./database_schema.png)
