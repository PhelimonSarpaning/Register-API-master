package edu.uark.models.api;
import java.math.BigDecimal;
///////This file is in charge of pulling stuff from the employee database
import java.time.LocalDateTime;
//import java.util.UUID;
import java.util.UUID;

import edu.uark.models.entities.TransactionEntity;
//import org.apache.commons.codec.digest.DigestUtils;

public class Transaction {
	private UUID id;
	public UUID getId() {
		return this.id;
	}
	public Transaction setId(UUID id) {
		this.id = id;
		return this;
	}
	
	private String id_cash;
	public String getCashierId() {
		return this.id_cash;
	}
	public Transaction setCashierId(String id_cash) {
		this.id_cash = id_cash;
		return this;
	}
	
	private int id_trans;
	public int getTransactionId() {
		return this.id_trans;
	}
	public Transaction setTransactionId(int id_trans) {
		this.id_trans = id_trans;
		return this;
	}

	
	private BigDecimal sale_total;
	public BigDecimal getTotalSales() {
		return this.sale_total;
	}
	public Transaction setTotalSales(BigDecimal sale_total) {
		this.sale_total = sale_total;
		return this;
	}
	
	
	
	private LocalDateTime time_stamp;
	public LocalDateTime getTimeStamp() {
		return this.time_stamp;
	}
	public Transaction setTimeStamp(LocalDateTime time_stamp) {
		this.time_stamp = time_stamp;
		return this;
	}
	
	
	
	public Transaction() {
		this.id_cash =" ";
		this.sale_total = new BigDecimal(0);
		this.id_trans=0;
		this.id = new UUID(0, 0);
		this.time_stamp = LocalDateTime.now();
		

	}
	
	public Transaction(TransactionEntity transactionEntity) {
		//System.out.println("This is the transaction id" + this.id_tran);
		this.id = transactionEntity.getId();
		//System.out.println("This is the transaction id" + this.id_tran);
		this.id_cash = transactionEntity.getCashierId();
		this.id_trans = transactionEntity.getTransactionId();
		this.sale_total = transactionEntity.getTotalSales();
		this.time_stamp = transactionEntity.getCreatedOn();
		
	}
}
