/**
 * 
 */

 
function changeContentById(id,testo){
	 
	 document.getElementById(id).innerHTML=testo;
	 
 }
 
 function changeContentByClass(classValue,testo){
	 
	 let elements = document.getElementsByClassName(classValue);
	 for (let item of elements) {
    		item.innerHTML=testo;
    	}
	 
 }
 
 function showImage(image){
	 let img = document.getElementById("meme");
	 img.src=image;
 }
 
 function go(){
	 
	 const urlImages=[
		 "https://i0.wp.com/www.giacomocusano.com/wp-content/uploads/2016/07/coastal-wash-web.jpg?fit=1024%2C682&ssl=1",
		 "https://i0.wp.com/www.giacomocusano.com/wp-content/uploads/2016/07/coastal-wash-web.jpg?fit=1024%2C682&ssl=1",
		 "https://i0.wp.com/www.giacomocusano.com/wp-content/uploads/2016/07/coastal-wash-web.jpg?fit=1024%2C682&ssl=1",
		 "https://i0.wp.com/www.giacomocusano.com/wp-content/uploads/2016/07/coastal-wash-web.jpg?fit=1024%2C682&ssl=1",
		 "https://i0.wp.com/www.giacomocusano.com/wp-content/uploads/2016/07/coastal-wash-web.jpg?fit=1024%2C682&ssl=1",
		 "https://i0.wp.com/www.giacomocusano.com/wp-content/uploads/2016/07/coastal-wash-web.jpg?fit=1024%2C682&ssl=1",
		 "https://i0.wp.com/www.giacomocusano.com/wp-content/uploads/2016/07/coastal-wash-web.jpg?fit=1024%2C682&ssl=1",
		 "https://i0.wp.com/www.giacomocusano.com/wp-content/uploads/2016/07/coastal-wash-web.jpg?fit=1024%2C682&ssl=1",
		 "https://i0.wp.com/www.giacomocusano.com/wp-content/uploads/2016/07/coastal-wash-web.jpg?fit=1024%2C682&ssl=1"];
		 
	let images = document.getElementsByClassName("empty");
	for(let i = 0; i<images.length;i++){
		images[i].src=urlImages[i];
	}
	 
 }