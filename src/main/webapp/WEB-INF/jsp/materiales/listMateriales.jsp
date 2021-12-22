<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>


<petclinic:layout pageName="user">

    <h2>Materiales</h2>

    <table id="userTable" class="table table-striped">
        <thead>
        <tr>
            <th style="width: 14%;">Nombre</th>
            <th style="width: 14%;">Codigo</th>
            <th style="width: 14%;">Marca de fabricante</th>
            <th style="width: 14%;">Numero de lote</th>
            <th style="width: 14%;">Categoria</th>
            <th style="width: 14%;">Proveedores</th>
            
            
        </tr>
         </thead>
        <tbody>
        <c:forEach items="${materials}" var="material">
                <td>
                    <c:out value="${material.nombre}"/>
                </td>
                <td>
                    <c:out value="${material.codigo}"/>
                </td>
                <td>
                    <c:out value="${material.marcaFabricante}"/>
                </td>
                <td>
                    <c:out value="${material.numeroDeLote}"/>
                </td>
                <td>
                    <c:out value="${material.categoria}"/>
                </td>
                <td>
                	<a href="/materials/${material.id}/suppliers">
                	<span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
                	</a>
                </td>                
            </tr>
            
            
        </c:forEach>
        </tbody>
    </table>
    <p>
    	<a href="/materials/new" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Añadir material</a>
    </p>
</petclinic:layout>