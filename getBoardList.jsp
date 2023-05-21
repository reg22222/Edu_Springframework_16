<%@ page import="java.util.List"%>
<%@ page import="jeonggeun.spring.web.board.impl.BoardDAO"%>
<%@ page import="jeonggeun.spring.web.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/myboard/resources/css/style.css" rel="stylesheet" />
<title>Board List</title>
<!-- 중간 부분 생략 -->
<table>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>등록일</th>
		<th>조회수</th>
	</tr>
	<c:forEach var="board" items="${boardList }">
		<tr>
			<td>${board.seq }</td>
			<td><a href="getBoard.do?seq=${board.seq }">${board.title }</a></td>
			<td>${board.writer }</td>
			<td>${board.regDate }</td>
			<td>${board.cnt }</td>
		</tr>
	</c:forEach>
</table>
<br />
<a href="insertBoard.jsp"><input type="submit" value="새글 작성" /></a>
</body>
</html>