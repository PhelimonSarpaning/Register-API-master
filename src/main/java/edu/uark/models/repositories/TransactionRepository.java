package edu.uark.models.repositories;

import java.sql.SQLException;

import edu.uark.dataaccess.repository.BaseRepository;
import edu.uark.dataaccess.repository.DatabaseTable;
import edu.uark.dataaccess.repository.helpers.PostgreFunctionType;
import edu.uark.dataaccess.repository.helpers.SQLComparisonType;
import edu.uark.dataaccess.repository.helpers.where.WhereClause;
import edu.uark.dataaccess.repository.helpers.where.WhereContainer;
import edu.uark.models.entities.TransactionEntity;
import edu.uark.models.entities.fieldnames.TransactionFieldNames;
import edu.uark.models.repositories.interfaces.TransactionRepositoryInterface;

public class TransactionRepository extends BaseRepository<TransactionEntity> implements TransactionRepositoryInterface {
	@Override
	public TransactionEntity byTransactionId(int transactionId) { 
		System.out.println("I have reached here");
		return this.firstOrDefaultWhere(
			new WhereContainer(
				(new WhereClause()).
					postgreFunction(PostgreFunctionType.LOWER).
					table(this.primaryTable).
					fieldName(TransactionFieldNames.TRANSACTION_ID).
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
	public TransactionEntity createOne() {
		return new TransactionEntity();
	}
	
	public TransactionRepository() {
		super(DatabaseTable.TRANSACTION_LIST);
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