package com.pagseguro.checkout.domain.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pagseguro.checkout.domain.model.dto.DocumentoTitularDTO;
import com.pagseguro.checkout.domain.model.dto.TitularDTO;

import br.com.uol.pagseguro.api.common.domain.builder.HolderBuilder;

@Component
public class TitularComponent {
	
	
	@Autowired
	private TelefoneComponent telefoneComponent;
	
	@Autowired
	private DocumentoTitularComponent documentoTitularComponent;

	public HolderBuilder toHolderBuilder(TitularDTO titular) {
		 
		HolderBuilder holder;
		holder = new HolderBuilder()
				.withName(titular.getNome())
				.withPhone(
						telefoneComponent.toPhoneBuilder(titular.getTelefone()));
		
		holder.withBithDate(titular.getDataAniversario());
//		try {
//			holder.withBithDate(new SimpleDateFormat("dd/MM/yyyy").parse(titular.getDataAniversario().toString()));
//		} catch (ParseException e) {
//
//			e.printStackTrace();
//		}
         
		List<DocumentoTitularDTO> documentos = titular.getDocumentos();
		documentos.forEach(d -> {
			holder.addDocument(
					documentoTitularComponent.toDocumentBuilder(d));
		});
         
		return holder;
	}

}
