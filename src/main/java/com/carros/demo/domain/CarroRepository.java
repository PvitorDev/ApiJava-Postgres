package com.carros.demo.domain;

import org.springframework.data.repository.CrudRepository;

public interface CarroRepository extends CrudRepository<Carro, Long> {
    Iterable<Carro> findByTipo(String tipo);
}
