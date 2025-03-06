<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!---
	http://localhost:224/cus/show/1
	Hello Customer com.example.fristjpa.model.Customer@22d9febd
	Customer ID Optional[com.example.fristjpa.model.Customer@22d9febd]
	 --->
	<h1>Hello Customer ${abc}</h1> 
	<h1>Customer ID ${xyz}</h1>
	<c:out value=""/>
</body>
</html>