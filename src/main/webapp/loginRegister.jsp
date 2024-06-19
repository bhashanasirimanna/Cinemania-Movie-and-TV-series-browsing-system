<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Authentication</title>
<link rel="stylesheet" type="text/css" href="css/loginReg.css" />
<link rel="shortcut icon" href="ico.svg" type="image/svg+xml">
</head>
<body>
	<img src="assets/2.png" class="logo">
    <div class="sign">
    <div class="container" id="container">
        <div class="form-container sign-up-container">
            <form method="POST" action="AddUserServlet">
                <h1>Create Account</h1>
            
                <span>or use your email for registration</span>
                <input type="text" placeholder="Userame" name="username" />
                <input type="password" placeholder="Password" name="password" />
                <input required="" type="text" class="form-control" placeholder="Date" onfocus="(this.type='date')" name="dob"/>
                <input type="email" placeholder="Email" name="email" />
                
                <button>Register</button>
            </form>
        </div>
        <div class="form-container sign-in-container">
            <form method="post" action="LoginServlet">
                <h1>Sign in</h1>
            
                <span>or use your account</span>
                <input type="text" placeholder="Username" name="username" />
                <input type="password" placeholder="Password" name="password" />
             
                <button>Login</button>
            </form>
        </div>
        <div class="overlay-container">
            <div class="overlay">
                <div class="overlay-panel overlay-left">
                    <h1>Welcome Back!</h1>
                    <p>To keep connected with us please login with your personal info</p>
                    <button class="ghost" id="signIn">Login</button>
                </div>
                <div class="overlay-panel overlay-right">
                    <h1>Hello, Viewer!</h1>
                    <p>Enter your personal details and start journey with us</p>
                    <button class="ghost" id="signUp">Register</button>
                </div>
            </div>
        </div>
    </div>
</div>

    <script src="js/loginPage.js"></script>
	
		
	<h3><a href ="AddUser.jsp">Register</a></h3>
</body>
</html>