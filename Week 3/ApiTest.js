window.onload = function () {
   document.getElementById('fetchPokeman').addEventListener('click', getPokemanWithFetchAndAsync);
};

const apiUrl = 'https://pokeapi.co/api/v2/pokemon/ditto/';

let state = {
   pokeman: ''
} 

let updateContent = function () {
   document.getElementById('pokeman').innerText = state.pokeman;
}

async function getPokemanWithFetchAndAsync() {
   try {
       let response = await fetch(apiUrl, { method: "GET", headers: { "Accept": "application/json" } });
       let data = await response.json();
       state.pokeman = data.pokeman;
       updateContent();
   } catch (error) {
       console.log(error);
   }
}

function getPokemanWithFetch() {
   fetch(apiUrl, { method: "GET", headers: { "Accept": "application/json" } })
       
       .then((response) => {
           //return unwrapped promise object for the next chained operation
           let data = response.json();
           return data;
       })
       //utilize unwrapped promise as a JS object
       .then((data) => {
           console.log(data);
           state.pokeman = data.pokeman;
           updateContent();
       })
       //catches errors
       .catch((error) => {
           alert('oh no :(');
           console.log(error);
       });
}