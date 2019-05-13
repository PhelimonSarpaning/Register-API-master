package edu.uark.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.uark.commands.transaction.TransactionByTransactionIdQuery;
import edu.uark.commands.transaction.TransactionCreateCommand;
import edu.uark.commands.transaction.TransactionDeleteCommand;
import edu.uark.commands.transaction.TransactionQuery;
import edu.uark.commands.transaction.TransactionUpdateCommand;
import edu.uark.commands.transaction.TransactionsQuery;
import edu.uark.models.api.Transaction;

@RestController
@RequestMapping(value = "/api/transaction")
public class TransactionRestController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Transaction> getTransactions() {
		System.out.println("Here sir");
		return (new TransactionsQuery()).execute();
	}

	@RequestMapping(value = "/{transactionId}", method = RequestMethod.GET)
	public Transaction getProduct(@PathVariable UUID transactionId) {
		return (new TransactionQuery()).
			setTransactionId(transactionId).
			execute();
	}
//
//	@RequestMapping(value = "/bylookupcode/{productLookupCode}", method = RequestMethod.GET)
//	public Product getProductByLookupCode(@PathVariable String productLookupCode) {
//		return (new ProductByLookupCodeQuery()).
//			setLookupCode(productLookupCode).
//			execute();
//	}
//	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Transaction createTransaction(@RequestBody Transaction transaction) {
		return (new TransactionCreateCommand()).
			setApiTransaction(transaction).
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
	@RequestMapping(value = "/trust", method = RequestMethod.GET)
	public String test() {
		return "Successful test. (TransactionRestController)";
	}
}
