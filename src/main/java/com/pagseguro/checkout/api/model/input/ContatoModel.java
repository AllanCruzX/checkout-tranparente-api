package com.pagseguro.checkout.api.model.input;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ContatoModel {
	
	@NotBlank
	@ApiModelProperty(example = "(71)985541")
	private String telefone;
	
	@NotBlank
	@ApiModelProperty(example = "teste@pagseguro.com.br")
	private String email;

}
