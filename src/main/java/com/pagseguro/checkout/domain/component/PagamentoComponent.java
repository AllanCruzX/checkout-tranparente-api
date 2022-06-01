package com.pagseguro.checkout.domain.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pagseguro.checkout.core.pagseguro.PagSeguroProperties;
import com.pagseguro.checkout.domain.model.dto.PagamentoDTO;
import com.pagseguro.checkout.domain.model.dto.ProdutoDTO;

import br.com.uol.pagseguro.api.transaction.register.DirectPaymentRegistrationBuilder;

@Component
public class PagamentoComponent {
	
	@Autowired
    private PagSeguroProperties properties;
	
	@Autowired
	private RemetenteComponent remetenteComponent;
	
	@Autowired
	private RemessaComponent remessaComponent;
	
	@Autowired
	private ProdutoComponent produtoComponent;
	
	@SuppressWarnings("static-access")
	public DirectPaymentRegistrationBuilder toDirectPaymentRegistrationBuilder(PagamentoDTO pagamento) {
			
		DirectPaymentRegistrationBuilder directPayment = new DirectPaymentRegistrationBuilder()
				.withPaymentMode("default")
				.withCurrency(pagamento.getMoeda())
				.withExtraAmount(pagamento.getPrecoExtra())
				.withReference(properties.getReferenceLibJava())
				.withSender(
						remetenteComponent.toSenderBuilder(pagamento.getRemetente()))
				.withShipping(
						remessaComponent.toShippingBuilder(pagamento.getRemessa()));
		          
		          
		List<ProdutoDTO> produtos = pagamento.getProdutos();
  
		produtos.forEach(p -> {
			directPayment.addItem(
					produtoComponent.toPaymentItemBuilder(p));
		});
  
		return directPayment;
	}

}
