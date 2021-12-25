<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>


<petclinic:layout pageName="patient">

<div th:if="${message}" th:text="${message}"/>

    <h2>Pacientes</h2>

    <table id="patientTable" class="table table-striped">
        <thead>
        <tr>
            <th>Nombre</th>
            <th>Direccion</th>
            <th>Localidad</th>
            <th>Tarifa</th>
            <th>Telefono</th>
            <th>Email</th>
            <th>DNI</th>
            
            
        </tr>
         </thead>
        <tbody>
        <c:forEach items="${patients}" var="patient">
                <td>
                    <c:out value="${patient.nombre}"/>
                </td>
                <td>
                    <c:out value="${patient.direccion}"/>
                </td>
                <td>
                    <c:out value="${patient.localidad}"/>
                </td>
                <td>
                    <c:out value="${patient.tarifa}"/>
                </td>
                <td>
                    <c:out value="${patient.telefono}"/>
                </td>
                <td>
                    <c:out value="${patient.email}"/>
                </td>
                <td>
                    <c:out value="${patient.DNI}"/>
                </td>
                <td>
                	<a href="/clients/patients/${patient.id}/edit">
                	<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                	</a>
                </td>
                <td>
                	<a href="/clients/patients/${patient.id}/delete">
                	<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                	</a>
                </td>              
            </tr>
            
            
        </c:forEach>
        </tbody>
    </table>
    <p>
    	<a href="/clients/patients/new" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Añadir paciente</a>
    </p>
</petclinic:layout>