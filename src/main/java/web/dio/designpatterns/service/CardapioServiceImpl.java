package web.dio.designpatterns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dio.designpatterns.entity.Cardapio;
import web.dio.designpatterns.entity.Produto;
import web.dio.designpatterns.repository.CardapioRepository;
import web.dio.designpatterns.repository.ProdutoRepository;

@Service
public class CardapioServiceImpl implements CardapioService {
	@Autowired
	private CardapioRepository cardapioRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public Iterable<Cardapio> obterTodos() {
		return cardapioRepository.findAll();
	}
	
	@Override
	public Cardapio inserir(Cardapio cardapio) {
		return cardapioRepository.save(cardapio);
	}
	
	@Override
	public Cardapio obterPorId(int id) {
		return cardapioRepository.findById(id).get();
	}

	@Override
	public Cardapio associarProduto(Integer cardapioId, Integer produtoId) {
		Cardapio cardapio = cardapioRepository.findById(cardapioId).get();
		Produto produto = produtoRepository.findById(produtoId).get();
		
		cardapio.getProdutos().add(produto);
		return cardapioRepository.save(cardapio);
	}
}
