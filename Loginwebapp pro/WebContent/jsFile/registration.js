function fun() {
	var id=document.getElementById("userid").value;
	var fname=document.getElementById("fname").value;
	var lname=document.getElementById("lname").value;
	var pass=document.getElementById("pass").value;
	var pass1=document.getElementById("pass1").value;
	var add=document.getElementById("add").value;
	if(id=='')
	{
		document.getElementById("userid").style.backgroundColor="red";
		alert("Not Empty");
		return false;
	}
	else if(fname==''||!isNaN(fname))
	{
		document.getElementById("fname").style.backgroundColor="red";
		alert("First Name not valide");
		return false;
	}
	else if(lname==''||!isNaN(lname))
	{
		document.getElementById("lname").style.backgroundColor="red";
		alert("Last Name not valide");
		return false;
	}
	else if(pass==''||pass!==pass1)
	{
		document.getElementById("pass").style.backgroundColor="red";
		document.getElementById("pass1").style.backgroundColor="red";
		alert("Password not valide");
		return false;
	}
	else if(add=='')
	{
		document.getElementById("add").style.backgroundColor="red";
		alert("Address Must Not Empty");
		return false;
	}
	else
	{
		return true;
	}
	
}