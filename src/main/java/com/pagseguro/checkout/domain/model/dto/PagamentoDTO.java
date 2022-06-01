package com.pagseguro.checkout.domain.model.dto;

import java.math.BigDecimal;
import java.util.List;

import br.com.uol.pagseguro.api.common.domain.enums.Currency;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PagamentoDTO {

	private Long id;

	private Currency moeda;

	private BigDecimal precoExtra;

	private String referencia;

	private RemetenteDTO remetente;

	private RemessaDTO remessa;

	private List<ProdutoDTO> produtos;

	private CartaoCreditoDTO cartaoCredito;

}
