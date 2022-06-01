package com.pagseguro.checkout.api.model.input;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CompradorModel {
	
	@NotBlank
	@ApiModelProperty(example = "4546561545")
	private String hashComprador;
	
	@NotBlank
	@ApiModelProperty(example = "Carlos SIlva")
	private String nome;

	@NotBlank
	@ApiModelProperty(example = "01550936547")
	private String cpf;
	
	@NotBlank
	@ApiModelProperty(example = "20/06/1980")
	private String nascimento;
		
	private EnderecoModel endereco;
		
	private ContatoModel contato;

}
