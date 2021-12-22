<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>


<petclinic:layout pageName="user">

    <h2>Productos</h2>

    <table id="userTable" class="table table-striped">
        <thead>
        <tr>
            <th style="width: 14%;">Nombre</th>
            <th style="width: 14%;">Codigo</th>
            <th style="width: 14%;">Precio base</th>
            <th style="width: 14%;">IVA</th>
            <th style="width: 14%;">Categoria</th>
            <th style="width: 14%;">Color</th>
            <th style="width: 14%;">Materiales</th>
            
            
        </tr>
         </thead>
        <tbody>
        <c:forEach items="${products}" var="product">
                <td>
                    <c:out value="${product.nombre}"/>
                </td>
                <td>
                    <c:out value="${product.codigo}"/>
                </td>
                <td>
                    <c:out value="${product.precioBase}"/>
                </td>
                <td>
                    <c:out value="${product.IVA}"/>
                </td>
                <td>
                    <c:out value="${product.categoria}"/>
                </td>
                <td>
                    <c:out value="${product.color}"/>
                </td>
                <td>
                	<a href="/products/${product.id}/materials">
                	<span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
                	</a>
                </td>                
            </tr>
            
            
        </c:forEach>
        </tbody>
    </table>
    <p>
    	<a href="/products/new" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Añadir producto</a>
    </p>
</petclinic:layout>