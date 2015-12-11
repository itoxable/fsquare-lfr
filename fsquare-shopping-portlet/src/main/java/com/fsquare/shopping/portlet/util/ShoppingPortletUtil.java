package com.fsquare.shopping.portlet.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.fsquare.shopping.model.ShoppingCoupon;
import com.fsquare.shopping.model.ShoppingOrder;
import com.fsquare.shopping.model.ShoppingOrderItem;
import com.fsquare.shopping.model.ShoppingShippingMethod;
import com.fsquare.shopping.portlet.ShoppingOrderProcessWrapper;
import com.fsquare.shopping.service.ShoppingCouponLocalServiceUtil;
import com.fsquare.shopping.service.ShoppingOrderLocalServiceUtil;
import com.fsquare.shopping.service.ShoppingShippingMethodLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

public class ShoppingPortletUtil {

//	public static final String SESSION_CART_OBJECT = "session_cart_object";
//	public static final String SESSION_ORDER_OBJECT = "session_order_object";
//	public static final String SESSION_CART_COUPON_CODE = "session_cart_coupon_code";
//	public static final String SESSION_SHOPPING_SHIPPING_METHOD = "session_shopping_shipping_method";	
//	public static final String SESSION_AVAILABLE_SHOPPING_SHIPPING_METHOD_LIST = "availableShoppingShippingMethodList";
	
	public static final String SESSION_SHOPPING_ORDER_PROCESS_WRAPPER = "shoppingOrderProcessWrapper";


	public static final String CMD_ADD_TO_CART = "addToCart";
	public static final String CMD_REMOVE_FROM_CART = "removeFromCart";
	public static final String CMD_SAVE_STORE = "saveStore";
	public static final String CMD_CHECKOUT = "checkout";
	public static final String CMD_UPDATE_CART = "updateCart";
	public static final String CMD_SAVE_COUPON = "saveCoupon";
	public static final String CMD_DELETE_COUPON = "deleteCoupon";
	public static final String CMD_APPLY_COUPON = "applyCoupon";
	public static final String CMD_OPEN_COUPON_FORM = "openCouponForm";
	public static final String CMD_ACTIVATE_COUPON = "activateForm";
	
	public static final String CMD_SAVE_SHIPPING_METHOD = "saveShippingMethod";
	public static final String CMD_DELETE_SHIPPING_METHOD = "deleteShippingMethod";
	public static final String CMD_OPEN_SHIPPING_METHOD = "openShippingMethod";
	public static final String CMD_SET_DEFAULT_SHIPPING_METHOD = "setDefault_shippingMethod";
	
	public static final String CMD_OPEN_SHIPPING_ADDRESS = "openShippingAddress";
	public static final String CMD_OPEN_ORDER_ITEMS = "openOrderItems";
	public static final String CMD_UPDATE_ORDER_STATUS = "updateOrderStatus";
	public static final String CMD_CHECK_PAYMENT_STATUS = "checkPaymentStatus";
	
	
	public static final String CMD_OPEN_TEST_STRIPE_FORM = "openTestStripeForm";
	public static final String CMD_TEST_STRIPE = "testStripe";
	
	public static final String CMD_OPEN_TEST_BRAINTREE_PAYPAL = "cmd_open_test_braintree_paypal";
	public static final String CMD_TEST_BRAINTREE_PAYPAL = "cmd_test_braintree_paypal";
	public static final String CMD_GET_BRAINTREE_CLIENT_TOKEN = "cmd_get_braintree_client_token";
	public static final String CMD_BRAINTREE_TRANSACTION = "cmd_braintree_transaction";


	public static final String CMD_SAVE_CHECKOUT_SHIPPING_ADDRESS = "saveCheckoutShippingAddress";
	public static final String CMD_SAVE_CHECKOUT_SHIPPING_METHOD = "saveCheckoutShippingMethod";
	public static final String CMD_SAVE_CHECKOUT_PAYMENT = "saveCheckoutPayment";
	public static final String CMD_GET_CHECKOUT_STEP = "getCheckoutStep";
	public static final String CMD_CALCULATE_SHIPPING_PRICE = "calculateShippingPrice";

	public static final String CMD_SEND_STATUS_EMAIL = "sendStatusEmail";

