


const form = document.getElementById('form');
console.log(form);
const signup = document.getElementById('signup');
const username = document.getElementById('uname');
const email = document.getElementById('mailid');
const password = document.getElementById('pwd');

form.addEventListener ('click',(e)=>
{
	console.log("prevent");
	e.preventDefault();
})


function validEmail(checkemail)
{
	console.log(checkemail);
	 const emailregex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/g;
	 const validemail = emailregex.test(String(checkemail).toLowerCase());
	 console.log(validemail);
	 return validemail;
}

function validName(checkname)
{
	console.log(checkname);
	const nameregex = /^[A-Za-z .]{3,15}$/;
	const validname = nameregex.test(String(checkname).toLowerCase());
	console.log(validname);
	return validname;
}

    
signup.addEventListener('click', ()=>
{
	console.log(email.value);
	console.log(username.value);
	if(validEmail(email.value)== true && validName(username.value)== true)
	{
		if(password.value >6 && password.value!= "")
		{
			window.alert("Registration Succesfull");
		}
		
	}
	else
	{
		window.alert("not valid input");
	}
	
})