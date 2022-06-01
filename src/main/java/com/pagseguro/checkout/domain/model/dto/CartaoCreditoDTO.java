package com.pagseguro.checkout.domain.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CartaoCreditoDTO {
	
	private String token;

	private TitularDTO titular;
	
	private EnderecoDTO enderecoCobranca;
	
	private PrestacaoDTO prestacao;

}
