package com.pagseguro.checkout.domain.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pagseguro.checkout.domain.model.dto.RemetenteDTO;

import br.com.uol.pagseguro.api.common.domain.builder.SenderBuilder;

@Component
public class RemetenteComponent {
	
	@Autowired
	private TelefoneComponent telefoneComponent;
	
	public SenderBuilder toSenderBuilder(RemetenteDTO remetente) {
		
		return new  SenderBuilder()
				.withEmail(remetente.getEmail())
				.withName(remetente.getNome())
				.withCPF(remetente.getCpf())
				.withHash(remetente.getHash())
				.withPhone(
						telefoneComponent.toPhoneBuilder(remetente.getTelefone()));
	}

}
