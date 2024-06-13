<%--
  Created by IntelliJ IDEA.
  User: alexandremessuve
  Date: 13/06/2024
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="mode" type="java.lang.String" scope="request" />
<% String title = mode.substring(0, 1).toUpperCase() + mode.substring(1).toLowerCase(); %>
<% boolean isLoginMode = mode.equals("login"); %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%=title%></title>
    <%@include file="/WEB-INF/bootstrap.html"%>
</head>
<body>
<%@include file="/WEB-INF/header.jsp"%>
<main>
    <h1 class="text-center">
        <%=title%>
    </h1>
    <hr />
    <div class="container">
        <form action="${pageContext.request.contextPath}/user/${mode}" method="post">
            <div class="form-group">
                <label for="email">Email address</label>
                <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" placeholder="Enter email">
                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Password">
            </div>
            <button type="submit" class="btn btn-primary"> <%=isLoginMode ? "Login" : "Register"%></button>
        </form>
    </div>
</main>
</body>
</html>
