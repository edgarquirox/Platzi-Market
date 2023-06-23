package com.platzi.market.persistance;

import com.platzi.market.persistance.entity.Producto;
import com.platzi.market.persistance.crud.ProctoCrudRepository;

import java.util.List;
import java.util.Optional;

public class ProductoRepository {
    private ProctoCrudRepository proctoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) proctoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria) {
        return proctoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad) {
        return proctoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }
}
