package com.pagseguro.checkout.domain.component;

import org.springframework.stereotype.Component;

import com.pagseguro.checkout.domain.model.dto.TelefoneDTO;

import br.com.uol.pagseguro.api.common.domain.builder.PhoneBuilder;

@Component
public class TelefoneComponent {
	
	public PhoneBuilder toPhoneBuilder(TelefoneDTO telefone) {
		return new PhoneBuilder()
				.withAreaCode(telefone.getCodigoArea())
				.withNumber(telefone.getNumero());
	}

}
