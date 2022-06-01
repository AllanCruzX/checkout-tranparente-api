package com.pagseguro.checkout.api.model.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagamentoModel {
	
	@NotNull
	@ApiModelProperty(example = "1")
	private Long id;
		
	@NotBlank
	@ApiModelProperty(example = "1")
	private  int parcelaQuantidade;
	
	@NotBlank
	@ApiModelProperty(example = "100.00")
	private  int parcelaValor;
	
	@NotNull
	@ApiModelProperty(example = "1")
	private Long produtoId;
	
	private CartaoModel cartao;
		
	private CompradorModel comprador; 

}
