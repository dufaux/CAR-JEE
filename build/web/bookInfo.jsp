<%-- 
    Document   : bookInfo.jsp
    Created on : 21 avr. 2015, 16:14:53
    Author     : rakotoarivony
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div>
    <h1>Résumé du livre</h1>
    <div>
        <span>Titre : <%= request.getParameter("book-title") %></span><br />
        <span>Auteur : <%= request.getParameter("author") %></span><br />
        <span>Année de parution : <%= request.getParameter("parution-year") %></span><br />
    </div>
</div>
