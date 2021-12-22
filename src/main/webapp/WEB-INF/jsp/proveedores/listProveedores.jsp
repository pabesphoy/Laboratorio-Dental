<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="user">

    <div th:if="${message}" th:text="${message}" />

    <h2>Proveedores</h2>

    <table id="userTable" class="table table-striped">
        <thead>
            <tr>
                <th style="width: 33%;">Nombre</th>
                <th style="width: 33%;">Direccion</th>
                <th style="width: 33%;">DNI</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${proveedores}" var="proveedor">
                <td>
                    <c:out value="${proveedor.nombre}" />
                </td>
                <td>
                    <c:out value="${proveedor.direccion}" />
                </td>
                <td>
                    <c:out value="${proveedor.DNI}" />
                </td>
            </c:forEach>
        </tbody>
    </table>
    <p>
        <a href="/suppliers/new" class="btn btn-success"><span class="glyphicon glyphicon-plus"
                aria-hidden="true"></span>Añadir proveedor</a>
    </p>
</petclinic:layout>