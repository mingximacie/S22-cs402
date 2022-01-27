<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Book Management</title>
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
<body>
	<center>
        <h1>Book Management</h1>
        	<a href="/new" class="button button2">Add New Book</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list" class="button button2">List All Books</a>
    </center>
    <div align="center">
        <c:if test="${book != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${book == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
                <c:if test="${book != null}">
                    <input type="hidden" name="D_ID" value="<c:out value='${book.D_ID}' />" />
                </c:if>           
            <tr>
                <th>ISBN: </th>
                <td>
                    <input type="text" name="ISBN" size="45"
                            value="<c:out value='${book.ISBN}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Title: </th>
                <td>
                    <input type="text" name="title" size="45"
                            value="<c:out value='${book.title}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Publish Date: </th>
                <td>
                    <input type="text" name="publish_date" size="45"
                            value="<c:out value='${book.publish_date}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" class="button button2" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div> 
</body>
</html>