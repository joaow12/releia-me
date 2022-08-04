package com.projetointegrador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_avaliacao")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 

public class Avaliacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private float avaliacao;
	
	@NotNull
	private String comentario;
	
	@OneToOne
	@JsonIgnoreProperties(value = {"pedido", "endereco", "dataNascimento", "senha"}, allowSetters = true)
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@ManyToOne
	@JsonIgnoreProperties(value = {"capa", "descricao", "autor", "qtdeEstoque", "temEstoque", "isbn", "valorUnitario", "qtdePedidoLivro", "etiqueta", "pedido", "funcionario"}, allowSetters = true)
	@JoinColumn(name = "id_livros")
	private Livros livros;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(float avaliacao) {
		this.avaliacao = avaliacao;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Livros getLivros() {
		return livros;
	}

	public void setLivros(Livros livros) {
		this.livros = livros;
	}

}
