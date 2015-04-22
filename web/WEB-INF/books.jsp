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
        <H1 id="main_title">Voici nos livres</H1>
        <div id="div_panier"><a href="cart">
                <span class="span_display_block">Voir votre panier</span>
                <img class="display_inherit" src="img/panier.png">
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
                <button class="addbutton" value="${b.title}">Ajout au panier</button>
            </div>
        </c:forEach>
        </div>
    </body>
    <script>
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
</html>
