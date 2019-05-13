package edu.uark.commands.item;

import org.apache.commons.lang3.StringUtils;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.controllers.exceptions.ConflictException;
import edu.uark.controllers.exceptions.UnprocessableEntityException;
import edu.uark.models.api.Item;
import edu.uark.models.entities.ItemEntity;
import edu.uark.models.repositories.ItemRepository;
import edu.uark.models.repositories.interfaces.ItemRepositoryInterface;

public class ItemCreateCommand implements ResultCommandInterface<Item> {
	@Override
	public Item execute() {
		//Validations
		if (StringUtils.isBlank(String.valueOf(this.apiItem.getTransactionId()))) {
			throw new UnprocessableEntityException("transactionId");
		}

		ItemEntity itemEntity = this.itemRepository.byTransactionId(this.apiItem.getTransactionId());
		if (itemEntity != null) {
			
			throw new ConflictException("item"); //Lookupcode already defined for another product.
		}
		
		//No ENTITY object was returned from the database, thus the API object's lookupcode must be unique.
		itemEntity = new ItemEntity(apiItem); //Create a new ENTITY object from the API object details.
		itemEntity.save(); //Write, via an INSERT, the new record to the database.
		
		this.apiItem.setId(itemEntity.getId()); //Synchronize information generated by the database upon INSERT.
		//this.apiItem.setTimeStamp(itemEntity.getCreatedOn());

		return this.apiItem;
	}

	//Properties
	private Item apiItem;
	public Item getApiItem() {
		return this.apiItem;
	}
	public ItemCreateCommand setApiItem(Item apiItem) {
		this.apiItem = apiItem;
		return this;
	}
	
	private ItemRepositoryInterface itemRepository;
	public ItemRepositoryInterface getItemRepository() {
		return this.itemRepository;
	}
	public ItemCreateCommand setItemRepository(ItemRepositoryInterface itemRepository) {
		this.itemRepository = itemRepository;
		return this;
	}
	
	public ItemCreateCommand() {
		this.itemRepository = new ItemRepository();
	}
}
