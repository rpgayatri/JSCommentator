var dataCount;

function responseAjax() {
	
	dataCount = $("#count").val();
	console.log("dataCount "+dataCount);
	var xhttp = new XMLHttpRequest();
	xhttp.open("GET","getAllComments/"+dataCount,true);
	xhttp.send();
	xhttp.onload = function hitAPI(){
		
		var parent = document.getElementById("comment");
		parent.classList.remove("borderClass");
		
		if(xhttp.readyState == 4) {
	       if(xhttp.status == 200) {
	           var result = JSON.parse(xhttp.responseText);
	           console.log("list of comments::"+xhttp.responseText);
	           console.log("length ::"+result.status);
	           
	           
	           while(parent.hasChildNodes()){
	        	   parent.removeChild(parent.lastChild);
	           }
	           
	           parent.className += "borderClass";
	           for(key in  result){
	        	   if(key === 'listOfComments'){
	        		   var commentList = result[key];
	        		   for(var i=0; i<commentList.length; i++){
	        			   console.log("comment name:"+i+","+commentList[i].userName);
	        			   console.log("comment comment:"+i+","+commentList[i].comment);
	        			   
	        			   var commentParent = document.createElement("p");
	        			   var divName = document.createElement("div");
	        			   var divComment = document.createElement("div");
	        			   
	        			   divName.innerHTML = "USERNAME : "+commentList[i].userName;
	        			   divComment.innerHTML = "COMMENT : "+commentList[i].comment;
	        			  
	        			   
	        			   commentParent.append(divName);
	        			   commentParent.append(divComment);
	        			  
	        			   
	        			   parent.append(commentParent);
	        			   
	        			   
	        		   }
	        	   }
	           }
	          
	       } else {
	           alert( " An error has occurred: " + xhttp.statusText);
	       }
	    }}
    
 }