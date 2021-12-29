<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petmaterial" tagdir="/WEB-INF/tags" %>


<petmaterial:layout pageName="user">

    <h2>Categorias de materiales</h2>

    <table id="userTable" class="table table-striped">
        <thead>
        <tr>
            <th>Nombre</th>
            <th>Codigo</th>
        </tr>
         </thead>
        <tbody>
        <c:forEach items="${categorias}" var="categoria">
                <td>
                    <c:out value="${categoria.nombre}"/>
                </td>
                <td>
                    <c:out value="${categoria.codigo}"/>
                </td>
                <td>
                	<a href="/materials/categoriasMateriales/${categoria.id}/edit">
                	<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                	</a>
                </td>
                <td>
                	<a href="/materials/categoriasMateriales/${categoria.id}/delete">
                	<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                	</a>
                </td>
                <td>                  
            </tr>
            
            
        </c:forEach>
        </tbody>
    </table>
    <p>
    	<a href="/materials/categoriasMateriales/new" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Añadir categoria de materiales</a>
    </p>
</petmaterial:layout>