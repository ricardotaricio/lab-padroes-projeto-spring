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

import web.dio.designpatterns.entity.Cardapio;
import web.dio.designpatterns.service.CardapioService;

@RestController
@RequestMapping("/cardapios")
public class CardapioController {

	@Autowired
	private CardapioService cardapioService;
	
	@GetMapping()
	public ResponseEntity<Iterable<Cardapio>> listarTodos() {
		return ResponseEntity.ok(cardapioService.obterTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cardapio> obterPorId(@PathVariable int id) {
		return ResponseEntity.ok(cardapioService.obterPorId(id));
	}
	
	@PostMapping()
	public ResponseEntity<Cardapio> inserir(@RequestBody Cardapio cardapio) {
		cardapio = cardapioService.inserir(cardapio);
		return ResponseEntity.created(URI.create(String.valueOf(cardapio.getId()))).body(cardapio);
	}
	
	@PostMapping("/{cardapioId}/produtos/{produtoId}")
	public ResponseEntity<Cardapio> associarProduto(@PathVariable Integer cardapioId, @PathVariable Integer produtoId) {
		Cardapio cardapio = cardapioService.associarProduto(cardapioId, produtoId);
		return ResponseEntity.ok(cardapio);
	}
}
