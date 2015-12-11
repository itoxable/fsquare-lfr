package com.fsquare.shopping.portlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

import com.braintreegateway.BraintreeGateway;
import com.braintreegateway.ClientTokenRequest;
import com.braintreegateway.Customer;
import com.braintreegateway.CustomerRequest;
import com.braintreegateway.Environment;
import com.braintreegateway.Result;
import com.braintreegateway.Transaction;
import com.braintreegateway.TransactionRequest;
import com.fsquare.shopping.model.ShoppingStore;

public class BraintreePayment {
	
	private BraintreeGateway braintreeGateway;
	private ShoppingStore shoppingStore;
	
	public static final String PAYMENT_METHOD_PAYPAL = "braintree_paypal";
	public static final String PAYMENT_METHOD_CREDIT_CARD = "braintree_credit_card";
	
	public static final String CUSTOMER_FIRST_NAME = "customer_first_name";
	public static final String CUSTOMER_LAST_NAME = "customer_last_name";
	public static final String CUSTOMER_COMPANY = "customer_company";
	public static final String CUSTOMER_EMAIL = "customer_email";
	public static final String CUSTOMER_FAX = "customer_fax";
	public static final String CUSTOMER_PHONE = "customer_phone";
	public static final String CUSTOMER_WEBSITE = "customer_website";
	public static final String CUSTOMER_ID = "customer_id";

	public BraintreePayment(ShoppingStore shoppingStore_){
		shoppingStore = shoppingStore_;
		Environment environment = Environment.PRODUCTION;
		String privateKey = shoppingStore.getBraintreePrivateKey();
		String publicKey = shoppingStore.getBraintreePublicKey();
		String merchantId = shoppingStore.getBraintreeMerchantId();
		if(shoppingStore.isUseBraintreeSandbox()){
			environment = Environment.SANDBOX;
			merchantId = shoppingStore.getBraintreeSandboxMerchantId();
			privateKey = shoppingStore.getBraintreeSandboxPrivateKey();
			publicKey = shoppingStore.getBraintreeSandboxPublicKey();
		}
		braintreeGateway = new BraintreeGateway(environment, merchantId, publicKey, privateKey);

	}
	public String getBraintreeTransactionStatus(String transactionId){
		Transaction transaction = braintreeGateway.transaction().find(transactionId);
		return transaction.getStatus().toString();
	}
	
	public Result<Transaction> doBraintreeRefung(String transactionId){
		Result<Transaction> result = braintreeGateway.transaction().refund(transactionId);
		return result;
	}
	
	public String getBraintreeClientToken(String customerId){
        ClientTokenRequest clientTokenRequest = new ClientTokenRequest();
        
//        if(customerId != null){
//        	Customer customer = braintreeGateway.customer().find(customerId);
//        }
        
//        clientTokenRequest.customerId(customerId);
        
//        String clientToken = braintreeGateway.clientToken().generate(clientTokenRequest);
        String clientToken = braintreeGateway.clientToken().generate();

        return clientToken;

	}
	
	public CustomerRequest buildBraintreeCustomer(Map<String, String> customerMap){
		CustomerRequest customerRequest = new CustomerRequest();
		customerRequest.firstName(customerMap.get(CUSTOMER_FIRST_NAME));
		customerRequest.lastName(customerMap.get(CUSTOMER_LAST_NAME));
		customerRequest.company(customerMap.get(CUSTOMER_COMPANY));
		customerRequest.email(customerMap.get(CUSTOMER_EMAIL));
		customerRequest.fax(customerMap.get(CUSTOMER_FAX));
		customerRequest.phone(customerMap.get(CUSTOMER_PHONE));
		customerRequest.website(customerMap.get(CUSTOMER_WEBSITE));
		customerRequest.id(customerMap.get(CUSTOMER_ID));
		return customerRequest;
	}
	
	public String createBraintreeCustomer(Map<String, String> customerMap){		
		Result<Customer> result = braintreeGateway.customer().create(buildBraintreeCustomer(customerMap));
		if(result.isSuccess()){
			return result.getTarget().getId();
		}
		return null;		
	}
	
	
	
	public Result<Transaction> doBraintreeTransaction(String nonce, String amount) throws IOException {

		TransactionRequest transactionRequest = new TransactionRequest();
		
		transactionRequest.amount(new BigDecimal(amount));
		transactionRequest.paymentMethodNonce(nonce);
		
		Result<Transaction> result = braintreeGateway.transaction().sale(transactionRequest);
		
        return result;
	}
	
	public BraintreeGateway getBraintreeGateway() {
		return braintreeGateway;
	}
	public void setBraintreeGateway(BraintreeGateway braintreeGateway) {
		this.braintreeGateway = braintreeGateway;
	}
	
}
