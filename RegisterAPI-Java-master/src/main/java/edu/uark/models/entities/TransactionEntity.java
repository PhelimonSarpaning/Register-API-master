package edu.uark.models.entities;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import edu.uark.dataaccess.entities.BaseEntity;
import edu.uark.dataaccess.repository.DatabaseTable;
import edu.uark.models.api.Transaction;
import edu.uark.models.entities.fieldnames.TransactionFieldNames;

public class TransactionEntity extends BaseEntity<TransactionEntity> {
	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		this.id_cash = rs.getString(TransactionFieldNames.CASHIER_ID);
		this.sale_total = rs.getBigDecimal(TransactionFieldNames.TOTAL_SALES);
		this.id_trans = rs.getInt(TransactionFieldNames.TRANSACTION_ID);
		
		
	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		record.put(TransactionFieldNames.CASHIER_ID, this.id_cash);
		record.put(TransactionFieldNames.TOTAL_SALES, this.sale_total);
		record.put(TransactionFieldNames.TRANSACTION_ID, this.id_trans);
		//record.put(TransactionFieldNames.TIME_STAMP, this.time_stamp);
		//record.put(TransactionFieldNames.TIME, this.sale_time);
		
		//record.put(EmployeeFieldNames.COUNT, this.count);
		
		return record;
	}

	private String id_cash;
	public String getCashierId() {
		return this.id_cash;
	}
	public TransactionEntity setCashierId(String id_cash) {
		if (!StringUtils.equals(this.id_cash, id_cash)) {
			this.id_cash = id_cash;
			this.propertyChanged(TransactionFieldNames.CASHIER_ID);
		}
		
		return this;
	}
	
	private int id_trans;
	public int getTransactionId() {
		return this.id_trans;
	}
	public TransactionEntity setTransactionId(int id_trans) {
		if (this.id_trans != id_trans) {
			this.id_trans = id_trans;
			this.propertyChanged(TransactionFieldNames.TRANSACTION_ID);
		}
		
		return this;
	}
	
	private BigDecimal sale_total;
	public BigDecimal getTotalSales() {
		return this.sale_total;
	}
	public TransactionEntity setTotalSales(BigDecimal bigDecimal) {
		if (this.sale_total != bigDecimal) {
			this.sale_total = bigDecimal;
			this.propertyChanged(TransactionFieldNames.TOTAL_SALES);
		}
		
		return this;
	}
	

//	private int count;
//	public int getCount() {
//		return this.count;
//	}
//	public ProductEntity setCount(int count) {
//		if (this.count != count) {
//			this.count = count;
//			this.propertyChanged(ProductFieldNames.COUNT);
//		}
//		
//		return this;
//	}
//	
	public Transaction synchronize(Transaction apiTransaction) {
		this.setCashierId(apiTransaction.getCashierId());
		apiTransaction.setId(this.getId());
		apiTransaction.setTimeStamp(this.getCreatedOn());
		this.setTotalSales(apiTransaction.getTotalSales());
		this.setTransactionId(apiTransaction.getTransactionId());
		
		
		//apiEmployee.setId(this.getId());
		apiTransaction.setTimeStamp(this.getCreatedOn());// same as getStamp() in other functions
		
		return apiTransaction;
	}
	
	public TransactionEntity() {
		super(DatabaseTable.TRANSACTION_LIST);
		
		//this.count = -1;
		this.id_cash = StringUtils.EMPTY;
		this.sale_total = new BigDecimal(1);
		this.id_trans = -1;
		

		
	}
	
	public TransactionEntity(Transaction apiTransaction) {
		super(DatabaseTable.TRANSACTION_LIST);
		
		this.id_cash = apiTransaction.getCashierId();
		this.id_trans = apiTransaction.getTransactionId();
		this.sale_total = apiTransaction.getTotalSales();
		
	}
}
