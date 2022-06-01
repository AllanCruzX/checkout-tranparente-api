package com.pagseguro.checkout.domain.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TelefoneDTO {

	private Long id;

	private String codigoArea;

	private String numero;

}
