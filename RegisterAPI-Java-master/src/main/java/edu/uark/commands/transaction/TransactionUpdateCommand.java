package edu.uark.commands.transaction;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.controllers.exceptions.NotFoundException;
import edu.uark.controllers.exceptions.UnprocessableEntityException;
import edu.uark.models.api.Transaction;
import edu.uark.models.entities.TransactionEntity;
import edu.uark.models.repositories.TransactionRepository;
import edu.uark.models.repositories.interfaces.TransactionRepositoryInterface;

public class TransactionUpdateCommand implements ResultCommandInterface<Transaction> {
	@Override
	public Transaction execute() {
		//Validations
		if (StringUtils.isBlank(String.valueOf(this.apiTransaction.getTransactionId()))) {
			throw new UnprocessableEntityException("transactionid");
		}

		TransactionEntity transactionEntity = this.transactionRepository.get(this.transactionId);
		if (transactionEntity == null) { //No record with the associated record ID exists in the database.
			throw new NotFoundException("Transaction");
		}
		
		this.apiTransaction = transactionEntity.synchronize(this.apiTransaction); //Synchronize any incoming changes for UPDATE to the database.
		
		transactionEntity.save(); //Write, via an UPDATE, any changes to the database.
		
		return this.apiTransaction;
	}

	//Properties
	private UUID transactionId;
	public UUID getTransactionId() {
		return this.transactionId;
	}
	public TransactionUpdateCommand setTransactionId(UUID transactionId) {
		this.transactionId = transactionId;
		return this;
	}
	
	private Transaction apiTransaction;
	public Transaction getApiTransaction() {
		return this.apiTransaction;
	}
	public TransactionUpdateCommand setApiTransaction(Transaction apiTransaction) {
		this.apiTransaction = apiTransaction;
		return this;
	}
	
	private TransactionRepositoryInterface transactionRepository;
	public TransactionRepositoryInterface getTransactionRepository() {
		return this.transactionRepository;
	}
	public TransactionUpdateCommand setTransactionRepository(TransactionRepositoryInterface transactionRepository) {
		this.transactionRepository = transactionRepository;
		return this;
	}
	
	public TransactionUpdateCommand() {
		this.transactionRepository = new TransactionRepository();
	}
}
