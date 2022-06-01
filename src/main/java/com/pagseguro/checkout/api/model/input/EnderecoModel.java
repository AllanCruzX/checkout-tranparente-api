package com.pagseguro.checkout.api.model.input;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoModel {
	
	@ApiModelProperty(example = "Rua Geraldo")
	@NotBlank
	private String logradouro;
	
	@NotBlank
	@ApiModelProperty(example = "10")
	private String numero;
	
	@NotBlank
	@ApiModelProperty(example = "IAPI")
	private String bairro;
	
	@NotBlank
	@ApiModelProperty(example = "45369")
	private String cep;
	
	@NotBlank
	@ApiModelProperty(example = "Salvador")
	private String cidade;
	
	@NotBlank
	@ApiModelProperty(example = "Ba")
	private String estado;

}
