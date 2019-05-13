package edu.uark.models.api;
import java.math.BigDecimal;
///////This file is in charge of pulling stuff from the employee database
import java.time.LocalDateTime;
//import java.util.UUID;
import java.util.UUID;

import edu.uark.models.entities.ItemEntity;
//import org.apache.commons.codec.digest.DigestUtils;

public class Item {
	private UUID id;
	public UUID getId() {
		return this.id;
	}
	public Item setId(UUID id) {
		this.id = id;
		return this;
	}
	
	private String product_name;
	public String getProductName() {
		return this.product_name;
	}
	public Item setProductName(String product_name) {
		this.product_name = product_name;
		return this;
	}
	
	private String quantity;
	public String getQuantity() {
		return this.quantity;
	}
	public Item setQuantity(String quantity) {
		this.quantity = quantity;
		return this;
	}
	
	private int id_trans;
	public int getTransactionId() {
		return this.id_trans;
	}
	public Item setTransactionId(int id_trans) {
		this.id_trans = id_trans;
		return this;
	}

	
	private BigDecimal total;
	public BigDecimal getTotal() {
		return this.total;
	}
	public Item setTotal(BigDecimal total) {
		this.total = total;
		return this;
	}
	
	
	
	private LocalDateTime time_stamp;
	public LocalDateTime getTimeStamp() {
		return this.time_stamp;
	}
	public Item setTimeStamp(LocalDateTime time_stamp) {
		this.time_stamp = time_stamp;
		return this;
	}
	
	
	
	public Item() {
		this.product_name =" ";
		this.quantity =" ";
		this.total = new BigDecimal(1);
		this.id_trans= 0;
		this.id = new UUID(0, 0);
		this.time_stamp = LocalDateTime.now();
		

	}
	
	public Item(ItemEntity itemEntity) {
		//System.out.println("This is the transaction id" + this.id_tran);
		this.id = itemEntity.getId();
		//System.out.println("This is the transaction id" + this.id_tran);
		this.product_name = itemEntity.getProductName();
		this.id_trans = itemEntity.getTransactionId();
		this.total = itemEntity.getTotal();
		this.quantity = itemEntity.getQuantity();
		
	}
}