	public static final String CMD_STRIPE_WEBHOOK = "stripeWebhook";

	
	public static final String PRODUCT_MAIN_IMAGE = "Main_Image";
	public static final String PRODUCT_TEXT = "Text";
	public static final String PRODUCT_PRICE = "Price";
	public static final String PRODUCT_FILTER = "Filter";
	public static final String PRODUCT_QUANTITY = "Quantity";
	public static final String PRODUCT_TYPE = "Type";
	public static final String PRODUCT_SIZE = "Size";
	public static final String PRODUCT_AUTHOR = "Author";
	public static final String PRODUCT_SKU = "SKU";
	
	public static final String ORDER_STATUS_INITIAL = "initial";
	public static final String ORDER_STATUS_PAID = "paid";
	public static final String ORDER_STATUS_FULFILLED = "fulfilled";
	
	public static final String ATTR_COUPON = "coupon";
	public static final String ATTR_SHIPPING = "shipping";
//	public static final String ATTR_ORDER = "order";
	public static final String ATTR_ORDER_ITEMS = "order_items";
	public static final String ATTR_ORDER_ITEM = "order_item";

	public static final String ATTR_SHOPPING_ORDER_PROCESS_WRAPPER = "attr_shoppingOrderProcessWrapper";
	public static final String ATTR_SHOPPING_ORDER = "attr_shopping_order";
	
	public static final String DATE_FORMAT = "dd/mm/yyyy";
	
	
	public static final String ATTR_SHOPPING_STORE = "shopping_store";
	
	public static final int CHECKOUT_STEP_SHIPPING_NR = 2;
	public static final int CHECKOUT_STEP_PAYMENT_NR= 3;
	public static final int CHECKOUT_STEP_ADDRESS_NR = 1;

	public static final String CHECKOUT_STEP_SHIPPING_METHOD = "/shopping-order-checkout/shipping-method.jsp";
	public static final String CHECKOUT_STEP_PAYMENT_FORM_BRAINTREE = "/shopping-order-checkout/payment-form-braintree.jsp";
	public static final String CHECKOUT_STEP_PAYMENT_FORM = "/shopping-order-checkout/payment-form.jsp";
	public static final String CHECKOUT_STEP_PAYMENT_FORM_STRIPE = "/shopping-order-checkout/payment-form-stripe.jsp";
	public static final String CHECKOUT_STEP_ADDRESS_FORM = "/shopping-order-checkout/address-form.jsp";
	public static final String CHECKOUT_SUCCESS_SCREEN = "/shopping-order-checkout/checkout-success.jsp";

	public static final String CMD_GET_ORDER_TOTAL = "getOrderTotal";


	public static final String CMD_SEND_TEST_EMAIL = "sendTestEmail";


	public static ShoppingOrderProcessWrapper getSessionShoppingOrderProcessWrapper(HttpSession session){
		Object shoppingOrderProcessWrapperObj = session.getAttribute(ShoppingPortletUtil.SESSION_SHOPPING_ORDER_PROCESS_WRAPPER);
		ShoppingOrderProcessWrapper shoppingOrderProcessWrapper = new ShoppingOrderProcessWrapper();
		if(shoppingOrderProcessWrapperObj != null){
			shoppingOrderProcessWrapper = (ShoppingOrderProcessWrapper)shoppingOrderProcessWrapperObj;
		}else{
			setSessionShoppingOrderProcessWrapper(session, shoppingOrderProcessWrapper);
		}
		
		return shoppingOrderProcessWrapper;
	}
	
