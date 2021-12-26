<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>


<petclinic:layout pageName="user">

    <h2>Productos del trabajo de doctor(a) <c:out value="${doctor.nombre}"></c:out> para paciente <c:out value="${patient.nombre}"></c:out></h2>

    <table id="userTable" class="table table-striped">
        <thead>
        <tr>
            <th >Nombre</th>
            <th >Unidades</th>
            <th >Precio por unidad</th>
            <th >Descuento</th>
        </tr>
         </thead>
        <tbody>
        <c:forEach items="${productsworks}" var="productwork">
            <tr>
                <td>
                    <c:out value="${productwork}"/>
                </td>
                <td>
                    <c:out value="${productwork.unidades}"/>
                </td>
                <td>
                    <c:out value="${productwork.precioPorUnidad}"/>
                </td>
                <td>
                    <c:out value="${productwork.descuento}"/>
                </td>
                <td>
                	<a href="/works/${work.id}/products/${productwork.id}/edit">
                	<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                	</a>
                </td>
                <td>
                	<a href="/works/${work.id}/products/${productwork.id}/delete">
                	<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                	</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <p>
    	<a href="/works/${work.id}/products/new" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Añadir producto a este trabajo</a>
    </p>
</petclinic:layout>