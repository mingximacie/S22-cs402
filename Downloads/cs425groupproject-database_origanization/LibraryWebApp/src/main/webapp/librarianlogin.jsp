<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Hi Librarian! Welcome back to Group 6 Library!</title>
<style>
.button {
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}

.button1 {background-color: #87A7B3;} /* grey blue */
.button2 {background-color: #DA7F8F;} /* vintage red */ 
</style>
</head>
<body>
    <div style="text-align: center">
        <h1>Librarian Admin Login</h1>
        <form action="login" method="post">
            <label for="email">User Email:</label>
            <input name="email" size="30" />
            <br><br>
            <label for="password">Password:</label>
            <input type="password" name="password" size="30" />
            <br><br>
            <br>Login as a librarian.
            <br><br>           
            <button type="button" class="button button1" onclick="document.location='librarianhome.jsp'">Login</button>
            <button type="button" class="button button2" onclick="document.location='WelcomePage.jsp'">Back</button>
        </form>
    </div>
</body>
</html>