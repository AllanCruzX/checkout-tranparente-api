package com.pagseguro.checkout.domain.component;

import org.springframework.stereotype.Component;

import com.pagseguro.checkout.domain.model.dto.PrestacaoDTO;

import br.com.uol.pagseguro.api.common.domain.builder.InstallmentBuilder;

@Component
public class PrestacaoComponent {
	
	public InstallmentBuilder toInstallmentBuilder(PrestacaoDTO prestacao) {
		return new InstallmentBuilder()
				.withNoInterestInstallmentQuantity(null)
				.withQuantity(prestacao.getQuantidade())
				.withValue(prestacao.getValor());
	}

}
