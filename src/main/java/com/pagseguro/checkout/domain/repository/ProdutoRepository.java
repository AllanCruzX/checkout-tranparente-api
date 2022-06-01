package com.pagseguro.checkout.domain.repository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.pagseguro.checkout.domain.model.dto.ProdutoDTO;

@Repository
public class ProdutoRepository {
	
	public List<ProdutoDTO> listar(){
		
		ProdutoDTO mouse = ProdutoDTO.builder()
				.id(1L)
				.descricao("Mouse")
				.peso(1)
				.preco(new BigDecimal ("100.00"))
				.quantidade(1)
				.build();
		
		ProdutoDTO teclado = ProdutoDTO.builder()
				.id(2L)
				.descricao("Teclado")
				.peso(1)
				.preco(new BigDecimal ("200.00"))
				.quantidade(1)
				.build();
		
		return Arrays.asList(mouse, teclado);
		
	}
	
	public ProdutoDTO buscarPorId (Long id) {
		
		List<ProdutoDTO> produtos = listar();
		
		ProdutoDTO produto = new ProdutoDTO();
		
		produtos.forEach(produtoAtual -> {
			
			if(produtoAtual.getId().equals(id)) {
				
				 BeanUtils.copyProperties(produtoAtual, produto);
				
			}
			
		});
		
		return produto;
		
	}

}
