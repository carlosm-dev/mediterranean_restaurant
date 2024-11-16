package br.com.mediterranean.restaurant.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
public class Cidade {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	private String nome;

	@ManyToOne
	@JoinColumn(name="estado_id", referencedColumnName = "id")
	private Estado estado;
}
