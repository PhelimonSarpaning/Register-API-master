package edu.uark.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.uark.commands.item.ItemByTransactionIdQuery;
import edu.uark.commands.item.ItemCreateCommand;
import edu.uark.commands.item.ItemDeleteCommand;
import edu.uark.commands.item.ItemQuery;
import edu.uark.commands.item.ItemUpdateCommand;
import edu.uark.commands.item.ItemQuery;
import edu.uark.commands.item.ItemsQuery;
import edu.uark.models.api.Item;

@RestController
@RequestMapping(value = "/api/item")
public class ItemRestController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Item> getItems() {
		System.out.println("Here sir");
		return (new ItemsQuery()).execute();
	}

//	@RequestMapping(value = "/{transactionId}", method = RequestMethod.GET)
//	public Item getProduct(@PathVariable UUID transactionId) {
//		return (new TransactionQuery()).
//			setTransactionId(transactionId).
//			execute();
//	}
//
//	@RequestMapping(value = "/bylookupcode/{productLookupCode}", method = RequestMethod.GET)
//	public Product getProductByLookupCode(@PathVariable String productLookupCode) {
//		return (new ProductByLookupCodeQuery()).
//			setLookupCode(productLookupCode).
//			execute();
//	}
//	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Item createItem(@RequestBody Item item) {
		return (new ItemCreateCommand()).
			setApiItem(item).
			execute();
	}
//	
//	@RequestMapping(value = "/{productId}", method = RequestMethod.PUT)
//	public Product updateProduct(@PathVariable UUID productId, @RequestBody Product product) {
//		return (new ProductUpdateCommand()).
//			setProductId(productId).
//			setApiProduct(product).
//			execute();
//	}
//	
//	@RequestMapping(value = "/{productId}", method = RequestMethod.DELETE)
//	public void deleteProduct(@PathVariable UUID productId) {
//		(new ProductDeleteCommand()).
//			setProductId(productId).
//			execute();
//	}

	@ResponseBody
	@RequestMapping(value = "/receipt", method = RequestMethod.GET)
	public String test() {
		return "Successful test. (TransactionRestController)";
	}
}
