package com.pagseguro.checkout.domain.model.dto;

import br.com.uol.pagseguro.api.common.domain.enums.DocumentType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DocumentoTitularDTO {

	private DocumentType tipo;

	private String valor;

}
