package hitbra.hackathon.warmup.spring.repositories;


import hitbra.hackathon.warmup.spring.model.Venda;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VendaRepository extends MongoRepository<Venda, String> {

	/**
	 * Buscas Simples
	 */
	public List<Venda> findByValorDeVendaLike(String valor);

	public List<Venda> findByDataDeVendaLike(String data);

	public List<Venda> findByIdComprador(String idComprador);

	public List<Venda> findByNomeCompradorLike(String nome);

	/**
	 * Buscas Complosta
	 */
	public List<Venda> findByValorDeVendaLikeAndDataDeVendaLike(String valor, String data);

	public List<Venda> findByIdCompradorAndNomeCompradorLike(String idComprador, String nome);

	public List<Venda> findByIdCompradorAndDataDeVendaLike(String idComprador, String data);

	public List<Venda> findByDataDeVendaLikeAndNomeCompradorLike(String data, String nome);
}

