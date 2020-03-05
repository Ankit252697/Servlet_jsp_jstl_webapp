function fun() {
	var id=document.getElementById("id").value;
	var pass=document.getElementById("pass").value;
	if(id=='')
		{
		document.getElementById("id").style.backgroundColor = "red";
		alert("Enter id");
		return false;
		}
	if(pass=='')
		{
		document.getElementById("pass").style.backgroundColor = "red";
		alert("Enter password");
		return false;
		}
	else{
		return true;
	}
	
}