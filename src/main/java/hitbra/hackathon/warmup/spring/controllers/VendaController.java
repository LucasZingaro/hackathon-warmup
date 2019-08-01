package hitbra.hackathon.warmup.spring.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hitbra.hackathon.warmup.spring.model.Veiculo;
import hitbra.hackathon.warmup.spring.model.Venda;
import hitbra.hackathon.warmup.spring.repositories.VeiculoRepository;
import hitbra.hackathon.warmup.spring.repositories.VendaRepository;

@RestController
@RequestMapping("/vendas")
@Api(value = "/vendas")
public class VendaController {
	@Autowired
	private VendaRepository repo;
	private VeiculoRepository veiculoRepo;

	/*---Add nova venda---*/
	@PostMapping
	public ResponseEntity<String> save(@RequestBody Venda venda) {

		if (veiculoRepo.findOne(venda.getIdVeiculo()).isDisponibilidade()) {
			String id = repo.save(venda).id;
			Veiculo veiculo = veiculoRepo.findOne(venda.getIdVeiculo());
			veiculo.setDisponibilidade(false);
			veiculoRepo.save(veiculo);
			return ResponseEntity.ok().body("Nova venda salva pelo ID:" + id);
		}
		return ResponseEntity.ok().body("Atenção!Este veiculo está indisponível para venda, tente outro veiculo.");
	}
	
	@GetMapping
	@ApiOperation(value = "Obtém uma mensagem padrão", response = Venda.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Venda not found") })
	public ResponseEntity<List<Venda>> findBy(
			@ApiParam(value = "Valor de Venda", required = false) @RequestParam(value = "valor", required = false) String valor,
			@ApiParam(value = "Valor da Data da Venda", required = false) @RequestParam(value = "data", required = false) String data,
			@ApiParam(value = "Valor do Id do Comprador", required = false) @RequestParam(value = "idComprador", required = false) String idComprador,
			@ApiParam(value = "Valor do Nome do Comprador", required = false) @RequestParam(value = "nome", required = false) String nome) {

		if (valor != null) {
			if (data != null) {
				return ResponseEntity.ok().body(repo.findByValorDeVendaLikeAndDataDeVendaLike(valor, data));
			}
			return ResponseEntity.ok().body(repo.findByValorDeVendaLike(valor));
		}
		if (data != null) {
			return ResponseEntity.ok().body(repo.findByDataDeVendaLike(data));
		}
		if (idComprador != null) {
			if (nome != null) {
				return ResponseEntity.ok().body(repo.findByIdCompradorAndNomeCompradorLike(idComprador, nome));
			}
			return ResponseEntity.ok().body(repo.findByIdComprador(idComprador));
		}
		if (nome != null) {
			return ResponseEntity.ok().body(repo.findByNomeCompradorLike(nome));
		}
		return ResponseEntity.ok().body(repo.findAll());
	}

	/*---Get a venda by id---*/
	@GetMapping("/{id}")
	public ResponseEntity<Venda> get(@PathVariable("id") String id) {
		Venda venda = repo.findOne(id);
		return ResponseEntity.ok().body(venda);
	}

	/*---Update vendas pelo id---*/
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody Venda venda) {
		venda.id = id;
		repo.save(venda);
		return ResponseEntity.ok().body("Update feito com sucesso.");
	}

	/*---Delete a book by id---*/
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable("id") String id) {
		repo.delete(id);
		return ResponseEntity.ok().body("Venda Excluida com Sucesso.");
	}

	

}

