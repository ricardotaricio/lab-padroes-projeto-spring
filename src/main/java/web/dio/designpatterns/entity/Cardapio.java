package web.dio.designpatterns.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cardapio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String nome;
	
	@OneToMany(mappedBy = "cardapio")
	private List<ItemCardapio> itens = new ArrayList<>();

	public List<ItemCardapio> getItens() {
		return itens;
	}
	public void setItens(List<ItemCardapio> itens) {
		this.itens = itens;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
