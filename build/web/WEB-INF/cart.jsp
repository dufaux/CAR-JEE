<%-- 
    Document   : cart
    Created on : 22 avr. 2015, 18:19:51
    Author     : dufaux
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/layout.css" media="screen" />
        <title>Panier en cours</title>
    </head>
    <body>  
        <H1 id="main_title">Voici les livres de votre panier</H1>
        <div id="div_panier">
            <a href="listBooks">
                <span class="span_display_block">Retour à la boutique</span>
            </a>
            <a href="accueil">
                <span class="span_display_block">Retour à l'accueil</span>
            </a>
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
                        <a href="cart?deletedname=${b.title}"><button class="delbutton">Retirer du panier</button></a>
            </div>
        </c:forEach>
        </div>
        <div class="centrage_text">
            <a href="checkout"><button>Commander</button></a>
        </div>
    </body>
</html>
