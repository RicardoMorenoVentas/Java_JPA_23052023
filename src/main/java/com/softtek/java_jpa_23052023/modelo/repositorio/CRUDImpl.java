package com.softtek.java_jpa_23052023.modelo.repositorio;

import java.util.List;

public abstract class CRUDImpl<T,ID> extends ICRUD<T, ID> {

    public abstract IGenericRepo<T,ID>getRepo();

    @Override
    public abstract T registrar(T T) throws Exception;

    @Override
    public abstract T modificar(T T) throws Exception;

    @Override
    public abstract List<T> listar() throws Exception;

    @Override
    public abstract T listarPorId(ID aShort) throws Exception;

    @Override
    public abstract void eliminar(ID aShort) throws Exception;
}
