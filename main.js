function clicked() {
	var user = document.getElementById('username');
	var pass = document.getElementById('password');

	var checkuser = "test";
	var checkpass = "123"

	if (user.value == checkuser) {
		if (pass.value == checkpass) {
			window.alert("You are logged in as "+ user.value);
			open("http://www.yahoo.com");
		}
		else
		window.alert("Incorrect username or Password");	
	}
	else
		window.alert("Incorrect username or Password");
}