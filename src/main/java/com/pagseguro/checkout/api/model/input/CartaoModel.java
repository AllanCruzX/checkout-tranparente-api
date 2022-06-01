package com.pagseguro.checkout.api.model.input;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartaoModel {
	
	
	@NotBlank
	@ApiModelProperty(example = "4111111")
	private String numCard;
	
	@NotBlank
	@ApiModelProperty(example = "12")
	private String mesValidadeCard;
	
	@NotBlank
	@ApiModelProperty(example = "2026")
	private String anoValidadeCard;
	
	@NotBlank
	@ApiModelProperty(example = "013")
	private String codSegCard;
	
	@NotBlank
	@ApiModelProperty(example = "Visa")
	private String bandCard;
	
	@NotBlank
	@ApiModelProperty(example = "48749694979497498748")
	private String hashCard;

}
