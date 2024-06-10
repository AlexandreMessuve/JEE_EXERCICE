<%--
  Created by IntelliJ IDEA.
  User: alexandremessuve
  Date: 10/06/2024
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../WEB-INF/boostrap.html"%>
</head>
<body>
<header class="my-2">

        <h1 class="text-center text-danger">
            Mon titre page 2
        </h1>
</header>
<main>
    <div class="d-flex flex-column align-items-center">
        <h3 class="text-center text-danger">Mon tableau</h3>
        <table class="table table-bordered table-striped w-25 h-auto">
            <thead>
            <tr>
                <th>Prenom</th>
                <th>Age</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Alex P</td>
                <td>23</td>
            </tr>
            <tr>
                <td>Florian</td>
                <td>30</td>
            </tr>
            <tr>
                <td>Momo</td>
                <td>27</td>
            </tr>
            <tr>
                <td>Alex M</td>
                <td>27</td>
            </tr>
            </tbody>
        </table>
    </div>

</main>
</body>
</html>