	public static void setSessionShoppingOrderProcessWrapper(HttpSession session, ShoppingOrderProcessWrapper shoppingOrderProcessWrapper){
		session.setAttribute(ShoppingPortletUtil.SESSION_SHOPPING_ORDER_PROCESS_WRAPPER, shoppingOrderProcessWrapper);
		
	}
	
//	public static ShoppingShippingMethod getSessionShoppingShippingMethod(HttpSession session){
//		Object shoppingShippingMethodObj = session.getAttribute(ShoppingPortletUtil.SESSION_SHOPPING_SHIPPING_METHOD);
//		ShoppingShippingMethod shoppingShippingMethod = null;
//		if(shoppingShippingMethodObj != null){
//			shoppingShippingMethod = (ShoppingShippingMethod)shoppingShippingMethodObj;
//		}
//		return shoppingShippingMethod;
//	}
//	
//	public static List<ShoppingShippingMethod> getSessionAvailableShoppingShippingMethodList(HttpSession session) {
//		Object availableShoppingShippingMethodListObj = session.getAttribute(ShoppingPortletUtil.SESSION_AVAILABLE_SHOPPING_SHIPPING_METHOD_LIST);
//		List<ShoppingShippingMethod>  availableShoppingShippingMethodList = new ArrayList<ShoppingShippingMethod>();
//		if(availableShoppingShippingMethodListObj != null){
//			availableShoppingShippingMethodList = (List<ShoppingShippingMethod>)availableShoppingShippingMethodListObj;
//		}
//		return availableShoppingShippingMethodList;
//		//List<ShoppingShippingMethod> availableShoppingShippingMethodList = ShoppingPortletUtil.getSessionAvailableShoppingShippingMethodList(session);
//	}
//	
//	public static ShoppingOrder getSessionShoppingOrder(HttpSession session) {
//		Object shoppingOrderObj = session.getAttribute(ShoppingPortletUtil.SESSION_ORDER_OBJECT);
//		ShoppingOrder shoppingOrder = null;
//		if(shoppingOrderObj != null){
//			shoppingOrder = (ShoppingOrder)shoppingOrderObj;
//		}else{
//			Long orderId = 0L;
//			try {
//				orderId = CounterLocalServiceUtil.increment(ShoppingOrder.class.getName());
//			} catch (SystemException e) {
//				e.printStackTrace();
//			}
//			shoppingOrder = ShoppingOrderLocalServiceUtil.createShoppingOrder(orderId);
//			session.setAttribute(ShoppingPortletUtil.SESSION_ORDER_OBJECT, shoppingOrder);
//		}
//		return shoppingOrder;
//	}
//	
//	public static ShoppingCoupon getSessionCoupon(HttpSession session) {
//		Object shoppingCouponObj = session.getAttribute(ShoppingPortletUtil.SESSION_CART_COUPON_CODE);
//		ShoppingCoupon shoppingCoupon = null;
//		if(shoppingCouponObj != null){
//			shoppingCoupon = (ShoppingCoupon)shoppingCouponObj;
//		}
//		return shoppingCoupon;
//	}
//	
//	public static Map<String, ShoppingOrderItem> getSessionShoppingOrderItemMap(HttpSession session) {
//		Object shoppingOrderItemMapObj = session.getAttribute(ShoppingPortletUtil.SESSION_CART_OBJECT);
//		Map<String, ShoppingOrderItem> shoppingOrderItemMap = new HashMap<String, ShoppingOrderItem>();
//		if(shoppingOrderItemMapObj != null){
//			shoppingOrderItemMap = (Map<String, ShoppingOrderItem>)shoppingOrderItemMapObj;
//		}
//		return shoppingOrderItemMap;
//	} 
	
	public static String getMainImageURL(JournalArticle journalArticle) {
		String imagePath = StringPool.BLANK;
		Document document = null;
		try {
			document = SAXReaderUtil.read(journalArticle.getContent());
		
			if (Validator.isNotNull(document)) {
				Node fieldContent = document.selectSingleNode("//*/dynamic-element[@name='Main_Image']/dynamic-content");
				if (fieldContent != null) {
					imagePath = fieldContent.getText();
				}
			}
		} catch (Exception de) {
			de.printStackTrace();
		}
		return imagePath;
	}
	
	public static Map<String, String> getProductDetails(ThemeDisplay themeDisplay, String articleId) throws PortalException, SystemException {
		JournalArticle journalArticle = JournalArticleLocalServiceUtil.getArticle(themeDisplay.getScopeGroupId(), articleId);
		return getProductDetails(journalArticle);
	}
	
