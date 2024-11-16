package br.com.mediterranean.restaurant.controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.aspectj.util.Reflection;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.mediterranean.restaurant.domain.model.Cozinha;
import br.com.mediterranean.restaurant.services.CozinhaService;

@RestController
@RequestMapping(value="/cozinha")
public class CozinhaController {
	
	
	@Autowired
	private CozinhaService service;
	
	@GetMapping(value = "/listar")
	@ResponseBody
	public List<Cozinha> listar(){
		return new ArrayList<>();
	}
	
	@GetMapping(value= "/buscar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cozinha> buscar(@PathVariable(value="id")  Long id) {
		Cozinha cozinha = new Cozinha();
		cozinha.setId(id);
		if(Optional.ofNullable(cozinha).isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(cozinha);
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@PostMapping(value="/salvar", produces = MediaType.APPLICATION_JSON_VALUE )
	@ResponseStatus(HttpStatus.CREATED)
	public Cozinha salvar(@RequestBody Cozinha cozinha){
	 Cozinha novaCozinha = new Cozinha();
	 BeanUtils.copyProperties(cozinha, novaCozinha);
	 return novaCozinha;
		
	}
	
	
	@PutMapping(value="/atualizar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cozinha> atualizar(@PathVariable("id") Long id, @RequestBody Cozinha cozinha) {
		//Busca cozinha existente
		Cozinha cozinhaAtual = new Cozinha();
		
		BeanUtils.copyProperties(cozinha, cozinhaAtual,"id");
		
		return ResponseEntity.status(HttpStatus.OK).body(cozinhaAtual);
	}
	
	@DeleteMapping(value="/remover/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cozinha> remover(@PathVariable("id") Long id) {
		Cozinha cozinhaAtual = new Cozinha();
		
		return ResponseEntity.noContent().build();
	}
	
	
	@PatchMapping(value="/atualizar-parcial/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cozinha> atualizarParcial(@PathVariable Long id, @RequestBody Map<String,Object> campos){
		ObjectMapper objectMapper = new ObjectMapper();
		Cozinha cozinhaOrigem = objectMapper.convertValue(campos, Cozinha.class);
		
		Cozinha cozinhaDestino = new Cozinha();
	   campos.forEach((nomePropriedade, valorPropriedade) -> {
		   Field field = ReflectionUtils.findField(Cozinha.class, nomePropriedade);
		   field.setAccessible(true);
		   
		   Object novoValor = ReflectionUtils.getField(field, cozinhaOrigem);
		   
		   System.out.println(nomePropriedade + " - " + valorPropriedade + " - " + novoValor);
		   
		   ReflectionUtils.setField(field, cozinhaDestino, novoValor);
	   });
	   
	   
		
		return ResponseEntity.ok().body(cozinhaDestino);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
