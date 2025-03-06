<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://jakarta.apache.org/taglibs/standard/permittedTaglibs" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>My Favorite Movies</h1>
	<table border="1">
	<th>ID</th>
	<th>TYPE</th>
	<th>NAME</th>
	<tr>
		<td>${allMovies.movieID }</td>
		<td>${allMovies.movieType }</td>
		<td>${allMovies.movieName }</td>
	</tr>
	</table>
</body>
</html>