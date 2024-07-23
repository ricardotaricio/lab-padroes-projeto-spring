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
import web.dio.designpatterns.entity.ItemCardapio;
import web.dio.designpatterns.service.CardapioService;

@RestController
@RequestMapping("/cardapios")
public class CardapioController {

	@Autowired
	private CardapioService cardapioService;
	
	@GetMapping("/")
	public ResponseEntity<Iterable<Cardapio>> getAll() {
		return ResponseEntity.ok(cardapioService.listarTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cardapio> getByid(@PathVariable int id) {
		return ResponseEntity.ok(cardapioService.listarPorId(id));
	}
	
	@PostMapping("/")
	public ResponseEntity<Cardapio> add(@RequestBody Cardapio cardapio) {
		cardapio = cardapioService.inserir(cardapio);
		return ResponseEntity.created(URI.create(String.valueOf(cardapio.getId()))).body(cardapio);
	}
	
	@PostMapping("/{cardapioId}/itens")
	public ResponseEntity<ItemCardapio> addItem(@PathVariable int cardapioId, @RequestBody ItemCardapio item) {
		item = cardapioService.inserirItem(cardapioId, item);
		return ResponseEntity.created(URI.create("cardapio/" + cardapioId + "/itens/" + item.getId())).body(item);
	}
}
