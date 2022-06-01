package com.pagseguro.checkout.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pagseguro.checkout.api.model.input.ProdutoModel;
import com.pagseguro.checkout.domain.model.dto.ProdutoDTO;

@Component
public class ProdutoModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	public ProdutoModel toModel (ProdutoDTO produtoDTO) {
		
		return modelMapper.map(produtoDTO, ProdutoModel.class);
		
	}

	public List<ProdutoModel> toCollectionModel(List<ProdutoDTO> produtos) {
		return produtos.stream()
				.map(produto -> toModel(produto))
				.collect(Collectors.toList());
	}
	

}
