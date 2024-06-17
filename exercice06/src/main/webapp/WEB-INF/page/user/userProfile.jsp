<%--
  Created by IntelliJ IDEA.
  User: alexandremessuve
  Date: 15/06/2024
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="user" class="org.exercice06.entity.User" scope="request" />
<jsp:useBean id="mode" class="java.lang.String" scope="request" />
<% boolean isUpdateMode = mode.equals("update");%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User <%=mode%></title>
    <%@include file="/WEB-INF/bootstrap.html"%>
</head>
<body class="vh-100 bg-dark text-light overflow-hidden">
<%@include file="/WEB-INF/header.jsp"%>
<section>
    <div class="container py-3 h-100 overflow-hidden">
        <div class="row d-flex justify-content-center align-content-center h-50">

            <div class="col col-lg-6 mb-4 mb-lg-0">
                <div class="card mb-3" style="border-radius: .5rem;">
                    <div class="row g-0">
                        <div class="col-md-12">
                            <div class="card-body p-5">
                                <form method="post" action="${pageContext.request.contextPath}/user/updateProfile">
                                <h6>Information</h6>
                                <hr class="mt-0 mb-4">
                                <div class="row pt-1">
                                    <div class="col-12 mb-3">
                                        <h6 class="text-center">Email</h6>
                                        <p class="text-muted text-center"><%=user.getEmail()%></p>
                                        <%if (isUpdateMode) {%>
                                            <input type="number" value="<%=user.getId()%>" hidden="hidden" name="id">
                                        <%}%>
                                    </div>

                                </div>
                                <hr class="mt-0 mb-4">
                                <div class="row pt-1">
                                        <div class="col-6 mb-3">
                                            <h6 class="text-center">Firstname</h6>
                                            <% if (!isUpdateMode) {%>
                                            <p class="text-muted text-center"><%=user.getFirstName() != null ? user.getFirstName() : "-"%></p>
                                            <%} else {%>
                                            <input class="text-center form-control" type="text" name="firstname" value="<%=user.getFirstName() != null ? user.getFirstName() : ""%>">
                                            <%}%>
                                        </div>
                                        <div class="col-6 mb-3">
                                            <h6 class="text-center">Lastname</h6>
                                            <% if (!isUpdateMode) {%>
                                            <p class="text-muted text-center"><%=user.getLastName() != null ? user.getLastName() : "-"%></p>
                                            <%} else {%>
                                            <input class="text-center form-control" type="text" name="lastname" value="<%=user.getLastName() != null ? user.getLastName() : ""%>">
                                            <%}%>
                                        </div>
                                    </div>
                                    <div class="row pt-1">
                                            <div class="col-12 mb-3">
                                                <div class="d-flex justify-content-center align-content-center">
                                                    <% if (!isUpdateMode) {%>
                                                    <a href="${pageContext.request.contextPath}/user/update" class="btn btn-primary mx-2">Update my account</a>
                                                    <a onclick="return confirm('Are you sure ? ')" href="${pageContext.request.contextPath}/user/delete?id=<%=user.getId()%>" class="btn btn-danger">Delete my account</a>
                                                    <%}else{%>
                                                    <button type="submit" class="btn btn-primary"> Confirm change </button>
                                                    <%}%>
                                                </div>
                                            </div>
                                    </div>
                                </form>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>
</section>
</body>
</html>
