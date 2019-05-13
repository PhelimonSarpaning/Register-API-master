package edu.uark.models.repositories;

import java.sql.SQLException;

import edu.uark.dataaccess.repository.BaseRepository;
import edu.uark.dataaccess.repository.DatabaseTable;
import edu.uark.dataaccess.repository.helpers.PostgreFunctionType;
import edu.uark.dataaccess.repository.helpers.SQLComparisonType;
import edu.uark.dataaccess.repository.helpers.where.WhereClause;
import edu.uark.dataaccess.repository.helpers.where.WhereContainer;
import edu.uark.models.entities.ItemEntity;
import edu.uark.models.entities.fieldnames.ItemFieldNames;
import edu.uark.models.repositories.interfaces.ItemRepositoryInterface;

public class ItemRepository extends BaseRepository<ItemEntity> implements ItemRepositoryInterface {
	@Override
	public ItemEntity byTransactionId(int transactionId) { 
		System.out.println("I have reached here");
		return this.firstOrDefaultWhere(
			new WhereContainer(
				(new WhereClause()).
					postgreFunction(PostgreFunctionType.LOWER).
					table(this.primaryTable).
					fieldName(ItemFieldNames.TRANSACTION_ID).
					comparison(SQLComparisonType.EQUALS)
			),
			(ps) -> {
				try {
					ps.setObject(1, transactionId);
				} catch (SQLException e) {}

				return ps;
			}
		);
	}
	
	@Override
	public ItemEntity createOne() {
		return new ItemEntity();
	}
	
	public ItemRepository() {
		super(DatabaseTable.RECEIPT);
	}
}
/*
	@Override
	public EmployeeEntity byEmployeePassword(String employeePassword) {
		return this.firstOrDefaultWhere(
				new WhereContainer(
					(new WhereClause()).
						postgreFunction(PostgreFunctionType.LOWER).
						table(this.primaryTable).
						fieldName(EmployeeFieldNames.PASSWORD).
						comparison(SQLComparisonType.EQUALS)
				),
				(ps) -> {
					try {
						ps.setObject(1, employeePassword.toLowerCase());
					} catch (SQLException e) {}

					return ps;
				}
			);
	}
}
*/