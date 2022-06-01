package com.pagseguro.checkout.api.model.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoModel {
	
	@NotNull
	@ApiModelProperty(example = "1")
	private Long id;
	
	@NotBlank
	@ApiModelProperty(example = "Mouse")
	private String descricao;
	
	@NotNull
	@ApiModelProperty(example = "100")
	private int preco;
	

}
