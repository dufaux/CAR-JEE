<%-- 
    Document   : administration
    Created on : 22 avr. 2015, 15:58:15
    Author     : dufaux
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administration</title>
    </head>
    <body>     
        <h1 id="main_title">Administration</h1>
        <div id="div_form">
            <form action="admin" method="post">
                <fieldset>
                    <legend>Ajout de livre</legend>
                    <label for="title">Titre</label>
                    <input type="text" id="title" name="title" value="" size="12" maxlength="60" />
                    <br />
                    
                    <label for="year">Annee</label>
                    <input type="number" id="year" name="year"/>
                    <br />
                    
                    <label for="author">Auteur</label>
                    <select id="author" name="author">
                        <c:forEach items="${authorsList}" var="author">
                            <option value="${author.id}">${author.name} ${author.firstname}</option>
                        </c:forEach>
                    </select>
                    <br />                    
                    <input type="submit" value="Ajouter"/>
                    <br />
                </fieldset>
            </form>
        </div>
        <c:if test="${book_added}">
            <div>
                <h3>Nouveau livre ajouté</h3>
                <span>Titre : ${param.title}</span>
                <br />
                <span>Année de parution : ${param.year}</span>
                <br />
                <span>Auteur : ${chosen_author.name} ${chosen_author.firstname}</span>
                <br />
            </div>
        </c:if>
        <div class="div-generatebook">
            <button>Générer des livres dans la base</button>
        </div>
    </body>
</html>
