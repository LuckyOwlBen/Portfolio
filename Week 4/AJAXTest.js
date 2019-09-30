//when the page loads create this button script that sends a get request to an api
window.onload = function(){
   document.getElementById("pokeman").onclick = function() {
       sendAjaxGet('https://pokeapi.co/api/v2/pokemon/25/', showPokeman);
   };
}

// perform Ajax call
function sendAjaxGet(url, func) {
   // step 1: obtain xhr object (Internet Explorer 5,6 don't have it...)
   let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
   // step 2: define onreadystatechange
   xhr.onreadystatechange = function() {
       if (this.readyState == 4 && this.status == 200) {
           func(this);
       }
   }
   // step 3: prepare the request
   xhr.open("GET", url, true);
   // step 4: send the request
   xhr.send(); 
}
//gets the elements in the html document and returns the parsed data from the json object
function showPokeman(xhr) {
   let pokemanObj = JSON.parse(xhr.responseText);
   console.log(pokemanObj);
   document.getElementById("name").innerText = "Name : "+pokemanObj.name;
   document.getElementById("id").innerText = "Number : "+pokemanObj.id;
}