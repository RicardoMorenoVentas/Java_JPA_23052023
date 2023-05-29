package com.softtek.java_jpa_23052023.modelo.repositorio;

import com.softtek.java_jpa_23052023.modelo.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IGenericRepo<T,ID> extends JpaRepository<Product, Short> {
}
