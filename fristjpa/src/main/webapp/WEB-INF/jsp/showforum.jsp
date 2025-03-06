<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Forum</title>
</head>
<body>
    <h1>Show Forum</h1>
    <table border="1">
        <thead>
            <tr>
                <th>id</th>
                <th>author</th>
                <th>detail</th>
                <th>love</th>
                <th>post_date</th>
            </tr>
        </thead>
        <tbody>
            <!-- ใช้ c:forEach เพื่อวนลูปผ่านข้อมูลใน allForum -->
            <c:forEach items="${allForums}" var="f">
                <tr>
                    <td>${f.id}</td> <!-- แสดง id -->
                    <td>${f.author}</td> <!-- แสดง author -->
                    <td>${f.detail}</td> <!-- แสดง detail -->
                    <td>${f.love}</td> <!-- แสดง love -->
                    <td>${f.post_date}</td> <!-- แสดง post_date -->
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
