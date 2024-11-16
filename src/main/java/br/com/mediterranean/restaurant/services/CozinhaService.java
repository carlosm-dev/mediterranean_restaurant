package br.com.mediterranean.restaurant.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.mediterranean.restaurant.domain.model.Cozinha;

@Service
public class CozinhaService {
	
	
	public List<Cozinha> listar(){
		return new ArrayList<>();
	}
	
	public Cozinha salvar(Cozinha cozinha) {
		return new Cozinha();
	}
	
	public Cozinha buscar(Long id) {
		return new Cozinha();
	}
	
	public Cozinha atualizar(Cozinha cozinha) {
		return new Cozinha();
	}
	
	public void remover(Long id) {
		
	}

}
