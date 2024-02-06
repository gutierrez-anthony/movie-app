// wait until the page loads
window.onload = async function () {
    const uri = "http://localhost:3000/api/v1/movies/all";
    const config = {
        method: 'get'
    }
    const response = await fetch(uri, config);
    const data = await response.json();
    showMovies(data);

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

    // update our UI
}

function showMovies(movies) {
    const section = document.querySelector("#movies");
    console.log(section);

    // Loop over each of my movies and create a nested elements
    for (let i = 0; i < movies.length; i++) {
        const movie = movies[i];
        section.innerHTML += `<div class="movie">
                                    <h2>${movie.title}</h2>
                                    <p>ID #${movie.id}</p>
                                    <p>Genre: ${movie.genre}</p>
                                </div>`;
    }
}

