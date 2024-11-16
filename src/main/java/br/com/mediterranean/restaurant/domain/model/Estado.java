package br.com.mediterranean.restaurant.domain.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
public class Estado {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	private String nome;

	@OneToMany(mappedBy = "estado", fetch = FetchType.LAZY)
	private List<Cidade> listCidade;
	
}
