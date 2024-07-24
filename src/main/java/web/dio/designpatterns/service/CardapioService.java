package web.dio.designpatterns.service;

import web.dio.designpatterns.entity.Cardapio;

public interface CardapioService {
	
	Iterable<Cardapio> obterTodos();
	Cardapio obterPorId(int id);
	Cardapio inserir(Cardapio cardapio);
	Cardapio associarProduto(Integer cardapioId, Integer produtoId);

}
