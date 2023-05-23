package com.softtek.java_jpa_23052023.modelo.repositorio;

import com.softtek.java_jpa_23052023.modelo.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryOrders extends JpaRepository<Order,Short> {
}
