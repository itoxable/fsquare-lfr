package com.fsquare.shopping.portlet.util;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.fsquare.shopping.model.ShoppingCoupon;
import com.fsquare.shopping.model.ShoppingOrderItem;
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

	public static final String SESSION_CART_OBJECT = "session_cart_object";
	public static final String SESSION_ORDER_OBJECT = "session_order_object";
	public static final String SESSION_CART_COUPON_CODE = "session_cart_coupon_code";

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
	public static final String CMD_UPDATE_ORDER_STATUS = "updatOrderStatus";

	public static final String CMD_OPEN_TEST_STRIPE_FORM = "openTestStripeForm";
	public static final String CMD_TEST_STRIPE = "testStripe";

	public static final String CMD_SAVE_CHECKOUT_SHIPPING_ADDRESS = "saveCheckoutShippingAddress";
	public static final String CMD_SAVE_CHECKOUT_SHIPPING_METHOD = "saveCheckoutShippingMethod";
	public static final String CMD_SAVE_CHECKOUT_PAYMENT = "saveCheckoutPayment";

	
	
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
	
	public static final String ORDER_STATUS_SHIPPED = "order_status_shipped";
	public static final String ORDER_STATUS_PENDING = "order_status_pending";
	public static final String ORDER_STATUS_CANCELED = "order_status_canceled";
	public static final String ORDER_STATUS_RETURNED = "order_status_returned";
	public static final String ORDER_STATUS_WAITING_PAYMENT = "order_status_waiting_payment";
	
	public static final String ON_ADD_TO_CART_JUMP_TO_CART = "jumpToCart";
	
	public static final String DISCOUNT_TYPE_PERCENTAGE = "percentage";
	public static final String DISCOUNT_TYPE_VALUE = "value";
	public static final String ATTR_COUPON = "coupon";
	public static final String ATTR_SHIPPING = "shipping";
	public static final String ATTR_ORDER = "order";
	public static final String ATTR_ORDER_ITEMS = "order_items";
	
	
	public static final String DATE_FORMAT = "dd/mm/yyyy";
	
	public static final String COUNPON_STATE_RUNNING = "coupon-running";
	public static final String COUNPON_STATE_NOT_STARTED = "coupon-not-started";
	public static final String COUNPON_STATE_EXPIRED = "coupon-expired";
	public static final String ATTR_SHOPPING_STORE = "shopping_store";
	public static final String ATTR_AVAILABLE_SHOPPING_SHIPPING_METHOD_LIST = "availableShoppingShippingMethodList";
	
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
	
	public static Double applyCoupon(ShoppingCoupon shoppingCoupon, Double total){
		if(shoppingCoupon == null || !ShoppingPortletUtil.isCouponValid(shoppingCoupon)){
			return total;
		}
		Double discount = shoppingCoupon.getDiscount();
        String discountType = shoppingCoupon.getDiscountType();
        
        if(discountType.equals(ShoppingPortletUtil.DISCOUNT_TYPE_PERCENTAGE)){
        	total = total * (1-(discount/100));
        }else if(discountType.equals(ShoppingPortletUtil.DISCOUNT_TYPE_VALUE)){
        	total = total - discount;
        }
        return total;
	}
	
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
	
	public static boolean isCouponValid(ShoppingCoupon shoppingCoupon){
		
		if(!shoppingCoupon.isActive()){
			return false;
		}
		
		Calendar calendar = Calendar.getInstance();

		boolean started = calendar.getTimeInMillis() >= shoppingCoupon.getStartDate().getTime();
		boolean ended = calendar.getTimeInMillis() >= shoppingCoupon.getEndDate().getTime();

		if(started && !ended){
			return true;
		}
		
		return false;
	}
	
	public static String getCouponStatus(ShoppingCoupon shoppingCoupon){
		Calendar calendar = Calendar.getInstance();

		boolean started = calendar.getTimeInMillis() >= shoppingCoupon.getStartDate().getTime();
		boolean ended = calendar.getTimeInMillis() >= shoppingCoupon.getEndDate().getTime();

		if(started && !ended){
			return COUNPON_STATE_RUNNING;
		}else if(ended){
			return COUNPON_STATE_EXPIRED;
		}else if(!started){
			return COUNPON_STATE_NOT_STARTED;
		}
		
		return COUNPON_STATE_RUNNING;
	}

}
