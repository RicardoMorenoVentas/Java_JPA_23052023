package com.softtek.java_jpa_23052023.modelo.repositorio;

import com.softtek.java_jpa_23052023.controlador.servicio.NorthwindService;
import com.softtek.java_jpa_23052023.modelo.Product;

import java.util.List;

public abstract class ICRUD<T,ID> {
    public abstract T registrar(T t) throws Exception;
    public abstract T modificar(T t) throws Exception;
    public abstract List<T> listar() throws Exception;
    public abstract T listarPorId(ID id) throws Exception;
    public abstract void eliminar(ID id) throws Exception;
}
