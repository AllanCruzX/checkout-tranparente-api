package com.pagseguro.checkout.api.assembler;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pagseguro.checkout.api.model.input.TransacaoModel;

import br.com.uol.pagseguro.api.common.domain.DataList;
import br.com.uol.pagseguro.api.transaction.search.TransactionDetail;
import br.com.uol.pagseguro.api.transaction.search.TransactionSummary;

@Component
public class TransacaoModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	public TransacaoModel toModel (TransactionSummary transactionSummary) {
		
		return modelMapper.map(transactionSummary, TransacaoModel.class);
		
	}
	
	
	public TransacaoModel toModel (TransactionDetail transactionDetail) {
		
		return modelMapper.map(transactionDetail, TransacaoModel.class);
		
	}
	
	
	public List<TransacaoModel>  toCollectionModel(DataList<? extends TransactionSummary> transactios){
		
		List<TransacaoModel> listModel = new ArrayList<TransacaoModel>();
		
		for(TransactionSummary transaction : transactios) {
			listModel.add(toModel(transaction));
		}
		
		return listModel;
	
	}
	

}
