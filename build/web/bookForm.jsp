<%-- 
    Document   : bookForm
    Created on : 21 avr. 2015, 17:07:06
    Author     : rakotoarivony
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%
    String bookTitle = request.getParameter("book-title");
    String author = request.getParameter("author");
    String parutionYear = request.getParameter("parution-year");    
%>

<html>
    <head>
        <title>Book Form</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>
            <form action="bookForm.jsp">
                <label for="book-title">Titre : </label>
                <input type="text" name="book-title" id="book-title" value="<%=(bookTitle==null?"":bookTitle)%>"/>
                <label for="author">Auteur : </label>
                <input type="text" name="author" id="author" value="<%=(author==null?"":author)%>"/>
                <label for="parution-year">Année de parution : </label>
                <input type="text" name="parution-year" id="parution-year" value="<%=(parutionYear==null?"":parutionYear)%>"/>
                <input type="submit" value="submit"/>
            </form>
        </div>
        <% if(bookTitle!=null){%>
        <jsp:include page="bookInfo.jsp"/>
        <%}%>
    </body>
</html>

