<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petdoctor" tagdir="/WEB-INF/tags" %>


<petdoctor:layout pageName="user">

<div th:if="${message}" th:text="${message}"/>

    <h2>Doctores</h2>

    <table id="userTable" class="table table-striped">
        <thead>
        <tr>
            <th>Nombre</th>
            <th>Direccion</th>
            <th>Localidad</th>
            <th>Tarifa</th>
            <th>Telefono</th>
            <th>Email</th>
            <th>Numero de colegiado</th>
            <th>DNI</th>
            
            
        </tr>
         </thead>
        <tbody>
        <c:forEach items="${doctors}" var="doctor">
                <td>
                    <c:out value="${doctor.nombre}"/>
                </td>
                <td>
                    <c:out value="${doctor.direccion}"/>
                </td>
                <td>
                    <c:out value="${doctor.localidad}"/>
                </td>
                <td>
                    <c:out value="${doctor.tarifa}"/>
                </td>
                <td>
                    <c:out value="${doctor.telefono}"/>
                </td>
                <td>
                    <c:out value="${doctor.email}"/>
                </td>
                <td>
                    <c:out value="${doctor.numeroColegiado}"/>
                </td>
                <td>
                    <c:out value="${doctor.DNI}"/>
                </td>
                <td>
                	<a href="/clients/doctors/${doctor.id}/edit">
                	<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                	</a>
                </td>
                <td>
                	<a href="/clients/doctors/${doctor.id}/delete">
                	<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                	</a>
                </td>
                <td>                
            </tr>
            
            
        </c:forEach>
        </tbody>
    </table>
    <p>
    	<a href="/clients/doctors/new" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Añadir doctor</a>
    </p>
</petdoctor:layout>