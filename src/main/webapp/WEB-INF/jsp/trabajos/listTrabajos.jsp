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
            <th style="width: 80%;">Codigo</th>
            <th style="width: 20%;">Ver productos</th>
            
            
        </tr>
         </thead>
        <tbody>
        <c:forEach items="${works}" var="work">
                <td>
                    <c:out value="${work.codigo}"/>
                </td>
                <td>
                	<a href="/works/${work.id}/products">
                	<span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
                	</a>
                </td>                
            </tr>
            
            
        </c:forEach>
        </tbody>
    </table>
    <p>
    	<a href="/works/new" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Añadir trabajo</a>
    </p>
</petclinic:layout>