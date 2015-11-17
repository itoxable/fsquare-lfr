package com.fsquare.shopping.messaging;

import javax.mail.internet.InternetAddress;

import com.fsquare.shopping.StoreConfigurationException;
import com.fsquare.shopping.model.ShoppingOrder;
import com.fsquare.shopping.model.ShoppingStore;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.mail.InternetAddressUtil;

public class ShoppingSuccessOrderMail implements MessageListener {

	@Override
	public void receive(Message message) throws MessageListenerException {
		
		
		try {
			doReceive(message);
		}
		catch (Exception e) {
			_log.fatal("Unable to process message " + message, e);
		}
	}
	
	protected void doReceive(Message message) throws Exception {
		
		System.out.println("DOING");

		ShoppingOrder shoppingOrder = (ShoppingOrder)message.get("shoppingOrder");
		ShoppingStore shoppingStore = (ShoppingStore)message.get("shoppingStore");

		String orderCreatedEmailTemplate = shoppingStore.getOrderCreatedEmailTemplate();
		String orderCreatedEmailSubject = shoppingStore.getOrderCreatedEmailSubject();
		String orderCreatedEmailFromAddress = shoppingStore.getOrderCreatedEmailFromAddress();
		if(Validator.isNotNull(orderCreatedEmailTemplate) || Validator.isNotNull(orderCreatedEmailSubject) || Validator.isNotNull(orderCreatedEmailFromAddress)){
			throw new StoreConfigurationException("Email Configuration missing");
		}
			
		InternetAddress toAddress = new InternetAddress(shoppingOrder.getShippingEmailAddress());
		InternetAddress fromAddress = new InternetAddress(orderCreatedEmailFromAddress);
		
		String mailMessageBody = orderCreatedEmailTemplate;
		MailMessage mailMessage = new MailMessage(fromAddress, toAddress, orderCreatedEmailSubject, mailMessageBody, true);
		MailServiceUtil.sendEmail(mailMessage);
		
		_log.info(shoppingOrder.toString());
	}

	private static Log _log = LogFactoryUtil.getLog(ShoppingSuccessOrderMail.class);

}
