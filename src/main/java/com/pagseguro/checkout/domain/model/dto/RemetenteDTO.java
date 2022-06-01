package com.pagseguro.checkout.domain.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RemetenteDTO {

	private Long id;

	private String nome;

	private String cpf;

	private String email;

	private TelefoneDTO telefone;
	
	private String hash; 

}
