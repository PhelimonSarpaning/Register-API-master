package edu.uark.commands.item;	

 import org.apache.commons.lang3.StringUtils;	

 import edu.uark.commands.ResultCommandInterface;	
import edu.uark.controllers.exceptions.NotFoundException;	
import edu.uark.controllers.exceptions.UnprocessableEntityException;	
import edu.uark.models.api.Item;	
import edu.uark.models.entities.ItemEntity;	
import edu.uark.models.repositories.ItemRepository;	
import edu.uark.models.repositories.interfaces.ItemRepositoryInterface;	
//add some few things	
public class ItemByTransactionIdQuery implements ResultCommandInterface<Item> {	
	@Override	
	public Item execute() {	
		if (StringUtils.isBlank(String.valueOf(this.transactionId))){	
			throw new UnprocessableEntityException("transactionid");	
		}	

 		ItemEntity itemEntity = this.itemRepository.byTransactionId(this.transactionId);	
		if (itemEntity != null) {	
			return new Item(itemEntity);	
		} else {	
			throw new NotFoundException("Transaction");	
		}	
	}	

 	//Properties	
	private int transactionId;	
	public int getid_transaction() {	
		return this.transactionId;	
	}	
	public ItemByTransactionIdQuery setid_transaction(int transactionId) {	
		this.transactionId = transactionId;	
		return this;	
	}	

 	private ItemRepositoryInterface itemRepository;	
	public ItemRepositoryInterface getItemRepository() {	
		return this.itemRepository;	
	}	
	public ItemByTransactionIdQuery setItemRepository(ItemRepositoryInterface itemRepository) {	
		this.itemRepository = itemRepository;	
		return this;	
	}	

 	public ItemByTransactionIdQuery() {	
		this.itemRepository = new ItemRepository();	
	}	
}	
