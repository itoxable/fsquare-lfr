package com.fsquare.shopping.portlet.util;

import java.util.HashMap;
import java.util.Map;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
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
	
	public static final String CMD_ADD_TO_CART = "addToCart";
	public static final String CMD_REMOVE_FROM_CART = "removeFromCart";
	public static final String CMD_SAVE_STORE = "saveStore";
	public static final String CMD_CHECKOUT = "checkout";
	public static final String CMD_UPDATE_CART = "updateCart";
	public static final String CMD_SAVE_COUPON = "saveCoupon";
	public static final String CMD_DELETE_COUPON = "deleteCoupon";
	public static final String CMD_APPLY_COUPON = "applyCoupon";
	public static final String CMD_OPEN_COUPON_FORM = "openCouponForm";
	
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
	
	public static final String ON_ADD_TO_CART_JUMP_TO_CART = "jumpToCart";
	
	public static final String DISCOUNT_TYPE_PERCENTAGE = "percentage";
	public static final String DISCOUNT_TYPE_VALUE = "value";
	public static final String ATTR_COUPON = "coupon";
	
	public static final String DATE_FORMAT = "dd/mm/yyyy";
	
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
	
//	<img alt="Main Image" src="${Main_Image.getData()}" />
//	${Text.getData()}
//	${Price.getData()}
//	${Filter.getData()}
//	${Quantity.getData()}
//	${Type.getData()}
//	${Size.getData()}
//	${Author.getData()}
//	${SKU.getData()}
//	<#if Images.getSiblings()?has_content>
//		<#list Images.getSiblings() as cur_Images>
//			<img alt="Images" src="${cur_Images.getData()}" />
//		</#list>
//	</#if>
}
