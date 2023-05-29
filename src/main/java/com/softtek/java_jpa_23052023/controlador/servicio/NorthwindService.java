package com.softtek.java_jpa_23052023.controlador.servicio;

import com.softtek.java_jpa_23052023.dto.ProductDTO;
import com.softtek.java_jpa_23052023.modelo.Customer;
import com.softtek.java_jpa_23052023.modelo.Order;
import com.softtek.java_jpa_23052023.modelo.Product;
import com.softtek.java_jpa_23052023.modelo.repositorio.IRepositoryCustomer;
import com.softtek.java_jpa_23052023.modelo.repositorio.IRepositoryOrders;
import com.softtek.java_jpa_23052023.modelo.repositorio.IRepositoryProducts;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSOutput;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingDouble;
import static java.util.stream.Collectors.*;

/**
 * CLASE VIEJA, NO USAR
 */
public class NorthwindService {

    @Autowired
    private IRepositoryProducts repoProductos;
    @Autowired
    private IRepositoryOrders repoOrd;
    @Autowired
    private IRepositoryCustomer repoCustom;
    @Autowired
    private ModelMapper mapper;

    private List<Product> productList;
    private List<Order> orderList;
    private List<Customer> customerList;


    public void obtenerTodos() {
        productList = repoProductos.findAll();
        orderList = repoOrd.findAll();
        customerList = repoCustom.findAll();
    }


    public void obtenerUnProducto(Short id) {
        productList.stream().filter(prod -> prod.getProductId().equals(id)).forEach(System.out::println);
    }


    public void obtenerUnaOrden(Short id) {
        orderList.stream().filter(ord -> ord.getOrderId().equals(id)).forEach(System.out::println);
    }


    public void obtenerUnCliente(String id) {
        customerList.stream().filter(prod -> prod.getCustomerId().equals(id)).forEach(System.out::println);
    }


    public void obtenerClientes() {
        customerList.stream().forEach(System.out::println);
    }

//    --Obtener una consulta con Productid, productname, supplierid, categoryId, UnistsinStock, UnitPrice

    public void obtenerProductos() {
        productList.stream().forEach(p -> System.out.println(p.getProductId() + " || " + p.getProductName() + " || " + p.getSupplierId() + " || " + p.getCategoryId() + " || " + p.getUnitsInStock() + " || " + p.getUnitPrice()));
    }

//    --Crear una consulta para obtener el IdOrden, IdCustomer, Fecha de la orden de la tabla de ordenes.

    public void obtenerOrdenesCustomer() {
        orderList.stream().forEach(o -> System.out.println(o.getOrderId() + " || " + o.getCustomerId() + " || " + o.getOrderDate()));
    }

    public void obtenerOrdenesTodo() {
        orderList.stream().forEach(System.out::println);
    }

    public void obtenerProductosTodo() {
        productList.stream().forEach(System.out::println);
    }

    public void obtenerClientesTodo() {
        customerList.stream().forEach(System.out::println);
    }

    //    --Crear una consulta para obtener el OrderId, EmployeeId, Fecha de la orden.
    public void obtenerOrdenesEmpleado() {
        orderList.stream().forEach(o -> System.out.println(o.getOrderId() + " || " + o.getEmployeeId() + " || " + o.getOrderDate()));
    }

//    Columnas calculadas

    //    --Obtener una consulta con Productid, productname y valor del inventario, valor inventrio (UnitsinStock * UnitPrice)
    public void obtenerValorInventario() {
        productList.stream().map(p -> (p.getUnitsInStock() * p.getUnitPrice())).forEach(System.out::println);
    }

    //    --Cuanto vale el punto de reorden (Reorden * precio unitario)
    public void obtenerReorden() {
        productList.stream().filter(p -> p.getReorderLevel() != null).forEach(p -> System.out.println(p.getProductId() + " || " + p.getProductName() + " || " + (p.getUnitPrice() * p.getReorderLevel())));
    }

    //    --Mostrar una consulta con Productid, productname y precio, el nombre del producto debe estar en mayuscula
    public void obtenerProductosMayus() {
        productList.stream().forEach(p -> System.out.println(p.getProductId() + " || " + p.getProductName().toUpperCase() + " || " + p.getUnitPrice()));
    }

