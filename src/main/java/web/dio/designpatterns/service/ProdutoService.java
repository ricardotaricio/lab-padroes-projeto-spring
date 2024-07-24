package web.dio.designpatterns.service;

import web.dio.designpatterns.entity.Produto;

public interface ProdutoService {
	Iterable<Produto> obterTodos();
	Produto obterPorId(Integer id);
	Produto inserir(Produto produto);
}
