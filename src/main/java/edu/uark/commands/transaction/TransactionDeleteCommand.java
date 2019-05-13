package edu.uark.commands.transaction;

import java.util.UUID;

import edu.uark.commands.VoidCommandInterface;
import edu.uark.controllers.exceptions.NotFoundException;
import edu.uark.models.entities.TransactionEntity;
import edu.uark.models.repositories.TransactionRepository;
import edu.uark.models.repositories.interfaces.TransactionRepositoryInterface;

public class TransactionDeleteCommand implements VoidCommandInterface {
	@Override
	public void execute() {
		TransactionEntity transactionEntity = this.transactionRepository.get(this.transactionId);
		if (transactionEntity == null) { //No record with the associated record ID exists in the database.
			throw new NotFoundException("Transaction");
		}
		
		transactionEntity.delete();
	}

	//Properties
	private UUID transactionId;
	public UUID getTransactiontId() {
		return this.transactionId;
	}
	public TransactionDeleteCommand setTransactionId(UUID transactionId) {
		this.transactionId = transactionId;
		return this;
	}
	
	private TransactionRepositoryInterface transactionRepository;
	public TransactionRepositoryInterface getTransactionRepository() {
		return this.transactionRepository;
	}
	public TransactionDeleteCommand setTransactionRepository(TransactionRepositoryInterface transactionRepository) {
		this.transactionRepository = transactionRepository;
		return this;
	}
	
	public TransactionDeleteCommand() {
		this.transactionRepository = new TransactionRepository();
	}
}
