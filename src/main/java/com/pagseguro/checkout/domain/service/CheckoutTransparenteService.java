package com.pagseguro.checkout.domain.service;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pagseguro.checkout.domain.component.CartaoCreditoComponent;
import com.pagseguro.checkout.domain.component.PagamentoComponent;
import com.pagseguro.checkout.domain.exception.NegocioException;
import com.pagseguro.checkout.domain.exception.TransacaoAbortadaException;
import com.pagseguro.checkout.domain.model.dto.PagamentoDTO;
import com.pagseguro.checkout.domain.model.dto.SessaoDTO;

import br.com.uol.pagseguro.api.PagSeguro;
import br.com.uol.pagseguro.api.common.domain.DataList;
import br.com.uol.pagseguro.api.common.domain.builder.DateRangeBuilder;
import br.com.uol.pagseguro.api.exception.PagSeguroBadRequestException;
import br.com.uol.pagseguro.api.transaction.register.DirectPaymentRegistrationBuilder;
import br.com.uol.pagseguro.api.transaction.search.TransactionDetail;
import br.com.uol.pagseguro.api.transaction.search.TransactionSummary;

@Service
public class CheckoutTransparenteService {

	@Autowired
	private PagSeguro pagSeguro;

	@Autowired
	private CartaoCreditoComponent cartaoCreditoComponent;

	@Autowired
	private PagamentoComponent pagamentoComponent;

	 /**
     * Método que que gera sessão
     * @return String
     * @author Allan Cruz (tqi_arosa@uolinc.com)
     * @since 13 de julho de 2021
     */
	public String getSessao() {

		String id = null;
		try {
			SessaoDTO sessao = new SessaoDTO();
			sessao.setId(pagSeguro.sessions().create().getId());

			ObjectMapper mapper = new ObjectMapper();

			id = mapper.writeValueAsString(sessao);

		} catch (JsonProcessingException e) {
			new NegocioException("Erro ao pegar id da sessao");
		}

		return id;
	}
	
	
	 /**
     * Método que faz o heckout transparente (pagamento direto) com cartao de credito
     * @param PagamentoDTO - DTO com informações do pagamento
     * @return Void
     * @author Allan Cruz (tqi_arosa@uolinc.com)
     * @since @since 13 de julho de 2021
     */
    public TransactionDetail criarTransacaoTransparentePorCartaoDeCredito(PagamentoDTO pagamentoDTO) throws TransacaoAbortadaException {
    	
    		TransactionDetail creditCardTransaction = null;
    		
        try{
            DirectPaymentRegistrationBuilder directPayment = pagamentoComponent.toDirectPaymentRegistrationBuilder(pagamentoDTO);
                     creditCardTransaction = pagSeguro.transactions()
                    .register(directPayment)
                    .withCreditCard(
                            cartaoCreditoComponent.toCreditCardBuilder(pagamentoDTO.getCartaoCredito()));
                    
            System.out.println(creditCardTransaction);

        } catch (Exception e){
            e.printStackTrace();
            throw new TransacaoAbortadaException(e.getMessage(), e.getCause());
        }
		return creditCardTransaction;
    }
    
    /**
     * Método que lista todas as transações 
     * @return  DataList<? extends TransactionSummary> - que vem da biblioteca da PagSeguro
     * @author Allan Cruz (tqi_arosa@uolinc.com)
     * @since @since 13 de julho de 2021
     */
    public DataList<? extends TransactionSummary> buscarTransacoesPorDatas() throws TransacaoAbortadaException {
        try {
    		
            final int pagina = 1;
            final int maxResultados = 10;
            
            LocalDateTime ldataInicial  = LocalDateTime.of(2021 , Month.JULY , 1 ,19, 18);
            LocalDateTime ldataFinal  = LocalDateTime.of(2021 , Month.JULY , 21 ,10, 1);
            
            Date dataInicial = Date.from(ldataInicial.atZone(ZoneId.systemDefault()).toInstant());
            Date dataFinal = Date.from(ldataFinal.atZone(ZoneId.systemDefault()).toInstant());
            
            System.out.println("Data inicial ->"+dataInicial.toString());
            
            System.out.println("Data final ->"+dataFinal.toString());
            
    	      
            final DataList<? extends TransactionSummary> transacoes =
                    pagSeguro.transactions().search().byDateRange(
                            new DateRangeBuilder().between(dataInicial, dataFinal), pagina, maxResultados);
            System.out.println(transacoes.size());
            System.out.println(transacoes);
            
            
            
            return transacoes;
        }catch (Exception e) {
            e.printStackTrace();
            throw new TransacaoAbortadaException(e.getMessage(), e.getCause());
        }
    }
    
    
    /**
     * Método busca transação
     * @param codigoTransacao
     * @return  TransactionDetail - que vem da biblioteca da PagSeguro
     * @author Allan Cruz (tqi_arosa@uolinc.com)
     * @since @since 13 de julho de 2021
     */
    public TransactionDetail buscarTransacaoPorCodigo(String codigoTransacao) throws TransacaoAbortadaException {
        try {
            TransactionDetail transaction = pagSeguro.transactions().search().byCode(codigoTransacao);
            return transaction;
        }catch (PagSeguroBadRequestException e){        	    
            e.printStackTrace();
            throw new TransacaoAbortadaException(e.getMessage(), e.getCause());
        }
    }

}
