<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Atividades</title>
        <style>
            tr:nth-child(odd){
                background-color: #e0e0e0;
            }
            tr:nth-child(even){
                background-color: #c0c0c0;
            }
        </style>
    </head>
    <body>
        <jsp:include page="fragments/menu.jspf" />
        <h1>Listar Atividades</h1>
        <table>
            <thead>
                <tr>
                    <th>Funcionário</th>
                    <th>Tipo</th>
                    <th>Horas</th>
                    <th>Descrição</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${atividades}" var="atividade">

                    <tr>
                        <td>${atividade.funcionario}</td>                    
                        <td>${atividade.tipo}</td>                    
                        <td>${atividade.horas}</td>                    
                        <td>${atividade.descricao}</td>                    
                        <td>${atividade.id}</td>                    
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
