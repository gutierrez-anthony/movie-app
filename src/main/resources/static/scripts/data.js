// wait until the page loads
window.onload = async function () {
    const uri = `${window.location.origin}/api/v1/movies/all`;
    const config = {
        method: 'get'
    }
    const response = await fetch(uri, config);
    const data = await response.json();
    showMovies(data);

    /*
        When converting a json text to a javascript object -> json.parse()
        When converting a js object to a json text -> json.stringify()
    */

    /* Promises
    fetch(uri, config)
        .then(function (response) {
            console.log(response);

            // returns another promise
            return response.json();
        })
        .then(function(data) {
            console.log(data);
            showMovies(data);
        });*/

    // Select form button and handle form submission
    const button = document.querySelector("button");
    button.onclick = addMovie;
    // update our UI
}

async function addMovie(event) {
    // Stops form from submitting
    event.preventDefault();

    const newMovie = {
        title: document.querySelector("#title").value,
        genre: document.querySelector("#genre").value
    }
    //console.log("Button Clicked");
    const uri = `${window.location.origin}/api/v1/movies`;
    const config = {
        method: "post",
        headers: {"Content-Type": "application/json"
        },
        body: JSON.stringify(newMovie)
    }

    const response = await fetch(uri, config);
    const data = await response.json();

    const section = document.querySelector("#movies");
    addMovieSection(section, data);
}

function showMovies(movies) {
    const section = document.querySelector("#movies");
    //console.log(section);

    // Loop over each of my movies and create a nested elements
    for (let i = 0; i < movies.length; i++) {
        const movie = movies[i];
        addMovieSection(section, movie);
    }
}

function addMovieSection(section, movie) {
    section.innerHTML += `<div class="movie">
                                    <h2>${movie.title}</h2>
                                    <p>ID #${movie.id}</p>
                                    <p>Genre: ${movie.genre}</p>
                                </div>`;
}