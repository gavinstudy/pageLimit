<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.gavin.entity.User,java.util.List,java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分页</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css">
</head>
<body>
	<table class="table table-bordered table-striped">
 		<tr>
 			<th>id</th>
 			<th>name</th> 
 			<th>description</th> 
 			<th>createtime</th>
 		</tr>
 		
 		<c:forEach items="${page.users}" var="user">
 		<tr>
 			<td>${user.id}</td>
 			<td>${user.name}</td>
 			<td>${user.description}</td>
 			<td>${user.createtime}</td>
 		</tr>
		</c:forEach>
	</table>
	<br/>
	<div align="center">
	   <c:if test="${page.currentPage>1 }">
	       <a href="${pageContext.request.contextPath }/user?page=${page.currentPage-1}">上一页</a>
	   </c:if>
	   <a href="${pageContext.request.contextPath }/user?page=${1}">首页</a>
	       <c:forEach begin="1" end="${page.totalPage }" step="1" var="i">
	           <c:if test="${page.currentPage==i }">
	               <a href="${pageContext.request.contextPath }/user?page=${i}"><font color="#ff0000">${i}</font></a>
	           		</c:if>
	          <c:if test="${page.currentPage!=i }">
	                <a href="${pageContext.request.contextPath }/user?page=${i}">${i}</a>
	           </c:if>
	       </c:forEach>
	       <a href="${pageContext.request.contextPath }/user?page=${page.totalPage}">末页</a>
	  <c:if test="${page.currentPage< page.totalPage }">
	      <a href="${pageContext.request.contextPath }/user?page=${page.currentPage+1}">下一页</a>
	  </c:if>
	  </div>
 		
</body>
</html>