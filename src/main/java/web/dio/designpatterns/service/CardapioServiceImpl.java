package web.dio.designpatterns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dio.designpatterns.entity.Cardapio;
import web.dio.designpatterns.entity.ItemCardapio;
import web.dio.designpatterns.repository.CardapioRepository;
import web.dio.designpatterns.repository.ItemCardapioRepository;

@Service
public class CardapioServiceImpl implements CardapioService {
	@Autowired
	private CardapioRepository cardapioRepository;

	@Autowired
	private ItemCardapioRepository itemRepository;

	@Override
	public Iterable<Cardapio> listarTodos() {
		return cardapioRepository.findAll();
	}
	
	@Override
	public Cardapio inserir(Cardapio cardapio) {
		return cardapioRepository.save(cardapio);
	}
	
	@Override
	public Cardapio listarPorId(int id) {
		return cardapioRepository.findById(id).get();
	}
	
	@Override
	public ItemCardapio inserirItem(int cardapioId, ItemCardapio item) {
		Cardapio cardapio = cardapioRepository.findById(cardapioId).get();

		item.setCardapio(cardapio);
		item = itemRepository.save(item);
		
		return item;
	}
}
