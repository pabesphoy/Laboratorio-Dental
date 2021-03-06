<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>


<petclinic:layout pageName="user">

<div th:if="${message}" th:text="${message}"/>

    <h2>Trabajos</h2>

    <table id="userTable" class="table table-striped">
        <thead>
        <tr>
            <th>Clinica</th>
            <th>Doctor</th>
            <th>Laboratorio</th>
            <th>Paciente</th>
            <th>Ver productos</th>
        </tr>
         </thead>
        <tbody>
        <c:forEach items="${works}" var="work">
            <tr>
                <td>
                    <c:out value="${work.clinica.nombre}"/>
                </td>
                <td>
                    <c:out value="${work.doctor.nombre}"/>
                </td>
                <td>
                    <c:out value="${work.laboratorio.nombre}"/>
                </td>
                <td>
                    <c:out value="${work.paciente.nombre}"/>
                </td>
                <td>
                	<a href="/works/${work.id}/products">
                	<span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
                	</a>
                </td>
                <td>
                	<a href="/works/${work.id}/edit">
                	<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                	</a>
                </td>
                <td>
                	<a href="/works/${work.id}/delete">
                	<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                	</a>
                </td>   
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <p>
    	<a href="/works/new" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>A??adir trabajo</a>
    </p>
</petclinic:layout>