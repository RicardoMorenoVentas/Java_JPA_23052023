package com.softtek.java_jpa_23052023.controlador.servicio;

import com.softtek.java_jpa_23052023.modelo.Product;
import com.softtek.java_jpa_23052023.modelo.repositorio.CRUDImpl;
import com.softtek.java_jpa_23052023.modelo.repositorio.IGenericRepo;
import com.softtek.java_jpa_23052023.modelo.repositorio.IRepositoryProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl extends CRUDImpl<Product,Short> {

    @Autowired
    IRepositoryProducts repo;


    @Override
    public IGenericRepo<Product, Short> getRepo() {
        return repo;
    }

    @Override
    public Product registrar(Product T) throws Exception {
        return repo.saveAndFlush(T);
    }

    @Override
    public Product modificar(Product T) throws Exception {
        return repo.saveAndFlush(T);
    }

    @Override
    public List<Product> listar() throws Exception {
        return repo.findAll();
    }

    @Override
    public Product listarPorId(Short aShort) throws Exception {
        return repo.findById(aShort).get();
    }

    @Override
    public void eliminar(Short aShort) throws Exception {
        repo.deleteById(aShort);
    }
}
