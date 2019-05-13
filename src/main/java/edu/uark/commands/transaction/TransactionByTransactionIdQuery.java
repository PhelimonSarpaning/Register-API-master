package edu.uark.commands.transaction;	

 import org.apache.commons.lang3.StringUtils;	

 import edu.uark.commands.ResultCommandInterface;	
import edu.uark.controllers.exceptions.NotFoundException;	
import edu.uark.controllers.exceptions.UnprocessableEntityException;	
import edu.uark.models.api.Transaction;	
import edu.uark.models.entities.TransactionEntity;	
import edu.uark.models.repositories.TransactionRepository;	
import edu.uark.models.repositories.interfaces.TransactionRepositoryInterface;	
//add some few things	
public class TransactionByTransactionIdQuery implements ResultCommandInterface<Transaction> {	
	@Override	
	public Transaction execute() {	
		if (StringUtils.isBlank(String.valueOf(this.transactionId))){	
			throw new UnprocessableEntityException("transactionid");	
		}	

 		TransactionEntity transactionEntity = this.transactionRepository.byTransactionId(this.transactionId);	
		if (transactionEntity != null) {	
			return new Transaction(transactionEntity);	
		} else {	
			throw new NotFoundException("Transaction");	
		}	
	}	

 	//Properties	
	private int transactionId;	
	public int getid_transaction() {	
		return this.transactionId;	
	}	
	public TransactionByTransactionIdQuery setid_transaction(int transactionId) {	
		this.transactionId = transactionId;	
		return this;	
	}	

 	private TransactionRepositoryInterface transactionRepository;	
	public TransactionRepositoryInterface getTransactionRepository() {	
		return this.transactionRepository;	
	}	
	public TransactionByTransactionIdQuery setTransactionRepository(TransactionRepositoryInterface transactionRepository) {	
		this.transactionRepository = transactionRepository;	
		return this;	
	}	

 	public TransactionByTransactionIdQuery() {	
		this.transactionRepository = new TransactionRepository();	
	}	
}	
