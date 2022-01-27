<html>
<body>
<head>
<meta charset="utf-8">
<title>Member Home</title>
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

.button1 {background-color: #A3D2CA;} /* light green */
.button2 {background-color: #5EAAA8;} /* green */
.button3 {background-color: #DA7F8F;} /* vintage red */ 
</style>
</head>
	<div style="text-align: center">
		<h1>Welcome back to Group 6 Library!</h1>
		<br/><br/>
    	<button type="submit" class="button button1" onclick="document.location='memberSearch.jsp'" >Search</button>
    	<br/><br/>
    	<button type="submit" class="button button2" onclick="document.location='borrowreturn.jsp'" >Borrow/Return</button>
		<br/><br/>
    	<button type="submit" class="button button3" onclick="document.location='WelcomePage.jsp'" >Log out</button>
	</div>
</body>
</html>