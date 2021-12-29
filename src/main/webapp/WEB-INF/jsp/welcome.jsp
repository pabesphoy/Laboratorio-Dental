<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<!-- %@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %-->  

<petclinic:layout pageName="home">
    <div class="row">
        <div class="col-md-4">
            <div class="text-left"><h2>Clientes</h2></div>
            <p>
                <a class="btn btn-default" href="/clients/clinics" style="font-size: x-large; margin-top: 15%; border-radius: 10%;"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Clinicas </a>
            </p>
            <p>
                <a class="btn btn-default" href="/clients/doctors" style="font-size: x-large; margin-top: 15%; border-radius: 10%;"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>Doctores</a>
            </p>
            <p>
                <a class="btn btn-default" href="/clients/laboratories" style="font-size: x-large; margin-top: 15%; border-radius: 10%;"><span class="glyphicon glyphicon-th-large" aria-hidden="true"></span>Laboratorios</a>
            </p>
            <p>
                <a class="btn btn-default" href="/clients/patients" style="font-size: x-large; margin-top: 15%; border-radius: 10%;"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>Pacientes</a>
            </p>
        </div>
        <div class="col-md-4">
            <div class="text-left"><h2>Trabajos</h2></div>
            <p>
                <a class="btn btn-default" href="/works" style="font-size: x-large; margin-top: 15%; border-radius: 10%;"><span class="glyphicon glyphicon-briefcase" aria-hidden="true"></span>Trabajos</a>
            </p>
            <p>
                <a class="btn btn-default" href="/products" style="font-size: x-large; margin-top: 15%; border-radius: 10%;"><span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>Productos </span></a>
            </p>
            <p>
                <a class="btn btn-default" href="/materials" style="font-size: x-large; margin-top: 15%; border-radius: 10%;"><span class="glyphicon glyphicon-leaf" aria-hidden="true"></span>Materiales</span></a>
            </p>
            <p>
                <a class="btn btn-default" href="/suppliers" style="font-size: x-large; margin-top: 15%; border-radius: 10%;"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>Proveedores</span></a>
            </p>
        </div>
        <div class="col-md-4">
            <div class="text-left"><h2>Otros</h2></div>
            <p>
                <a class="btn btn-default" href="/colores" style="font-size: x-large; margin-top: 15%; border-radius: 10%;"><span class="glyphicon glyphicon-tint" aria-hidden="true"></span>Colores</a>
            </p>
            <p>
                <a class="btn btn-default" href="/products/categoriasProductos" style="font-size: x-large; margin-top: 15%; border-radius: 10%;"><span class="glyphicon glyphicon-folder-open" aria-hidden="true"></span>Categorias de productos</a>
            </p>
            <p>
                <a class="btn btn-default" href="/materials/categoriasMateriales" style="font-size: x-large; margin-top: 15%; border-radius: 10%;"><span class="glyphicon glyphicon-folder-open" aria-hidden="true"></span>Categorias de materiales</a>
            </p>
        </div>
    </div>
</petclinic:layout>