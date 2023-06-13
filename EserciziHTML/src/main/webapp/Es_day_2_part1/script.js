/**
 * 
 */

 function somma(a,b){
	 if(a==undefined){
		 a = Math.floor(Math.random() * 100);
	 }
	 if(b==undefined){
		 b = Math.floor(Math.random() * 100);
	 }
	 return (a+b);
	 
 }
 
 function sottrazione(a,b){
	 if(a==undefined){
		 a = Math.floor(Math.random() * 100);
	 }
	 if(b==undefined){
		 b = Math.floor(Math.random() * 100);
	 }
	 return (somma(a,-b));
 }
 
 function moltiplicazione(a,b){
	 if(a==undefined){
		 a = Math.floor(Math.random() * 100);
	 }
	 if(b==undefined){
		 b = Math.floor(Math.random() * 100);
	 }
	 return (a*b);
 }
 
 function divisione(a,b){
	 if(a==undefined){
		 a = Math.floor(Math.random() * 100);
	 }
	 if(b==undefined || b==0){
		 b = Math.floor(Math.random() * 100);
	 }
	 return (moltiplicazione(a,1/b));
 }
 
 function resto(a,b){
	 if(a==undefined){
		 a = Math.floor(Math.random() * 100);
	 }
	 if(b==undefined || b==0){
		 b = Math.floor(Math.random() * 100);
	 }
	 return(a%b);
 }
 
 function isEven(a){
	 if(a==undefined){
		 a = Math.floor(Math.random() * 100);
	 }
	 if(resto(a,2)==0){
		 return true;
	 }
	 else{
		 return false;
	 }
 }
 
 function media(array){
	 if(array==undefined){
		 array=randomIntArrayInRange(0,20,10);
	 }
	 let media = 0;
	 array.forEach(elem => media+=elem);
	 return (divisione(media,array.length));
	 
 }
 
 function greaterThan(a,b){
	 if(a==undefined){
		 a = Math.floor(Math.random() * 100);;
	 }
	 if(b==undefined){
		 b = Math.floor(Math.random() * 100);;
	 }
	 if(a>b){
		 return true;
	 }else if (a<b){
		 return false;
	 }else{
		 return -1;
	 }
 }
 
 function stringIsEmpty(stringa){
	 if(stringa==undefined){
		 stringa=generateRandomString(Math.floor(Math.random() * 20));
	 }
	 if(stringa===""){
		 return true;
	 }else{
		 return false;
	 }
 }
 
 function hasSubString(stringa, sottoStringa){
	if(stringa==undefined){
		 stringa=generateRandomString(Math.floor(Math.random() * 20));
	 }
	 if(sottoStringa==undefined){
		 sottoStringa=generateRandomString(Math.floor(Math.random() * 5));
	 }
	return stringa.includes(sottoStringa);
 }
 
 function isVowel(a){
	 if(a==undefined || a.length>1){
		 a=generateRandomString(1);
	 }
	 return ['a', 'e', 'i', 'o', 'u'].indexOf(a.toLowerCase()) !== -1
 }
 
 function divisibile35(x){
	 if(x==undefined){
		 x = Math.floor(Math.random() * 100);
	 }
	 if((resto(x,3) && resto(x,5)) == 0){
		 console.log("Esercizio 12, soluzione: Il numero " + x +" è divisible sia per 3 che per 5");
	 }else if ((resto(x,3)==0)){
		 console.log("Esercizio 12, soluzione: Il numero " + x +" è divisible per 3");
	 }else if ((resto(x,5)==0)){
		 console.log("Esercizio 12, soluzione: Il numero " + x +" è divisible per 5");
	 }else{
		 console.log("Esercizio 12, soluzione: Il numero " + x +" non è divisibile sia per 3 che per 5");
	 }
 }
 
 function array(){
	 let a =randomIntArrayInRange(0,20,Math.floor(Math.random() * 20));
	 return a;
 }
 
 function isPresent(array, elem){
	 if(array==undefined){
		 array=array();
	 }
	 if(elem == undefined){
		 elem = Math.floor(Math.random() * 20);
	 }
	 return array.indexOf(elem)!==-1;
 }
 
 function appendArrays(array1,array2){
	 if(array1==undefined){
		 array1=array();
	 }
	 if(array2==undefined){
		 array2=array();
	 }
	 return array1.concat(array2);
 }
 
 function getEvenNumbers(array){
	 if(array==undefined){
		 array=array();
	 }
	 let b = array.filter(elem => (resto(elem,2))==0);
	 return b;
 }
 
 function filterNumbers(array){
	 if(array == undefined || array.length!==10){
		 array=array();
	 }
	 let b = array.filter(elem => elem>5);
	 return b;
 }
 
 function getObject(){
	 const object={
		 "prova" : Math.floor(Math.random() * 100),
		 "prova2" : Math.floor(Math.random() * 100)
	 }
	 return object;
 }
 
 function getProperty(object,property){
	 if(object==undefined){
		 object=getObject();
	 }
	 if(property==undefined || !object.hasOwnProperty(property)){
		 property="prova";
	 }
	 return(object[property]);
 }

 function modifyProperty(object, property){
	 if(object==undefined){
		 object=getObject();
	 }
	 if(property==undefined || !object.hasOwnProperty(property)){
		 property="prova";
	 }
	 object[property]=Math.floor(Math.random() * 100);
}

 
 function double(a){
	 if(a==undefined){
		 a=Math.floor(Math.random() * 100);
	 }
	 return moltiplicazione(a,2);
 }
 
 function length(s){
	 if(s==undefined){
		 s=generateRandomString(Math.floor(Math.random() * 30))
	 }
	 return s.length;
 }
 
 const generateRandomString = (length) => {
  let result = '';
  const characters =
    'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
  const charactersLength = characters.length;
  for (let i = 0; i < length; i++) {
    result += characters.charAt(Math.floor(Math.random() * charactersLength));
  }
  return result;
};

