package web.dio.designpatterns.service;

import web.dio.designpatterns.entity.Cardapio;
import web.dio.designpatterns.entity.ItemCardapio;

public interface CardapioService {
	
	Iterable<Cardapio> listarTodos();
	Cardapio inserir(Cardapio cardapio);
	Cardapio listarPorId(int id);
	ItemCardapio inserirItem(int cardapioId, ItemCardapio item);
}
