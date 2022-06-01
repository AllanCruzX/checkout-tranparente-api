package com.pagseguro.checkout.core.pagseguro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.uol.pagseguro.api.PagSeguro;
import br.com.uol.pagseguro.api.PagSeguroEnv;
import br.com.uol.pagseguro.api.credential.Credential;
import br.com.uol.pagseguro.api.http.JSEHttpClient;
import br.com.uol.pagseguro.api.utils.logging.SimpleLoggerFactory;

@Configuration
public class PagSeguroConfig {
	    
    @Autowired
    private PagSeguroProperties properties;
    
    @Bean
	public PagSeguro getPagSeguro() {
		return PagSeguro
                .instance(new SimpleLoggerFactory(), new JSEHttpClient(),
                    Credential.sellerCredential(properties.getSellerEmail(), properties.getSellerToken()), PagSeguroEnv.SANDBOX);
	}

}
