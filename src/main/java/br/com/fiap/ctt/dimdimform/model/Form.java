package br.com.fiap.ctt.dimdimform.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;


import lombok.Data;


@Data
@Entity
public class Form {
	
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	private int id;
	
	@NotBlank(message = "Preencha o e-mail.")
	private String email;
	
	@NotBlank(message = "Preencha o nome.")
	private String nome;
	
	@NotBlank(message = "Preencha o nome da sua empresa.")
	private String empresa;
	
}
