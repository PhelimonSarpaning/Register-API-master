package edu.uark.commands.item;

import java.util.List;
import java.util.stream.Collectors;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.models.api.Item;
import edu.uark.models.repositories.ItemRepository;
import edu.uark.models.repositories.interfaces.ItemRepositoryInterface;

public class ItemsQuery implements ResultCommandInterface<List<Item>> {
	@Override
	public List<Item> execute() {
		System.out.println("I am in the transactions query");
		System.out.println(this.itemRepository.
				all().
				stream().
				map(mp -> (new Item(mp))).
				collect(Collectors.toList()));
		return this.itemRepository.
			all().
			stream().
			map(mp -> (new Item(mp))).
			collect(Collectors.toList());
		
	}

	//Properties
	private ItemRepositoryInterface itemRepository;
	public ItemRepositoryInterface getItemRepository() {
		return this.itemRepository;
	}
	public ItemsQuery setItemRepository(ItemRepositoryInterface itemRepository) {
		this.itemRepository = itemRepository;
		return this;
	}
	
	public ItemsQuery() {
		System.out.println("fuLLY EXECUTED transactions query");
		this.itemRepository = new ItemRepository();
	}
}