    //    --Mostrar una consulta con Productid, productname y
//    precio, el nombre del producto debe contener unicamente 10 caracteres
    public void obtenerProductos10Caract() {
        productList.stream().filter(p -> p.getProductName().length() == 10).forEach(p -> System.out.println(p.getProductId() + " || " + p.getProductName() + " || " + p.getUnitPrice()));
    }

    //    --Obtenre una consulta que muestre la longitud del nombre del producto
    public void obtenerLongNombre() {
        productList.stream().forEach(p -> System.out.println(p.getProductId() + " || " + p.getProductName() + " || " + p.getProductName().length()));
    }

    //    --Obtener una consulta de la tabla de productos que muestre el nombre en minúscula
    public void obtenerProductosMinus() {
        productList.stream().forEach(p -> System.out.println(p.getProductId() + " || " + p.getProductName().toLowerCase() + " || " + p.getUnitPrice()));
    }

    //    --Mostrar una consulta con Productid, productname y precio, el nombre del producto debe contener unicamente 10 caracteres y se deben mostrar en mayúscula
    public void obtenerProd10CarMayus() {
        productList.stream().filter(p -> p.getProductName().length() == 10).forEach(p -> System.out.println(p.getProductId() + " || " + p.getProductName().toUpperCase() + " || " + p.getUnitPrice()));
    }

//    Filtros

    //    --Obtener de la tabla de Customers las columnas CustomerId, CompanyName, Pais Obtener los clientes cuyo pais sea Spain
    public void clientesEspanyoles() {
        customerList.stream().filter(c -> c.getCountry().equals("Spain")).forEach(c -> System.out.println(c.getCustomerId() + " ||" + c.getCompanyName() + " || " + c.getCountry()));
    }

    //    --Obtener de la tabla de Customers las columnas CustomerId, CompanyName, Pais, Obtener los clientes cuyo pais comience con la letra U
    public void clientesConU() {
        customerList.stream().filter(c -> c.getCountry().startsWith("U")).forEach(c -> System.out.println(c.getCustomerId() + " ||" + c.getCompanyName() + " || " + c.getCountry()));
    }

    //    --Obtener de la tabla de Customers las columnas CustomerId, CompanyName, Pais, Obtener los clientes cuyo pais comience con la letra U,S,A
    public void clientesConUSA() {
        customerList.stream().filter(c -> c.getCountry().startsWith("U") || c.getCountry().startsWith("S") || c.getCountry().startsWith("A")).forEach(c -> System.out.println(c.getCustomerId() + " ||" + c.getCompanyName() + " || " + c.getCountry()));
    }

    //    --Obtener de la tabla de Productos las columnas productid, ProductName, UnitPrice cuyos precios esten entre 50 y 150
    public void productos50y150() {
        productList.stream().filter(p -> p.getUnitPrice() >= 50 && p.getUnitPrice() <= 150).forEach(p -> System.out.println(p.getProductId() + " || " + p.getProductName() + " || " + p.getUnitPrice()));
    }

    //    --Obtener las columnas OrderId, CustomerId, employeeid de la tabla de ordenes cuyos empleados sean 1, 4, 9
    public void ordenesEmpleados149() {
        orderList.stream().filter(o -> o.getEmployeeId() == 1 || o.getEmployeeId() == 4 || o.getEmployeeId() == 9).forEach(o -> System.out.println(o.getOrderId() + " || " + o.getCustomerId() + " || " + o.getEmployeeId()));
    }

//    Ordenar

    //    --ORDENAR EL RESULTADO DE LA QUERY POR ALGUNA COLUMNA Obtener la información de la tabla de Products, Ordenarlos por Nombre del Producto de forma ascendente
    public void shortProductsAsc1() {
        productList.stream().sorted((a, b) -> a.getProductId() - b.getProductId()).forEach(System.out::println);
    }

    //    --Obtener la información de la tabla de Products, Ordenarlos por Categoria de forma ascendente y por precio unitario de forma descendente
    public void shortProducsAsc2() {
        productList.stream().sorted((a, b) -> (a.getCategoryId() - b.getCategoryId()) + (int) (a.getUnitPrice() + b.getUnitPrice())).forEach(System.out::println);
    }

