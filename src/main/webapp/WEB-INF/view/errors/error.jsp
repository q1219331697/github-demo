<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>出错了</title>
</head>
<body>
  <H2>错误类型: ${exception.getClass().getSimpleName()}</H2>
  <hr />
  <P>错误描述：${exception.message}</P>
  <P>错误信息：</P>
  <c:forEach items="${exception.stackTrace}" var="ste">
    ${ste} 
   </c:forEach>
</body>
</html>