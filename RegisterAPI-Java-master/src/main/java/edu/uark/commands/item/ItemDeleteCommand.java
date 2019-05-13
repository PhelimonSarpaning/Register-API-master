package edu.uark.commands.item;

import java.util.UUID;

import edu.uark.commands.VoidCommandInterface;
import edu.uark.controllers.exceptions.NotFoundException;
import edu.uark.models.entities.ItemEntity;
import edu.uark.models.repositories.ItemRepository;
import edu.uark.models.repositories.interfaces.ItemRepositoryInterface;

public class ItemDeleteCommand implements VoidCommandInterface {
	@Override
	public void execute() {
		ItemEntity itemEntity = this.itemRepository.get(this.transactionId);
		if (itemEntity == null) { //No record with the associated record ID exists in the database.
			throw new NotFoundException("item");
		}
		
		itemEntity.delete();
	}

	//Properties
	private UUID transactionId;
	public UUID getTransactiontId() {
		return this.transactionId;
	}
	public ItemDeleteCommand setTransactionId(UUID transactionId) {
		this.transactionId = transactionId;
		return this;
	}
	
	private ItemRepositoryInterface itemRepository;
	public ItemRepositoryInterface getItemRepository() {
		return this.itemRepository;
	}
	public ItemDeleteCommand setItemRepository(ItemRepositoryInterface itemRepository) {
		this.itemRepository = itemRepository;
		return this;
	}
	
	public ItemDeleteCommand() {
		this.itemRepository = new ItemRepository();
	}
}
