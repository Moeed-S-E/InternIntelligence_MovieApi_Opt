# Movie Database API

Hey there! Welcome to my Movie Database API—a project I built as my first internship task. It’s a RESTful API that lets you manage movie info (think titles, directors, ratings) with a clean, simple design. I had a blast putting this together, and I’m excited to share it with you!

## What’s This All About?
This API is my take on organizing movie data using Spring Boot. It’s got all the CRUD basics—create, read, update, and delete—wrapped up with some cool tools like Swagger for easy testing. Whether you’re adding a new flick or pulling up details on an old favorite, it’s got you covered.

## Features
- **CRUD Operations**: Add a movie, fetch one by ID, list them all, update details, or delete one you’re done with.
  - `POST /movies` – Add a new movie
  - `GET /movies/{id}` – Grab a movie by its ID
  - `GET /movies` – See all movies
  - `PUT /movies/{id}` – Update a movie
  - `DELETE /movies/{id}` – Say goodbye to a movie
  - Bonus: `POST /movies/bulk` – Add a bunch at once!
- **Movie Details**: Each movie has a `title`, `director`, `releaseYear`, `genre`, and `imdbRating`.
- **Swagger Docs**: I’ve added Swagger so you can play with the API right in your browser—super handy!

## Tech I Used
- **Spring Boot**: The backbone of the API—keeps things smooth and fast.
- **JPA (Hibernate)**: Handles the database magic behind the scenes.
- **Swagger (OpenAPI 3.0)**: Makes the API fun to test with interactive docs.
- **H2 Database**: Default in-memory database for quick setup (swap it out if you’d like!).

**Check It Out**:
   - Hit `http://localhost:8080/swagger-ui.html` in your browser to see the Swagger UI.
   - Try adding a movie with a POST request, like:
     ```json
     {
       "title": "The Avengers",
       "director": "Joss Whedon",
       "releaseYear": 2012,
       "genre": "Action, Adventure, Sci-Fi",
       "imdbRating": 8.0
     }
     ```

## What I Learned
This was my first real dive into building an API, and I loved figuring out how REST works. Getting Swagger to play nice with my endpoints felt like a win, and wrestling with JPA taught me a ton about databases. It’s not perfect—versioning and security could use some love—but I’m proud of it!

## Ideas for Next Steps
- Maybe hook up a real database like MySQL.
