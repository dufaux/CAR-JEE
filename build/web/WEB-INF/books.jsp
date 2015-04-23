<%-- 
    Document   : books
    Created on : 22 avr. 2015, 13:37:59
    Author     : dufaux
--%>

<%@page import="java.util.List"%>
<%@page import="com.carJee.model.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/layout.css" media="screen" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <title>Catalogue de livres</title>
    </head>
    <body>
        <%@include file="searchbar.jsp" %>
        <c:choose>
            <c:when test="${bookslist.size()>0}">
                <h1 id="main_title">Voici nos livres</h1>
            </c:when>
            <c:otherwise>
                <h1 id="main_title">Aucun livre trouvé</h1>
            </c:otherwise>
        </c:choose>
        
        <div id="div_panier">
            <a href="cart">
                <span class="span_display_block">Voir votre panier</span>
                <img class="display_inherit" src="img/panier.png">
            </a>
            <a href="accueil">
                <span class="span_display_block">Retour à l'accueil</span>
            </a>
        </div>
         <div id="div_connection">
            <c:if test="${!connected}">
                <form action="accueil" method="post">
                <label for="ident">Identifiant</label>
                <input type="text" id="ident" name="ident" value="" size="12" maxlength="60" />

                <label for="password">Mot de passe</label>
                <input type="password" id="password" name="password" value="" size="12" maxlength="20" />
                <input type="submit" value="ok"/>
                <a href="register"><button>S'enregistrer</button></a>
                </form>
                <c:if test="${wrongconnec}">
                    <span class="error">Identifiant ou mot de passe incorrect(s)</span>
                </c:if>
            </c:if>
            <c:if test="${connected}">
                <span>connecté en tant que ${identifiant}</span>
            </c:if>
        </div>
        
        <div id="book_list">
        <c:forEach items="${bookslist}" var="b">
            <div class="div_book">
                <span class="span_book_title">${b.title}</span>
                <div class="div_book_infos">
                    <span class="span_book_year">${b.parutionYear} -</span>
                    <span class="span_book_author">
                        ${b.author.name}
                        ${b.author.firstname}
                    </span>
                </div>
                <button class="addbutton" value="${b.title}">Ajout au panier</button>
            </div>
        </c:forEach>
        </div>
        
        <script type="text/javascript">
            $(document).ready(function(){
                $(".addbutton").click(function(){
                    $.ajax({
                       url : 'addinbasket', // La ressource ciblée
                       type : 'POST', // Le type de la requête HTTP.
                       data : 'book='+this.value,
                       dataType : 'html'
                    });
                alert("le livre a bien été ajouté");
                });
            });
        </script>
    </body>    
</html>

