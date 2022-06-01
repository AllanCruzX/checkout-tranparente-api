package com.pagseguro.checkout.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pagseguro.checkout.api.assembler.ProdutoModelAssembler;
import com.pagseguro.checkout.api.exceptionhandler.Problem;
import com.pagseguro.checkout.api.model.input.ProdutoModel;
import com.pagseguro.checkout.domain.model.dto.ProdutoDTO;
import com.pagseguro.checkout.domain.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Produtos")
@RestController
@RequestMapping(path = "/produtos", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ProdutoModelAssembler produtoModelAssembler;

	@ApiOperation("Listar produtos")
	@GetMapping
	public List<ProdutoModel> listarProdutos() {

		List<ProdutoDTO> produtos = produtoRepository.listar();

		return produtoModelAssembler.toCollectionModel(produtos);
	}

	@ApiOperation("Buscar produto por código ")
	@ApiResponses({ @ApiResponse(code = 400, message = "código do produto inválido", response = Problem.class),
			@ApiResponse(code = 404, message = "produto não encontrada", response = Problem.class) })
	@GetMapping("/{codigo}")
	public ResponseEntity<ProdutoModel> buscarProduto(
			@ApiParam(value = "código do produto", example = "1", required = true) @PathVariable Long codigo) {

		ProdutoDTO produto = produtoRepository.buscarPorId(codigo);
		
		if(produto.getId() != null) {
			 return ResponseEntity.ok(produtoModelAssembler.toModel(produto));
		}
		
		return ResponseEntity.notFound().build();
	}

}
