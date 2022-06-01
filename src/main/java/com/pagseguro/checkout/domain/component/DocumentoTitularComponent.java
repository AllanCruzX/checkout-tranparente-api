package com.pagseguro.checkout.domain.component;

import org.springframework.stereotype.Component;

import com.pagseguro.checkout.domain.model.dto.DocumentoTitularDTO;

import br.com.uol.pagseguro.api.common.domain.builder.DocumentBuilder;

@Component
public class DocumentoTitularComponent {
	
	public DocumentBuilder toDocumentBuilder(DocumentoTitularDTO documento) {
		return new DocumentBuilder()
				.withType(documento.getTipo())
				.withValue(documento.getValor());
	}

}
