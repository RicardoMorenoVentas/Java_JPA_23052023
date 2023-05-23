package com.softtek.java_jpa_23052023.controlador.servicio;

import com.softtek.java_jpa_23052023.modelo.Customer;
import com.softtek.java_jpa_23052023.modelo.Order;
import com.softtek.java_jpa_23052023.modelo.Product;
import com.softtek.java_jpa_23052023.modelo.repositorio.IRepositoryCustomer;
import com.softtek.java_jpa_23052023.modelo.repositorio.IRepositoryOrders;
import com.softtek.java_jpa_23052023.modelo.repositorio.IRepositoryProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NorthwindService implements IServicio {

    @Autowired
    private IRepositoryProducts repoProductos;
    @Autowired
    private IRepositoryOrders repoOrd;
    @Autowired
    private IRepositoryCustomer repoCustom;

    private List<Product> productList;
    private List<Order> orderList;
    private List<Customer> customerList;

    @Override
    public void obtenerTodos() {
        productList = repoProductos.findAll();
        orderList = repoOrd.findAll();
        customerList = repoCustom.findAll();
//        productList.stream().forEach(System.out::println);
//        orderList.stream().forEach(System.out::println);
//        customerList.stream().forEach(System.out::println);
    }

    ;
}