    //    --Obtener la información de la tabla de Clientes, Customerid, CompanyName, city, country ordenar por pais, ciudad de forma ascendente
    public void shortClientesAsc1() {
        customerList.stream().sorted(comparing(Customer::getCountry).thenComparing(Customer::getCity)).forEach(c -> System.out.println(c.getCustomerId() + " || " + c.getCompanyName() + " || " + c.getCity() + " || " + c.getCountry()));
    }

    //    --Obtener los productos productid, productname, categoryid, supplierid ordenar por categoryid y supplier únicamente mostrar aquellos cuyo precio esté entre 25 y 200
    public void shortProdConPrecios() {
        productList.stream().sorted(Comparator.comparingInt(Product::getCategoryId).thenComparing(Product::getSupplierId)).filter(p -> p.getUnitPrice() >= 25 && p.getUnitPrice() <= 200).forEach(p -> System.out.println(p.getProductId() + " || " + p.getProductName() + " || " + p.getCategoryId() + " || " + p.getSupplierId()));
    }

//    Funciones agregación

    //    --Cuantos productos hay en la tabla de productos
    public void groupByProd() {
        System.out.println("Hay " + productList.size() + " productos.");
    }

    //    --De la tabla de productos Sumar las cantidades en existencia
    public void sumarExistencias() {
        productList.stream().mapToDouble(Product::getUnitsInStock).sum();
    }

    //    --Promedio de los precios de la tabla de productos
    public void avgPrecioProd() {
        productList.stream().mapToDouble(Product::getUnitPrice).average();
    }

    //    --Obtener los datos de productos ordenados descendentemente por precio unitario de la categoría 1
    public void order1() {
        productList.stream().filter(p -> p.getCategoryId() == 1).sorted((a, b) -> (int) (a.getUnitPrice() - b.getUnitPrice())).forEach(System.out::println);
    }

    //    --Obtener los datos de los clientes(Customers) ordenados descendentemente por nombre(CompanyName) que se encuentren en la ciudad(city) de barcelona, Lisboa
    public void order2() {
        customerList.stream().filter(c -> c.getCity().equals("Barcelona") || c.getCity().equals("Lisboa")).sorted(comparing(Customer::getCompanyName)).forEach(System.out::println);
    }

    //    --Obtener los datos de las ordenes, ordenados descendentemente por la fecha de la orden cuyo cliente(CustomerId) sea ALFKI
    public void order3() {
        orderList.stream().filter(o -> o.getCustomerId().equals("ALFKI")).sorted(comparing(Order::getOrderDate)).forEach(System.out::println);
    }

//    --Obtener los datos del detalle de ordenes, ordenados ascendentemente por precio cuyo producto sea 1, 5 o 20
//    No se hace

    //    --Obtener los datos de las ordenes ordenados ascendentemente por la fecha de la orden cuyo empleado sea 2 o 4
    public void order4() {
        orderList.stream().filter(o -> o.getEmployeeId() == 2 || o.getEmployeeId() == 4).sorted(comparing(Order::getOrderDate)).forEach(System.out::println);
    }

    //    --Obtener los productos cuyo precio están entre 30 y 60 ordenado por nombre
    public void order5() {
        productList.stream().filter(p -> p.getUnitPrice() >= 30 && p.getUnitPrice() <= 60).sorted(comparing(Product::getProductName)).forEach(System.out::println);
    }

    //    --OBTENER EL MAXIMO, MINIMO Y PROMEDIO DE PRECIO UNITARIO DE LA TABLA DE PRODUCTOS UTILIZANDO ALIAS
    public void groupBy1() {
        System.out.println("Max");
        productList.stream().collect(groupingBy(Product::getProductId, maxBy(comparing(Product::getUnitPrice)))).forEach((id, max) -> System.out.println(id + " " + max));
        System.out.println("Min");
        productList.stream().collect(groupingBy(Product::getProductId, minBy(comparing(Product::getUnitPrice)))).forEach((id, min) -> System.out.println(id + " " + min));
        System.out.println("Precio medio");
        productList.stream().collect(groupingBy(Product::getProductId, averagingDouble(Product::getUnitPrice))).forEach((id, avg) -> System.out.println(id + " " + avg));
    }

    //    --Numero de productos por categoria
    public void groupBy2() {
        productList.stream().collect(groupingBy(Product::getCategoryId, counting())).forEach((cat, cant) -> System.out.println("Categoría " + cat + " cantidad " + cant));
    }

