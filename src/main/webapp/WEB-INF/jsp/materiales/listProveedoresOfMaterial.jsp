<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petmaterial" tagdir="/WEB-INF/tags" %>


<petmaterial:layout pageName="user">

    <h2>Proveedores del material <c:out value="${material.nombre}"></c:out></h2>

    <table id="userTable" class="table table-striped">
        <thead>
        <tr>
            <th>Nombre</th>
            <th>Direccion</th>
            <th>DNI</th>
        </tr>
         </thead>
        <tbody>
        <c:forEach items="${suppliers}" var="supplier">
                <td>
                    <c:out value="${supplier.nombre}"/>
                </td>
                <td>
                    <c:out value="${supplier.direccion}"/>
                </td>
                <td>
                    <c:out value="${supplier.DNI}"/>
                </td>
                <td>
                	<a href="/materials/${material.id}/suppliers/${supplier.id}/delete">
                	<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                	</a>
                </td>
                <td>                  
            </tr>
            
            
        </c:forEach>
        </tbody>
    </table>
    <p>
    	<a href="/materials/${material.id}/suppliers/new" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Añadir proveedor de material</a>
    </p>
</petmaterial:layout>