const randomIntArrayInRange = (min, max, n = 1) =>
  Array.from(
    { length: n },
    () => Math.floor(Math.random() * (max - min + 1)) + min
  );
  
function verifyPresenceOfCharacter(stringa, char){
	
	if(stringa==undefined){
		stringa=generateRandomString(Math.floor(Math.random() * 20));
	}
	if(char==undefined){
		char=generateRandomString(1);
	}
	return stringa.indexOf(char);
	
}

function getMax(a,b){
	if(a==undefined){
		a=Math.floor(Math.random() * 100);
	}
	if(b==undefined){
		b=Math.floor(Math.random() * 100);
	}
	return Math.max(a,b);
}

function reverseString(stringa){
	if(stringa==undefined){
		stringa=generateRandomString(Math.floor(Math.random() * 20));
	}
	let splitString = stringa.split("")
    let reverseArray = splitString.reverse();
    let joinArray = reverseArray.join("");
    return joinArray;
	
}

function sumArray(array){
	if(array==undefined){
		array = randomIntArrayInRange(1,50,20);
	}
	somma = 0;
	array.forEach(elem => somma+=elem);
	return somma;
}

function maxArray(array){
	if(array==undefined){
		array = randomIntArrayInRange(1,50,20);
	}
	max = Math.max(...array);
	return max;
}

function longerString(stringa1,stringa2){
	if(stringa1==undefined){
		stringa1=generateRandomString(Math.floor(Math.random() * 20));
	}
	if(stringa2==undefined){
		stringa2=generateRandomString(Math.floor(Math.random() * 20));
	}
	result = greaterThan(stringa1.length,stringa2.length);
	if(result){
		return stringa1;
	}else if(result==false){
		return stringa2;
	}else{
		return -1;
	}
}

function print(message,result){
	console.log(message + result);
}