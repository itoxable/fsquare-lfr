package com.fsquare.shopping;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Layout;

public class ShoppingUtil {
	public static final String COUNPON_STATE_RUNNING = "coupon-running";
	public static final String COUNPON_STATE_NOT_STARTED = "coupon-not-started";
	public static final String COUNPON_STATE_EXPIRED = "coupon-expired";
	
	public static final String DISCOUNT_TYPE_PERCENTAGE = "percentage";
	public static final String DISCOUNT_TYPE_VALUE = "value";
	public static final String DISCOUNT_TYPE_FREE_SHIPPING = "free_shipping";
	
	public static final String USER_TYPES_GUEST_ONLY = "guest_only";
	public static final String USER_TYPES_REGISTERED_ONLY = "registered_only";
	public static final String USER_TYPES_ALL = "all";
	
	
	public static final String ORDER_STATUS_SHIPPED = "order_status_shipped";
	public static final String ORDER_ORDER_MAIL_FAILED = "order_order_mail_failed";
	public static final String ORDER_STATUS_PENDING = "order_status_pending";
	public static final String ORDER_STATUS_CANCELED = "order_status_canceled";
	public static final String ORDER_STATUS_RETURNED = "order_status_returned";
	public static final String ORDER_STATUS_WAITING_PAYMENT = "order_status_waiting_payment";

	public static final String ON_ADD_TO_CART_JUMP_TO_CART = "jumpToCart";
	
	public static final String SHOPPING_ITEM_RECORD = "shopping_item_record";
	
	public static final String SHOPPING_ITEM_MOVEMENT_ADD = "shopping_item_movement_add";
	public static final String SHOPPING_ITEM_MOVEMENT_REMOVE = "shopping_item_movement_remove";
	public static final String SHOPPING_ITEM_MOVEMENT_MOVE = "shopping_item_movement_move";
	
	public static Map<String, String[]> getSettings(){
		//Map<String, String> settings = new HashMap<String, String>();
		
		
		
		Map<String, String[]> settings = new HashMap<String, String[]>();
		
//		settings.put("", new String[]{,,,,});
		settings.put("COUNPON_STATES", new String[]{COUNPON_STATE_RUNNING,COUNPON_STATE_NOT_STARTED,COUNPON_STATE_EXPIRED});
//		settings.put("COUNPON_STATE_RUNNING", COUNPON_STATE_RUNNING);
//		settings.put("COUNPON_STATE_NOT_STARTED", COUNPON_STATE_NOT_STARTED);
//		settings.put("COUNPON_STATE_EXPIRED", COUNPON_STATE_EXPIRED);
		
		settings.put("DISCOUNT_TYPES", new String[]{DISCOUNT_TYPE_PERCENTAGE,DISCOUNT_TYPE_VALUE,DISCOUNT_TYPE_FREE_SHIPPING});
//		settings.put("DISCOUNT_TYPE_PERCENTAGE", DISCOUNT_TYPE_PERCENTAGE);
//		settings.put("DISCOUNT_TYPE_VALUE", DISCOUNT_TYPE_VALUE);
//		settings.put("DISCOUNT_TYPE_FREE_SHIPPING", DISCOUNT_TYPE_FREE_SHIPPING);
		
		settings.put("USER_TYPES", new String[]{USER_TYPES_GUEST_ONLY,USER_TYPES_REGISTERED_ONLY,USER_TYPES_ALL});
//		settings.put("USER_TYPES_GUEST_ONLY", USER_TYPES_GUEST_ONLY);
//		settings.put("USER_TYPES_REGISTERED_ONLY", USER_TYPES_REGISTERED_ONLY);
//		settings.put("USER_TYPES_ALL", USER_TYPES_ALL);
		
		settings.put("ORDER_STATUS", new String[]{ORDER_STATUS_SHIPPED,ORDER_STATUS_PENDING,ORDER_STATUS_CANCELED,ORDER_STATUS_RETURNED,ORDER_STATUS_WAITING_PAYMENT});		
//		settings.put("ORDER_STATUS_SHIPPED",ORDER_STATUS_SHIPPED);
//		settings.put("ORDER_ORDER_MAIL_FAILED", ORDER_ORDER_MAIL_FAILED);
//		settings.put("ORDER_STATUS_PENDING", ORDER_STATUS_PENDING);
//		settings.put("ORDER_STATUS_CANCELED", ORDER_STATUS_CANCELED);
//		settings.put("ORDER_STATUS_RETURNED", ORDER_STATUS_RETURNED);
//		settings.put("ORDER_STATUS_WAITING_PAYMENT", ORDER_STATUS_WAITING_PAYMENT);
		
		settings.put("ON_ADD_TO_CART", new String[]{ON_ADD_TO_CART_JUMP_TO_CART});
//		settings.put("ON_ADD_TO_CART_JUMP_TO_CART", ON_ADD_TO_CART_JUMP_TO_CART);
		
		settings.put("ON_ADD_TO_CART", new String[]{ON_ADD_TO_CART_JUMP_TO_CART});
		
		settings.put("SHOPPING_ITEM_MOVEMENT", new String[]{SHOPPING_ITEM_MOVEMENT_ADD,SHOPPING_ITEM_MOVEMENT_REMOVE,SHOPPING_ITEM_MOVEMENT_MOVE});
//		settings.put("SHOPPING_ITEM_MOVEMENT_ADD", SHOPPING_ITEM_MOVEMENT_ADD);
//		settings.put("SHOPPING_ITEM_MOVEMENT_REMOVE", SHOPPING_ITEM_MOVEMENT_REMOVE);
//		settings.put("SHOPPING_ITEM_MOVEMENT_MOVE", SHOPPING_ITEM_MOVEMENT_MOVE);
		
		return settings;
	}
	
	public static String getLayoutBreadcrumb(Layout layout, Locale locale) throws Exception {
		StringBundler sb = new StringBundler();

		layout = layout.toEscapedModel();

		if (layout.isPrivateLayout()) {
			sb.append(LanguageUtil.get(locale, "private-pages"));
		}
		else {
			sb.append(LanguageUtil.get(locale, "public-pages"));
		}

		sb.append(StringPool.SPACE);
		sb.append(StringPool.GREATER_THAN);
		sb.append(StringPool.SPACE);

		List<Layout> ancestors = layout.getAncestors();

		Collections.reverse(ancestors);

		for (Layout ancestor : ancestors) {
			ancestor = ancestor.toEscapedModel();

			sb.append(ancestor.getName(locale));
			sb.append(StringPool.SPACE);
			sb.append(StringPool.GREATER_THAN);
			sb.append(StringPool.SPACE);
		}

		sb.append(layout.getName(locale));

		return sb.toString();
	}
}
