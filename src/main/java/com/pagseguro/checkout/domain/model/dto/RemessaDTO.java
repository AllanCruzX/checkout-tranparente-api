package com.pagseguro.checkout.domain.model.dto;

import java.math.BigDecimal;

import br.com.uol.pagseguro.api.common.domain.ShippingType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RemessaDTO {

	private ShippingType.Type tipo;

	private BigDecimal custo;

	private EnderecoDTO endereco;

}
