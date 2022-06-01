package com.pagseguro.checkout.domain.model.dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PrestacaoDTO {

	private Integer quantidade;

	private BigDecimal valor;

}
