package com.pagseguro.checkout.domain.component;

import org.springframework.stereotype.Component;

import com.pagseguro.checkout.domain.model.dto.EnderecoDTO;

import br.com.uol.pagseguro.api.common.domain.builder.AddressBuilder;

@Component
public class EnderecoComponent {
	
	public AddressBuilder toAddressBuilder(EnderecoDTO endereco) {
		return new AddressBuilder()
				.withPostalCode(endereco.getCodigoPostal())
				.withCountry(endereco.getPais())
				.withState(endereco.getEstado())
				.withCity(endereco.getCidade())
				.withComplement(endereco.getComplemento())
				.withDistrict(endereco.getDistrito())
				.withNumber(endereco.getNumero())
				.withStreet(endereco.getRua());
	}

}
