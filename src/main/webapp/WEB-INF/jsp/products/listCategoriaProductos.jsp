<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>


<petclinic:layout pageName="user">

    <h2>Categorías de productos</h2>

    <table id="userTable" class="table table-striped">
        <thead>
        <tr>
            <th style="width: 45%;">Nombre</th>
            <th style="width: 45%;">Codigo</th>
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
                	<a href="/products/categoriasProductos/${categoria.id}/edit">
                	<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                	</a>
                </td>
                <td>
                	<a href="/products/categoriasProductos/${categoria.id}/delete">
                	<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                	</a>
                </td>                
            </tr>
            
            
        </c:forEach>
        </tbody>
    </table>
    <p>
    	<a href="/products/categoriasProductos/new" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Nueva categoría de productos</a>
    </p>
</petclinic:layout>