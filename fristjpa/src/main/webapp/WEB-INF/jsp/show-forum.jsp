<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <style>
        body {
            font-family: Arial, sans-serif;
        }
        .post {
            border: 1px solid blue;
            padding: 10px;
            margin: 10px 0;
        }
        .post a {
            color: blue;
            text-decoration: none;
        }
        .post strong {
            font-weight: bold;
        }
        .input-section {
            margin-top: 20px;
        }
    </style>

</head>
<body>
	<h1>hello</h1>
	
	<c:forEach var="forum" items="${forums}">
    	<div class="post">
			  <p>${forum.detail}</p>
			  <!-- ลิงค์สำหรับเพิ่ม Love -->
			  <a href="/forum/incrementLove/${forum.id}" class="love-link">
			      Love (${forum.love})  <!-- แสดงจำนวน Love ปัจจุบัน -->
			  </a>
      			<strong>${forum.id}</strong>
      			<strong>ผู้เขียน: ${forum.author}</strong> ${forum.post_date}
    </div>
</c:forEach>
    <div class="input-section">
        <form action="/forum/save" method="post">
            <input type="text" name="detail" placeholder="What's on your mind?" required><br>
            <input type="text" name="author" placeholder="Writer" required><br>
            <button type="submit">ส่ง</button>
        </form>
    </div>
	
</body>
</html>