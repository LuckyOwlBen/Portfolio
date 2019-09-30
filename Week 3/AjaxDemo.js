window.onload = function(){
   document.getElementById("weather").onclick = function(){
      sendAjaxGet(url,showWeather);
   };
}
//perform an Ajax call
//url represents resource being requested
//func represents the callback function to be invoked when request is complete
function sendAjaxGet(url,func){
//step 1: obtain xhr object(IE 5,6 do not have this function)
   let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
   //step 2: define onreadystatechange
   xhr.onreadystatechange = function(){
      //readyState of 4 means request is complete
      //status of 200 means g2g
      if(this.readyState == 4 && this.status == 200){
         func(this);    //this refers to xhr object 
      }
   }
   //step 3: prepare the request
   xhr.open("GET",url,true);
   //step 4: send the request
   xhr.send();    //IF WE WERE SENDING A POST REQEUST OR ANYTHING THAT USES THE BODY 
                  //IT WOULD GO AS AN ARGUMENT TO SEND()

}

function showWeather(xhr){
   let weatherObj = JSON.parse(xhr.responseText);
   console.log(weatherObj);
   document.getElementById("temperature").innerText="Current Temperature: "+weatherObj.main.temp;
   document.getElementById("humidity").innerText="Current Humidity: "+weatherObj.main.temp;
   document.getElementById("description").innerText="Current Weather: "+weatherObj.weather[0].description;
}