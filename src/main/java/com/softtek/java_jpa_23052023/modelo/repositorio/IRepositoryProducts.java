package com.softtek.java_jpa_23052023.modelo.repositorio;

import com.softtek.java_jpa_23052023.dto.ProductDTO;
import com.softtek.java_jpa_23052023.modelo.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepositoryProducts extends IGenericRepo<Product, Short> {
}