    //    --Obtener el precio promedio por proveedor de la tabla de productos
    public void groupBy3() {
        productList.stream().collect(groupingBy(Product::getSupplierId, averagingDouble(Product::getUnitPrice))).forEach((sup, avg) -> System.out.println("Supplier " + sup + " media " + avg));
    }

    //    --Obtener la suma de inventario (UnitsInStock) por SupplierID De la tabla de productos (Products)
    public void groupBy4() {
        productList.stream().collect(groupingBy(Product::getSupplierId, summingInt(Product::getUnitsInStock))).forEach((sup, sum) -> System.out.println("Supplier " + sup + " cantidad de unidades " + sum));
    }

    //    --Contar las ordenes por cliente de la tabla de orders
    public void groupBy5() {
        orderList.stream().collect(groupingBy(Order::getCustomerId, counting())).forEach((cust, count) -> System.out.println("Cliente " + cust + " tiene " + count + " pedidos"));
    }

    //    --Contar las ordenes por empleado de la tabla de ordenes unicamente del empleado 1,3,5,6
    public void groupBy6() {
        orderList.stream().filter(o -> o.getEmployeeId() == 1 || o.getEmployeeId() == 3 || o.getEmployeeId() == 5 || o.getEmployeeId() == 6).collect(groupingBy(Order::getEmployeeId, counting())).forEach((emp, cant) -> System.out.println(String.format("El empleado con id %d tiene %d ordenes", emp, cant)));
    }

    //    --Obtener la suma del envío (freight) por cliente
    public void groupBy7() {
        orderList.stream().filter(o -> o.getFreight() != null).collect(groupingBy(Order::getCustomerId, summingDouble(Order::getFreight))).forEach((cust, fre) -> System.out.println(String.format("Cliente con id %s tiene un Freight de %f", cust, fre)));
    }

    //    --De la tabla de ordenes únicamente de los registros cuya ShipCity sea Madrid, Sevilla, Barcelona, Lisboa, LondonOrdenado por el campo de suma del envío
    public void groupBy8() {
        orderList.stream().filter(o -> o.getShipCity() != null && (o.getShipCity().equals("Madrid") || o.getShipCity().equals("Sevilla") || o.getShipCity().equals("Barcelona") || o.getShipCity().equals("Lisboa") || o.getShipCity().equals("London"))).collect(groupingBy(Order::getShipCity, summingDouble(Order::getFreight))).forEach((city, fre) -> System.out.println(String.format("La ciudad con id %s tiene un Freight de %f", city, fre)));
    }

    //    --Obtener el precio promedio de los productos por categoria sin contar con los productos descontinuados (Discontinued)
    public void groupBy9() {
        productList.stream().filter(p -> p.getDiscontinued() == 0).collect(groupingBy(Product::getCategoryId, averagingDouble(Product::getUnitPrice))).forEach((cat, precio) -> System.out.println(String.format("Categoria %d tiene un precio medio de %f", cat, precio)));
    }

    //    --Obtener la cantidad de productos por categoria,  aquellos cuyo precio se encuentre entre 10 y 60 que tengan más de 12 productos
    public void groupBy10() {
        productList.stream().filter(p -> p.getUnitPrice() >= 10 && p.getUnitPrice() <= 60).collect(groupingBy(Product::getCategoryId, counting())).forEach((cat, cant) -> {
            if (cant >= 12) System.out.println(String.format("La categoría %d tiene %d productos", cat, cant));
        });
    }

    //    --OBTENER LA SUMA DE LAS UNIDADES EN EXISTENCIA (UnitsInStock) POR CATEGORIA, Y TOMANDO EN CUENTA UNICAMENTE LOS PRODUCTOS CUYO PROVEEDOR (SupplierID) SEA IGUAL A 17, 19, 16.
    public void groupBy11() {

    }


//    EJERCICIOS CON MAPPER, DTO.

    //    Obtener el precio promedio por proveedor de la tabla de productos
    public void getPromedio() {
        List <ProductDTO> prods = productList.stream().map(p -> mapper.map(p, ProductDTO.class)).collect(Collectors.toList());

    }
//    Obtener la suma de inventario (UnitsInStock) por SupplierID De la tabla de productos (Products)

//    obtener el precio promedio de los productos por categoria sin contar con los productos descontinuados (Discontinued)


}
