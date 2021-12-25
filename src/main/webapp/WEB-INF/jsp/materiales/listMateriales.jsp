<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petmaterial" tagdir="/WEB-INF/tags" %>


<petmaterial:layout pageName="user">

    <h2>Materiales</h2>

    <table id="userTable" class="table table-striped">
        <thead>
        <tr>
            <th>Nombre</th>
            <th>Codigo</th>
            <th>Marca de fabricante</th>
            <th>Numero de lote</th>
            <th>Categoria</th>
            <th>Proveedores</th>
            
            
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
                <td>
                	<a href="/materials/${material.id}/edit">
                	<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                	</a>
                </td>
                <td>
                	<a href="/materials/${material.id}/delete">
                	<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                	</a>
                </td>
                <td>                  
            </tr>
            
            
        </c:forEach>
        </tbody>
    </table>
    <p>
    	<a href="/materials/new" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Añadir material</a>
    </p>
</petmaterial:layout>