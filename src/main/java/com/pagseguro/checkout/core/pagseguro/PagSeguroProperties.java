package com.pagseguro.checkout.core.pagseguro;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "credencial")
public class PagSeguroProperties {
	
	private String sellerEmail;
    private String sellerToken;
    private String referenceLibJava;

}
