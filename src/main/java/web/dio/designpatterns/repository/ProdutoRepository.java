package web.dio.designpatterns.repository;

import org.springframework.data.repository.CrudRepository;

import web.dio.designpatterns.entity.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Integer>{

}
