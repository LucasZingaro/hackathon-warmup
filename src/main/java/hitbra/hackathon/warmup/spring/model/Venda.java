package hitbra.hackathon.warmup.spring.model;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="vendas")
public class Venda {
	
	private String valorDeVenda;
	private String dataDeVenda;
	private String idComprador;
	private String nomeComprador;
	private String idVeiculo;
	

	@Id
    public String id;



	public String getValorDeVenda() {
		return valorDeVenda;
	}



	public void setValorDeVenda(String valorDeVenda) {
		this.valorDeVenda = valorDeVenda;
	}



	public String getDataDeVenda() {
		return dataDeVenda;
	}



	public void setDataDeVenda(String dataDeVenda) {
		this.dataDeVenda = dataDeVenda;
	}



	public String getIdComprador() {
		return idComprador;
	}



	public void setIdComprador(String idComprador) {
		this.idComprador = idComprador;
	}



	public String getNomeComprador() {
		return nomeComprador;
	}



	public void setNomeComprador(String nomeComprador) {
		this.nomeComprador = nomeComprador;
	}



	public String getIdVeiculo() {
		return idVeiculo;
	}



	public void setIdVeiculo(String idVeiculo) {
		this.idVeiculo = idVeiculo;
	}


}
