<%-- 
    Document   : authors
    Created on : 22 avr. 2015, 13:33:20
    Author     : dufaux
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des auteurs</title>
    </head>
    <body>     
        <h1 id="main_title">Liste des auteurs</h1>
        <c:forEach items="${authorsList}" var="author">
            <div class="author">
                <span class="name">${author.authorPK.name}</span>
                <span class="firstname">${author.authorPK.firstname}</span>
            </div>
        </c:forEach>
    </body>
</html>
