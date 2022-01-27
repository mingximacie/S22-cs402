<html>
<body>
<head>
<meta charset="utf-8">
<title>Searching</title>
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
.button3 {background-color: #056676;} /* dark green */
.button4 {background-color: #DA7F8F;} /* vintage red */ 

</style>
</head>
<center>
	<h2>Welcome to Home!</h2> 
	<form action="AllMembers2" method="get">
    <button type="submit" class="button button1" >Show Members</button>
    </form> 
    <form action="ManageBR" method="get">
    <button type="submit" class="button button2" >Show Borrow/Return History</button> <!-- ManageBR.jsp -->
    </form>
    <form>
    <button type="submit" class="button button2" onclick="document.location='librarianSearch.jsp'" >Search</button>
    </form>
    <form action="getInformation" method="get">
    <button type="submit" class="button button2" >Show Documents</button>
    </form>
    <form action="ManageCopies" method="get">
    <button type="submit" class="button button2" >Show Copies</button>
    </form>
    <form action="listBook" method="get">
    <button type="submit" class="button button3" >Show Books</button>
    </form>
    <br/><br/>
    <button type="submit" class="button button4" onclick="document.location='WelcomePage.jsp'" >Log out</button>
</center>
</body>
</html>