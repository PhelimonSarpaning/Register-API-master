package edu.uark.commands.item;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.controllers.exceptions.NotFoundException;
import edu.uark.controllers.exceptions.UnprocessableEntityException;
import edu.uark.models.api.Item;
import edu.uark.models.entities.ItemEntity;
import edu.uark.models.repositories.ItemRepository;
import edu.uark.models.repositories.interfaces.ItemRepositoryInterface;

public class ItemUpdateCommand implements ResultCommandInterface<Item> {
	@Override
	public Item execute() {
		//Validations
		if (StringUtils.isBlank(String.valueOf(this.apiItem.getTransactionId()))) {
			throw new UnprocessableEntityException("transactionid");
		}

		ItemEntity itemEntity = this.itemRepository.get(this.transactionId);
		if (itemEntity == null) { //No record with the associated record ID exists in the database.
			throw new NotFoundException("Transaction");
		}
		
		this.apiItem = itemEntity.synchronize(this.apiItem); //Synchronize any incoming changes for UPDATE to the database.
		
		itemEntity.save(); //Write, via an UPDATE, any changes to the database.
		
		return this.apiItem;
	}

	//Properties
	private UUID transactionId;
	public UUID getTransactionId() {
		return this.transactionId;
	}
	public ItemUpdateCommand setTransactionId(UUID transactionId) {
		this.transactionId = transactionId;
		return this;
	}
	
	private Item apiItem;
	public Item getApiItem() {
		return this.apiItem;
	}
	public ItemUpdateCommand setApiItem(Item apiItem) {
		this.apiItem = apiItem;
		return this;
	}
	
	private ItemRepositoryInterface itemRepository;
	public ItemRepositoryInterface getItemRepository() {
		return this.itemRepository;
	}
	public ItemUpdateCommand setItemRepository(ItemRepositoryInterface itemRepository) {
		this.itemRepository = itemRepository;
		return this;
	}
	
	public ItemUpdateCommand() {
		this.itemRepository = new ItemRepository();
	}
}
