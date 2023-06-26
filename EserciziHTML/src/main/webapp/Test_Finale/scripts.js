/**
 * 
 */

function getRequest(){
	
		 try{
			const request = new XMLHttpRequest();
	 		let username=document.getElementById("username").value;
			let password=document.getElementById("password").value;
			const userParams = 'username='+username+'&password='+password;
			request.open('GET', 'http://cicacademy2023.ddns.net/userInfo/get?' + userParams,false);		
			request.send();
			if(request.status === 200){
				const object = JSON.parse(request.response);
				console.log(object);
				if(object.success===false){
					throw new Error();
				}else{
					localStorage.setItem("object",JSON.stringify(object));
					window.location.href='./profilePage.html';
				}
			}else{
				throw new Error('Response status != 200: ' + response.status);
			}	
		 }catch(error){
			 alert('Utente Sconosciuto');
		 }
	
}

function showElements(){
	
	let object = JSON.parse(localStorage.getItem("object"));
	document.getElementById("image").src=object.data.profilePic;
	document.getElementById("id").innerHTML=object.data.id;
	document.getElementById("name").innerHTML=object.data.name;
	document.getElementById("surname").innerHTML=object.data.surname;
	document.getElementById("userlevel").innerHTML=object.data.userLevel;
	
}