package com.pagseguro.checkout.api.model.input;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransacaoModel {
	
	@ApiModelProperty(example = "7C971270-2D22-43B6-B9C4-E5F6E4D05FCE")
	private String code;
	
	@ApiModelProperty(example = "Mon Jul 12 21:50:20 UTC 2021")
	private String date;
	
	@ApiModelProperty(example = "Gabrial Fernandes")
	private String detailSenderName;
	
	@ApiModelProperty(example = "110")
	private int grossAmount;

}
