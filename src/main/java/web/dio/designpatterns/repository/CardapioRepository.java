package web.dio.designpatterns.repository;

import org.springframework.data.repository.CrudRepository;

import web.dio.designpatterns.entity.Cardapio;

public interface CardapioRepository extends CrudRepository<Cardapio, Integer> {

}
