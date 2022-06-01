package com.pagseguro.checkout.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pagseguro.checkout.api.assembler.TransacaoModelAssembler;
import com.pagseguro.checkout.api.converter.DadosConverter;
import com.pagseguro.checkout.api.exceptionhandler.Problem;
import com.pagseguro.checkout.api.model.input.PagamentoModel;
import com.pagseguro.checkout.api.model.input.TransacaoModel;
import com.pagseguro.checkout.domain.exception.TransacaoAbortadaException;
import com.pagseguro.checkout.domain.model.dto.PagamentoDTO;
import com.pagseguro.checkout.domain.service.CheckoutTransparenteService;

import br.com.uol.pagseguro.api.common.domain.DataList;
import br.com.uol.pagseguro.api.transaction.search.TransactionDetail;
import br.com.uol.pagseguro.api.transaction.search.TransactionSummary;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Checkout Transparente")
@RestController
@RequestMapping(path = "/checkouts", produces = MediaType.APPLICATION_JSON_VALUE)
public class CheckoutTranparenteController {

	@Autowired
	private CheckoutTransparenteService checkoutTransparenteService;

	@Autowired
	private DadosConverter dadosConverter;
	
	@Autowired
	private TransacaoModelAssembler transacaoModelAssembler;


	@ApiOperation("Gera uma nova sessão")
	@GetMapping("/transparente/session")
	public String getSessionId() {
		return checkoutTransparenteService.getSessao();

	}

	@ApiOperation("Pagamento com cartão de crédito")
	@ApiResponses({ @ApiResponse(code = 201, message = "Pagamento realizado com sucesso"), })
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/transparente/cartao-credito")
	public TransacaoModel realizarTransacaoTransparenteCartaoCredito(
			@ApiParam(name = "corpo", value = "Representação de um pagamento por cartão de crédito ", required = true) @RequestBody PagamentoModel pagamentoModel)
			throws TransacaoAbortadaException {

		PagamentoDTO pagamentoDTO = dadosConverter.converter(pagamentoModel);
		
		TransactionDetail creditCardTransaction = checkoutTransparenteService.criarTransacaoTransparentePorCartaoDeCredito(pagamentoDTO);
				
		return  transacaoModelAssembler.toModel(creditCardTransaction);
	}

	@ApiOperation("Listar transações")
	@GetMapping(value = "/transacoes")
	public List<TransacaoModel> buscarTransacoes()
			throws TransacaoAbortadaException {
		
		DataList<? extends TransactionSummary> listaTransacoes = checkoutTransparenteService.buscarTransacoesPorDatas();
		
		return transacaoModelAssembler.toCollectionModel(listaTransacoes);
	}
	
	@ApiOperation("Buscar transação por código ")
	@ApiResponses({
		@ApiResponse(code = 400, message = "código da transação inválido", response = Problem.class),
		@ApiResponse(code = 404, message = "transação não encontrada", response = Problem.class)
	})
	@GetMapping(value = "/transacoes/{codigo}")
	public TransacaoModel buscarTransacao(@ApiParam(value = "código de uma transação", example = "7C971270-2D22-43B6-B9C4-E5F6E4D05FCE", required = true) @PathVariable String codigo)
			throws TransacaoAbortadaException {
		
		TransactionDetail transacao = checkoutTransparenteService.buscarTransacaoPorCodigo(codigo);
		
		return  transacaoModelAssembler.toModel(transacao);
	}

}
