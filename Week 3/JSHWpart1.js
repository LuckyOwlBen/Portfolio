window.onload = function(){
    document.getElementById("executeFunctions").addEventListener("click",function(){
        num = document.getElementById("num").value;
        f = document.getElementById("f").value;
        n = document.getElementById("n").value;
        array = document.getElementById("array").value;
        reps = document.getElementById("reps").value;
        bracketString = document.getElementById("bracketString").value;
        console.log(fibonacci(num));
        console.log(sort(f));
        console.log(factorial(n));
        console.log(rotateLeft(array,reps));
        console.log(balancedBrackets(bracketString));
    });

    function fibonacci(num){
        if(num < 0){
            return(NaN);
        }
        else if(num===0){
            return 0;
        }
        else if(num===1 || num === 2){
            return 1;
        }
        else{
            return fibonacci(num-1) + fibonacci(num-2);
        }
    }  
    function sort(f){
       var array = [];
       for(let k = 0;k < f.length; k++){
           array[k] = parseInt(f[k]);
       }
        for(let i = 0; i < array.length; i++){
            for(let j=0;j< array.length-1; j++){
            if(array[j] > array[j+1]){
                let temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
                }
            }
        }
        return array;  
    }
    function factorial(n){
        if(n < 0){
            return(NaN);
        }
        else if(n=== 0){
            return 1;
        }
        else if(n===1){
            return 1;
        }
        else{
            return n * factorial(n - 1);
        }
    } 
    function rotateLeft(array,reps){
        let length = array.length;
        let temp = 0;
        var parsed = [];

        for(let k = 0;k < length; k++){
            parsed[k] = parseInt(array[k]);
        }

        for(let i = 0; i < reps; i++){
            temp = parsed.shift();
            parsed.push(temp);
        } 
        return parsed;
    }
    function balancedBrackets(bracketString){
        let opp;
        let bracketArray = [];

        for(let k = 0; k < bracketString.length ;k++){
            bracketArray[k] = bracketString[k];
        }


		if (bracketArray.length == 0 || bracketArray.length == 1) {
			return false;
		}

		if (bracketArray[0] == '[') {
			opp = ']';
        } 
        else if (bracketArray[0] == '{') {
			opp = '}';
        } 
        else if (bracketArray[0] == '(') {
			opp = ')';
		}
		
		if(bracketArray[bracketArray.length -1] === opp){
            bracketArray.shift();
            bracketArray.pop();
            if(bracketArray[0] === undefined){
                return true;
            }
            return balancedBrackets(bracketArray);
        }
        return false;
    }
}
