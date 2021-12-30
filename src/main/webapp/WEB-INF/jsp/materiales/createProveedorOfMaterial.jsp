<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="users">
    <h2>Agregar proveedor al material <c:out value = "${material.nombre} con numero de lote ${material.numeroDeLote}"></c:out></h2>

    <form:form name="supplier" action="new" method="POST">
        <div class="form-group has-feedback">

            <label for="supplier" style="margin-left: 8.75%; margin-top: 1%; margin-bottom: 1%;">Proveedor</label>
            <select name="supplier" style="margin-left: 2.7%; width: 82.7%; font-size: large;">
                <c:forEach items = "${suppliers}" var = "supplier">
                    <option value="${supplier.id}"><c:out value="${supplier.nombre}"></c:out> </option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                    <button class="btn btn-default" type="submit">Agregar proveedor a material</button>
            </div>
        </div>
    </form:form>
</petclinic:layout> 