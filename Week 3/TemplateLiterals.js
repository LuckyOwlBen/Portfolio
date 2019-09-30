//tagged template
let age = 34;
function templateScript(strings, age){
   let str0 = strings[0];
   let str1 = strings[1];
   let ageString;
   if(age < 40){
      ageString = 'rad dude';
   }
   else{
      ageString = 'distinguished gentleman';
   }
      return`${str0}${ageString}`;
}
      let output = templateScript`that Benji is a ${age}`;
      console.log(output);
