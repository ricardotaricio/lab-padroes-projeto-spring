package web.dio.designpatterns.repository;

import org.springframework.data.repository.CrudRepository;

import web.dio.designpatterns.entity.ItemCardapio;

public interface ItemCardapioRepository extends CrudRepository<ItemCardapio, Integer>{

}
