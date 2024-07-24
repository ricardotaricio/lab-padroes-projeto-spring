package web.dio.designpatterns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dio.designpatterns.entity.Produto;
import web.dio.designpatterns.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public Iterable<Produto> obterTodos() {
		return produtoRepository.findAll();
	}

	@Override
	public Produto obterPorId(Integer id) {
		return produtoRepository.findById(id).get();
	}

	@Override
	public Produto inserir(Produto produto) {
		return produtoRepository.save(produto);
	}

}
