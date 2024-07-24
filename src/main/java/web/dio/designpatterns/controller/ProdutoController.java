package web.dio.designpatterns.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.dio.designpatterns.entity.Produto;
import web.dio.designpatterns.service.ProdutoService;

@RestController
@RequestMapping("produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;

	@GetMapping()
	public ResponseEntity<Iterable<Produto>> getAll() {
		return ResponseEntity.ok(produtoService.obterTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> getById(@PathVariable Integer id) {
		return ResponseEntity.ok(produtoService.obterPorId(id));
	}
	
	@PostMapping()
	public ResponseEntity<Produto> add(@RequestBody Produto produto) {
		produto = produtoService.inserir(produto);
		return ResponseEntity.created(URI.create("/produtos/" + produto.getId())).body(produto);
	}
}
