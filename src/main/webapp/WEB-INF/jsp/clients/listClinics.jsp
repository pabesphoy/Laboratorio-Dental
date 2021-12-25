<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>


<petclinic:layout pageName="user">

<div th:if="${message}" th:text="${message}"/>

    <h2>Clinicas</h2>

    <table id="userTable" class="table table-striped">
        <thead>
        <tr>
            <th>Nombre</th>
            <th>Direccion</th>
            <th>Localidad</th>
            <th>Tarifa</th>
            <th>Telefono</th>
            <th>Email</th>
            
            
        </tr>
         </thead>
        <tbody>
        <c:forEach items="${clinics}" var="clinic">
                <td>
                    <c:out value="${clinic.nombre}"/>
                </td>
                <td>
                    <c:out value="${clinic.direccion}"/>
                </td>
                <td>
                    <c:out value="${clinic.localidad}"/>
                </td>
                <td>
                    <c:out value="${clinic.tarifa}"/>
                </td>
                <td>
                    <c:out value="${clinic.telefono}"/>
                </td>
                <td>
                    <c:out value="${clinic.email}"/>
                </td>
                <td>
                	<a href="/clients/clinics/${clinic.id}/edit">
                	<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                	</a>
                </td>
                <td>
                	<a href="/clients/clinics/${clinic.id}/delete">
                	<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                	</a>
                </td>                 
            </tr>
            
            
        </c:forEach>
        </tbody>
    </table>
    <p>
    	<a href="/clients/clinics/new" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Añadir clinica</a>
    </p>
</petclinic:layout>