package com.pagseguro.checkout.domain.exception;

public class TransacaoAbortadaException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	

	public TransacaoAbortadaException(String mensagem) {
        super(mensagem);
    }

    public TransacaoAbortadaException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
