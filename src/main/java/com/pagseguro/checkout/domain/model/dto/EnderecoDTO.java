package com.pagseguro.checkout.domain.model.dto;

import br.com.uol.pagseguro.api.common.domain.enums.State;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EnderecoDTO {

	private String codigoPostal;

	private String pais;

	private State estado;

	private String cidade;

	private String complemento;

	private String distrito;

	private String numero;

	private String rua;

}
