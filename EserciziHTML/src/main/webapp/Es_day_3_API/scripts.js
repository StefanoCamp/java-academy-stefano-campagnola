/**
 * 
 */

 function changePage(pag){
	 window.location.href="./"+pag+".html";
 }
 
 function updateParagraphs(object){
	document.getElementById("primop").innerHTML=object.data.specializzazione;
	document.getElementById("secondop").innerHTML=object.data.ambito.contesto;
 }
 
 function doRequest(){
	 
	 try{
			const request = new XMLHttpRequest();
	 		const username = document.getElementById("username").value;
	 		console.log(username);
			const userParams = 'username='+username;
			request.open('GET', 'http://cicacademy2023.ddns.net/esercizi/getParam?' + userParams,false);		
			request.send();
			if(request.status === 200){
				const object = JSON.parse(request.response);
				updateParagraphs(object); 
			}else{
				throw new Error('Response status != 200: ' + response.status);
			}
			
	 }catch(error){
		 alert('Username errato');
	 }
}

function getObject(){
	const object={
			 "success":true,
			 "data":{
			 "specializzazione":"Design",
			 "ambito":{
			 "contesto":"Enterprise"
			 }
			 }
			};
	return object;
}