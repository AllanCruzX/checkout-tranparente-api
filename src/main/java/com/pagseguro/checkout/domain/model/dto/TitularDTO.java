package com.pagseguro.checkout.domain.model.dto;

import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TitularDTO {

	private String nome;

	private Date dataAniversario;

	private TelefoneDTO telefone;

	private List<DocumentoTitularDTO> documentos;

}
