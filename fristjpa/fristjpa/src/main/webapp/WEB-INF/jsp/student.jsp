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
	<!-- <h1>Hello ${abc.getStudentID}</h1>  -->
	<!-- <h2>Your age is ${abc.getStudentName}</h2> -->
	
	<h1>Hello ${name}</h1>
	<h2>Your age is ${age}</h2>
	<h2>Student ID: <c:out value="${stuid}" default="Unknow Student ID" /> </h2>

</body>
</html>