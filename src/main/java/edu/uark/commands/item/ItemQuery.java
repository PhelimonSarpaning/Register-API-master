package edu.uark.commands.item;

import java.util.UUID;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.controllers.exceptions.NotFoundException;
import edu.uark.models.api.Item;
import edu.uark.models.entities.ItemEntity;
import edu.uark.models.repositories.ItemRepository;
import edu.uark.models.repositories.interfaces.ItemRepositoryInterface;

public class ItemQuery implements ResultCommandInterface<Item> {
	@Override
	public Item execute() {
		ItemEntity itemEntity = this.itemRepository.get(this.transactionId);
		if (itemEntity != null) {
			return new Item(itemEntity);
		} else {
			throw new NotFoundException("Item");
		}
	}

	//Properties
	private UUID transactionId;
	public UUID getTransactionId() {
		return this.transactionId;
	}
	public ItemQuery setItemId(UUID transactionId) {
		this.transactionId = transactionId;
		return this;
	}
	
	private ItemRepositoryInterface itemRepository;
	public ItemRepositoryInterface getItemRepository() {
		return this.itemRepository;
	}
	public ItemQuery setTransactionRepository(ItemRepositoryInterface itemRepository) {
		this.itemRepository = itemRepository;
		return this;
	}
	
	public ItemQuery() {
		this.itemRepository = new ItemRepository();
	}
}
