const registerbtn = document.querySelector("#signbtn");
registerbtn.addEventListener("click",()=>
{

	 window.location.assign("Signup.html");
})

const loggedin = document.querySelector("#loginbtn")
loggedin.addEventListener("click",()=>

{
	
	let uname = document.getElementById("uid").value;
	console.log(uname);
	let pwd = document.getElementById("pwd").value;
	if(uname === 'swarna' && pwd === "Perscholas")
	{
		
		window.location.href = "Userscreen.html";
		
	}
	else
	{
		alert("Invalid user");
	}
}
)