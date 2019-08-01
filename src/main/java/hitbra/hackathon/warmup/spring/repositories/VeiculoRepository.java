package hitbra.hackathon.warmup.spring.repositories;

import hitbra.hackathon.warmup.spring.model.Veiculo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VeiculoRepository extends MongoRepository<Veiculo, String> {

	/**
	 * Buscas Simples
	 */
	public List<Veiculo> findByMarcaLike(String marca);
    public List<Veiculo> findByModeloLike(String modelo);
    public List<Veiculo> findByAnoLike(String ano);
    public List<Veiculo> findByValor(Integer valor);
    public List<Veiculo> findByLocal(String local);
    public List<Veiculo> findByPlaca(String placa);
    public List<Veiculo> findByDataEntrada(String dataEntrada);
    
    /**
     * Buscas Complosta
     */
    public List<Veiculo> findByMarcaLikeAndModeloLikeAndAnoLike(String marca,String modelo, String ano);
    public List<Veiculo> findByMarcaLikeAndModeloLike(String marca, String modelo);
    public List<Veiculo> findByMarcaLikeAndAnoLike(String marca, String ano);
    public List<Veiculo> findByModeloLikeAndAnoLike(String modelo,String ano);
	
    
    

}
