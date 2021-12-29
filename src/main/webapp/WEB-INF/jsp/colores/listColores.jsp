<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petdoctor" tagdir="/WEB-INF/tags" %>


<petdoctor:layout pageName="user">

<div th:if="${message}" th:text="${message}"/>

    <h2>Colores</h2>

    <table id="userTable" class="table table-striped">
        <thead>
        <tr>
            <th style="width: 32%;">Color</th>
            <th style="width: 32%;">Guía</th>
            <th style="width: 32%;">Código</th>
        </tr>
         </thead>
        <tbody>
        <c:forEach items="${colores}" var="color">
                <td>
                    <c:out value="${color.colorName}"/>
                </td>
                <td>
                    <c:out value="${color.guiaColor}"/>
                </td>
                <td>
                    <c:out value="${color.codigo}"/>
                </td>
                <td>
                	<a href="/colores/${color.id}/edit">
                	<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                	</a>
                </td>
                <td>
                	<a href="/colores/${color.id}/delete">
                	<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                	</a>
                </td>
                <td>                
            </tr>
            
            
        </c:forEach>
        </tbody>
    </table>
    <p>
    	<a href="/colores/new" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Nuevo color</a>
    </p>
</petdoctor:layout>