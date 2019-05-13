package edu.uark.models.repositories.interfaces;

import edu.uark.dataaccess.repository.BaseRepositoryInterface;
import edu.uark.models.entities.ItemEntity;

public interface ItemRepositoryInterface extends BaseRepositoryInterface<ItemEntity> {
	ItemEntity byTransactionId(int transactionId);
}
