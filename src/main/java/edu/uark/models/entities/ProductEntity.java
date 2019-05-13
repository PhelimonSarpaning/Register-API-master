package edu.uark.models.entities;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import edu.uark.dataaccess.entities.BaseEntity;
import edu.uark.dataaccess.repository.DatabaseTable;
import edu.uark.models.api.Product;
import edu.uark.models.entities.fieldnames.ProductFieldNames;
import edu.uark.models.entities.fieldnames.TransactionFieldNames;

public class ProductEntity extends BaseEntity<ProductEntity> {
	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		this.lookupCode = rs.getString(ProductFieldNames.LOOKUP_CODE);
		this.count = rs.getInt(ProductFieldNames.COUNT);
		this.price=rs.getBigDecimal(ProductFieldNames.PRICE);
	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		record.put(ProductFieldNames.LOOKUP_CODE, this.lookupCode);
		record.put(ProductFieldNames.COUNT, this.count);
		record.put(ProductFieldNames.PRICE, this.price);
		
		return record;
	}

	private String lookupCode;
	public String getLookupCode() {
		return this.lookupCode;
	}
	public ProductEntity setLookupCode(String lookupCode) {
		if (!StringUtils.equals(this.lookupCode, lookupCode)) {
			this.lookupCode = lookupCode;
			this.propertyChanged(ProductFieldNames.LOOKUP_CODE);
		}
		
		return this;
	}

	private int count;
	public int getCount() {
		return this.count;
	}
	public ProductEntity setCount(int count) {
		if (this.count != count) {
			this.count = count;
			this.propertyChanged(ProductFieldNames.COUNT);
		}
		
		return this;
	}
	
	private BigDecimal price;
	public BigDecimal getPrice() {
		return this.price;
	}
	public ProductEntity setPrice(BigDecimal price) {
		if (this.price != price) {
			this.price = price;
			this.propertyChanged(ProductFieldNames.PRICE);
		}
		
		return this;
	}
	
	public Product synchronize(Product apiProduct) {
		this.setCount(apiProduct.getCount());
		this.setLookupCode(apiProduct.getLookupCode());
		this.setPrice(apiProduct.getPrice());
		apiProduct.setId(this.getId());
		apiProduct.setCreatedOn(this.getCreatedOn());
		
		return apiProduct;
	}
	
	public ProductEntity() {
		super(DatabaseTable.PRODUCT);
		
		this.count = -1;
		//System.out.println("the price for this is " + new BigDecimal("0.00"));
		this.price = new BigDecimal(1);
		
		this.lookupCode = StringUtils.EMPTY;
	}
	
	public ProductEntity(Product apiProduct) {
		super(DatabaseTable.PRODUCT);
		
		this.count = apiProduct.getCount();
		this.price = apiProduct.getPrice();
		this.lookupCode = apiProduct.getLookupCode();
	}
}















