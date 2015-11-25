package com.fsquare.shopping.messaging;

import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.InternetAddress;

import com.fsquare.shopping.StoreConfigurationException;
import com.fsquare.shopping.model.ShoppingOrder;
import com.fsquare.shopping.model.ShoppingOrderItem;
import com.fsquare.shopping.model.ShoppingStore;
import com.fsquare.shopping.service.ShoppingOrderItemLocalServiceUtil;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.io.unsync.UnsyncStringWriter;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import freemarker.core.Environment;
import freemarker.template.Configuration;
import freemarker.template.SimpleSequence;
import freemarker.template.Template;

public class ShoppingSuccessOrderMail implements MessageListener {

	@Override
	public void receive(Message message) throws MessageListenerException {
		
		
		try {
			doReceive(message);
		}
		catch (Exception e) {
			e.printStackTrace();
			_log.fatal("Unable to process message " + message, e);
		}
	}
	
	protected void doReceive(Message message) throws Exception {

		ShoppingOrder shoppingOrder = (ShoppingOrder)message.get("shoppingOrder");
		ShoppingStore shoppingStore = (ShoppingStore)message.get("shoppingStore");

		String orderCreatedEmailTemplate = shoppingStore.getOrderCreatedEmailTemplate().toString();
		String orderCreatedEmailSubject = shoppingStore.getOrderCreatedEmailSubject();
		String orderCreatedEmailFromAddress = shoppingStore.getOrderCreatedEmailFromAddress();
		
		if(Validator.isNull(orderCreatedEmailTemplate) || Validator.isNull(orderCreatedEmailSubject) || Validator.isNull(orderCreatedEmailFromAddress)){
			throw new StoreConfigurationException("Email Configuration missing "
					+ "[EMAIL_TEMPLATE: '"+(Validator.isNull(orderCreatedEmailTemplate)?"null":"not null")
					+"', EMAIL_SUBJECT:'"+(Validator.isNull(orderCreatedEmailSubject)?"null":"not null")
					+"', EMAIL_FROM_ADDRESS:'"+(Validator.isNull(orderCreatedEmailFromAddress)?"null":"not null")+"',]");
			
			
		}

		List<ShoppingOrderItem> shoppingOrderItems = ShoppingOrderItemLocalServiceUtil.findByShoppingOrderId(shoppingOrder.getShoppingOrderId());		
		Configuration configuration = new Configuration();

		configuration.setDefaultEncoding(StringPool.UTF8);
		configuration.setNumberFormat("0.######");
		Map<String, Object> ctx = new HashMap<String, Object>();
		
		SimpleSequence simpleSequence = new SimpleSequence();
		//simpleSequence.
		ctx.put("shoppingOrderItems", shoppingOrderItems);
		ctx.put("shoppingOrder", shoppingOrder);
		ctx.put("shoppingStore", shoppingStore);
		
		UnsyncStringWriter unsyncStringWriter = new UnsyncStringWriter();
		
		Template template = new Template("templateName", new StringReader(orderCreatedEmailTemplate), configuration);
		Environment env = template.createProcessingEnvironment(ctx, unsyncStringWriter);
		env.process();
		
		InternetAddress toAddress = new InternetAddress(shoppingOrder.getShippingEmailAddress());
		InternetAddress fromAddress = new InternetAddress(orderCreatedEmailFromAddress);
		_log.info(unsyncStringWriter.toString());
		MailMessage mailMessage = new MailMessage(fromAddress, toAddress, orderCreatedEmailSubject, unsyncStringWriter.toString(), true);
		MailServiceUtil.sendEmail(mailMessage);
		
	}

	
	private static Log _log = LogFactoryUtil.getLog(ShoppingSuccessOrderMail.class);

}
