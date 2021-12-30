package com.administra.dto;

public class ServicoDTO {
	
	private String descricao;
	private String preco;
	private String data;
	private Integer idCliente;
	
	
	public ServicoDTO(String descricao, String preco, String data, Integer idCliente) {
		this.descricao = descricao;
		this.preco = preco;
		this.data = data;
		this.idCliente = idCliente;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

}
