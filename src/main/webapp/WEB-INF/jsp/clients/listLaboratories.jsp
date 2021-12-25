<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petlaboratory" tagdir="/WEB-INF/tags" %>


<petlaboratory:layout pageName="laboratory">

<div th:if="${message}" th:text="${message}"/>

    <h2>Laboratorios</h2>

    <table id="laboratoryTable" class="table table-striped">
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
        <c:forEach items="${laboratories}" var="laboratory">
                <td>
                    <c:out value="${laboratory.nombre}"/>
                </td>
                <td>
                    <c:out value="${laboratory.direccion}"/>
                </td>
                <td>
                    <c:out value="${laboratory.localidad}"/>
                </td>
                <td>
                    <c:out value="${laboratory.tarifa}"/>
                </td>
                <td>
                    <c:out value="${laboratory.telefono}"/>
                </td>
                <td>
                    <c:out value="${laboratory.email}"/>
                </td>
                <td>
                	<a href="/clients/laboratories/${laboratory.id}/edit">
                	<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                	</a>
                </td>
                <td>
                	<a href="/clients/laboratories/${laboratory.id}/delete">
                	<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                	</a>
                </td>         
            </tr>
            
            
        </c:forEach>
        </tbody>
    </table>
    <p>
    	<a href="/clients/laboratories/new" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Añadir laboratorio</a>
    </p>
</petlaboratory:layout>