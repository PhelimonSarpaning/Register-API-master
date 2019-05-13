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
import edu.uark.models.api.Item;
import edu.uark.models.entities.fieldnames.ItemFieldNames;

public class ItemEntity extends BaseEntity<ItemEntity> {
	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		this.id_trans = rs.getInt(ItemFieldNames.TRANSACTION_ID);
		this.total = rs.getBigDecimal(ItemFieldNames.TOTAL);
		this.product_name = rs.getString(ItemFieldNames.PRODUCT_NAME);
		this.quantity= rs.getString(ItemFieldNames.QUANTITY);
		
		
	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		record.put(ItemFieldNames.PRODUCT_NAME, this.product_name);
		record.put(ItemFieldNames.TOTAL, this.total);
		record.put(ItemFieldNames.TRANSACTION_ID, this.id_trans);
		record.put(ItemFieldNames.QUANTITY, this.quantity);
		//record.put(TransactionFieldNames.TIME_STAMP, this.time_stamp);
		//record.put(TransactionFieldNames.TIME, this.sale_time);
		
		//record.put(EmployeeFieldNames.COUNT, this.count);
		
		return record;
	}

	private String product_name;
	public String getProductName() {
		return this.product_name;
	}
	public ItemEntity setProductName(String product_name) {
		if (!StringUtils.equals(this.product_name, product_name)) {
			this.product_name = product_name;
			this.propertyChanged(ItemFieldNames.PRODUCT_NAME);
		}
		
		return this;
	}
	
	private int id_trans;
	public int getTransactionId() {
		return this.id_trans;
	}
	public ItemEntity setTransactionId(int id_trans) {
		if (this.id_trans != id_trans) {
			this.id_trans = id_trans;
			this.propertyChanged(ItemFieldNames.TRANSACTION_ID);
		}
		
		return this;
	}
	
	private BigDecimal total;
	public BigDecimal getTotal() {
		return this.total;
	}
	public ItemEntity setTotal(BigDecimal total) {
		if (this.total != total) {
			this.total = total;
			this.propertyChanged(ItemFieldNames.TOTAL);
		}
		
		return this;
	}
	
	private String quantity;
	public String getQuantity() {
		return this.quantity;
	}
	public ItemEntity setQuantity(String quantity) {
		if (!StringUtils.equals(this.quantity, quantity)) {
			this.quantity = quantity;
			this.propertyChanged(ItemFieldNames.QUANTITY);
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
	public Item synchronize(Item apiItem) {
		this.setTotal(apiItem.getTotal());
		apiItem.setId(this.getId());
		apiItem.setTimeStamp(this.getCreatedOn());
		this.setProductName(apiItem.getProductName());
		this.setQuantity(apiItem.getQuantity());
		this.setTransactionId(apiItem.getTransactionId());
		
		
		//apiEmployee.setId(this.getId());
		//apiTransaction.setTimeStamp(this.getCreatedOn());// same as getStamp() in other functions
		
		return apiItem;
	}
	
	public ItemEntity() {
		super(DatabaseTable.RECEIPT);
		
		//this.count = -1;
		this.quantity = StringUtils.EMPTY;
		this.product_name = StringUtils.EMPTY;
		this.total = new BigDecimal(1);
		this.id_trans = -1;
		

		
	}
	
	public ItemEntity(Item apiItem) {
		super(DatabaseTable.RECEIPT);
		
		this.product_name = apiItem.getProductName();
		this.id_trans = apiItem.getTransactionId();
		this.total =  apiItem.getTotal();
		this.quantity = apiItem.getQuantity();
		
	}
}