	public static Map<String, String> getProductDetails(JournalArticle journalArticle) {
		Document document = null;
		Map<String, String> product = new HashMap<String, String>();
		try {
			document = SAXReaderUtil.read(journalArticle.getContent());
		
			if (Validator.isNotNull(document)) {
				Node fieldContent = document.selectSingleNode("//*/dynamic-element[@name='Main_Image']/dynamic-content");
				if (fieldContent != null) {
					product.put(PRODUCT_MAIN_IMAGE, fieldContent.getText());
				}
				
				fieldContent = document.selectSingleNode("//*/dynamic-element[@name='Text']/dynamic-content");
				if (fieldContent != null) {
					product.put(PRODUCT_TEXT, fieldContent.getText());
				}
				
				fieldContent = document.selectSingleNode("//*/dynamic-element[@name='Price']/dynamic-content");
				if (fieldContent != null) {
					product.put(PRODUCT_PRICE, fieldContent.getText());
				}
				
				fieldContent = document.selectSingleNode("//*/dynamic-element[@name='Filter']/dynamic-content");
				if (fieldContent != null) {
					product.put(PRODUCT_FILTER, fieldContent.getText());
				}
				
				fieldContent = document.selectSingleNode("//*/dynamic-element[@name='Quantity']/dynamic-content");
				if (fieldContent != null) {
					product.put(PRODUCT_QUANTITY, fieldContent.getText());
				}
				
				fieldContent = document.selectSingleNode("//*/dynamic-element[@name='Size']/dynamic-content");
				if (fieldContent != null) {
					product.put(PRODUCT_SIZE, fieldContent.getText());
				}
				
				fieldContent = document.selectSingleNode("//*/dynamic-element[@name='Author']/dynamic-content");
				if (fieldContent != null) {
					product.put(PRODUCT_AUTHOR, fieldContent.getText());
				}
				
				fieldContent = document.selectSingleNode("//*/dynamic-element[@name='SKU']/dynamic-content");
				if (fieldContent != null) {
					product.put(PRODUCT_SKU, fieldContent.getText());
				}
				
			}
		} catch (Exception de) {
			de.printStackTrace();
		}
		
		return product;
	}
	
	
	
//	public static Double getAbsoluteTotal(ShoppingCoupon shoppingCoupon, Map<String, ShoppingOrderItem> shoppingOrderItemMap, ShoppingShippingMethod shoppingShippingMethod){
//		double total = ShoppingOrderLocalServiceUtil.getOrderTotal(shoppingOrderItemMap.values());
//		total = ShoppingCouponLocalServiceUtil.applyCoupon(shoppingCoupon, total);
//		double shipping = ShoppingShippingMethodLocalServiceUtil.getShippingPrice(shoppingShippingMethod, shoppingOrderItemMap.values(), total);
//		total = total + shipping;
//		return total;
//	}
	
//	public static Double getAbsoluteTotal(){
		
//		Map<String, ShoppingOrderItem> shoppingOrderItemMap = ShoppingPortletUtil.getSessionShoppingOrderItemMap(session);
//		
//		double total = ShoppingOrderLocalServiceUtil.getOrderTotal(shoppingOrderItemMap.values());
//		total = ShoppingCouponLocalServiceUtil.applyCoupon(shoppingCoupon, total);
//		double shipping = ShoppingShippingMethodLocalServiceUtil.getShippingPrice(shoppingShippingMethod, shoppingOrderItemMap.values(), total);
//		total = total + shipping;
//		
//		return getAbsoluteTotal(shoppingCoupon, shoppingOrderItemMap, shoppingShippingMethod);;
//	}
	
//	public static String getMainImage(JournalArticle journalArticle) {
//		String imagePath = StringPool.BLANK;
//		Document document = null;
//		try {
//			document = SAXReaderUtil.read(journalArticle.getContent());
//		
//			if (Validator.isNotNull(document)) {
//				Node fieldContent = document.selectSingleNode("//*/dynamic-element[@name='Main_Image']/dynamic-content");
//				if (fieldContent != null) {
//					imagePath = fieldContent.getText();
//				}
//			}
//		} catch (Exception de) {
//			de.printStackTrace();
//		}
//		return imagePath;
//	}
//	
//	public static boolean isCouponValid(ShoppingCoupon shoppingCoupon){
//		
//		if(!shoppingCoupon.isActive()){
//			return false;
//		}
//		
//		Calendar calendar = Calendar.getInstance();
//
//		boolean started = calendar.getTimeInMillis() >= shoppingCoupon.getStartDate().getTime();
//		boolean ended = calendar.getTimeInMillis() >= shoppingCoupon.getEndDate().getTime();
//
//		if(started && !ended){
//			return true;
//		}
//		
//		return false;
//	}
	
//	public static String getCouponStatus(ShoppingCoupon shoppingCoupon){
//		Calendar calendar = Calendar.getInstance();
//
//		boolean started = calendar.getTimeInMillis() >= shoppingCoupon.getStartDate().getTime();
//		boolean ended = calendar.getTimeInMillis() >= shoppingCoupon.getEndDate().getTime();
//
//		if(started && !ended){
//			return COUNPON_STATE_RUNNING;
//		}else if(ended){
//			return COUNPON_STATE_EXPIRED;
//		}else if(!started){
//			return COUNPON_STATE_NOT_STARTED;
//		}
//		
//		return COUNPON_STATE_RUNNING;
//	}

}
