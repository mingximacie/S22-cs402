<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search information here</title>
	<style>
	.button {
	  border: none;
	  color: white;
	  padding: 10px 15px;
	  text-align: center;
	  text-decoration: none;
	  display: inline-block;
	  font-size: 14px;
	  margin: 4px 2px;
	  cursor: pointer;
	}
	
	.button1 {background-color: #A3D2CA;} /* light green */
	.button2 {background-color: #5EAAA8;} /* green */
	.button3 {background-color: #056676;} /* dark green */
	.button4 {background-color: #DA7F8F;} /* vintage red */ 
	
	</style>
</head>
<body>
<h2>Search the requirement material</h2>
	<form action = "DocumentsResult.jsp" method = "GET">
       <h2> </h2>
         Documents ID:   <input type = "text" name = "documents_ID">
         <input type = "submit" value = "search" class="button button2" />
      </form>     
      
          <form action = "SearchResult.jsp" method = "GET">
       <h2> </h2>
         Book ISBN: <input type = "text" name = "book_ISBN">
         <input type = "submit" value = "search" class="button button2" />
      </form>
      
      <form action = "GetBorrow" method = "GET">
       <h2> </h2>
         Borrow ID: <input type = "text" name = "iID">
         <input type = "submit" value = "search" class="button button2" />
      </form>
      
        <form action = "GetCopies" method = "GET">
       <h2> </h2>
         Copies: <input type = "text" name = "iID">
         <input type = "submit" value = "search" class="button button2" />
      </form>
      

       <form action = "GetThesis" method = "GET">
       <h2> </h2>
         Thesis title: <input type = "text" name = "title">
         <input type = "submit" value = "search" class="button button2" />
      </form>
      
      
       <form action = "SearchResult.jsp" method = "GET">
       <h2> </h2>
         Journal Article title: <input type = "text" name = "JA_name">
         <input type = "submit" value = "search" class="button button2" />
      </form>
      
      
      <form action = "SearchResult.jsp" method = "GET">
       <h2> </h2>
         Technical Report title: <input type = "text" name = "TR_name">
         <input type = "submit" value = "search" class="button button2" />
      </form>
      
      
       <form action = "GetMagazine" method = "GET">
       <h2> </h2>
         Magazine title: <input type = "text" name = "d_id">
         <input type = "submit" value = "search" class="button button2" />
      </form>
      
      <form action = "GetCitation" method = "GET">
       <h2> </h2>
         Citation: <input type = "text" name = "iID">
         <input type = "submit" value = "search" class="button button2" />
      </form>
      
      
</body>
</html>