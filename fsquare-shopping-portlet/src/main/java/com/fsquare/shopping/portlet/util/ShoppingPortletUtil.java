package com.fsquare.shopping.portlet.util;

import java.util.HashMap;
import java.util.Map;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portlet.journal.model.JournalArticle;

public class ShoppingPortletUtil {
	public static String SESSION_CART_OBJECT = "session_cart_object";
	
	public static String CMD_ADD_TO_CART = "addToCart";
	public static String CMD_REMOVE_FROM_CART = "removeFromCart";
	public static String CMD_SAVE_STORE = "saveStore";

	public static String CMD_APPLY_COUPON = "applyCoupon";

	public static String PRODUCT_MAIN_IMAGE = "Main_Image";
	public static String PRODUCT_TEXT = "Text";
	public static String PRODUCT_PRICE = "Price";
	public static String PRODUCT_FILTER = "Filter";
	public static String PRODUCT_QUANTITY = "Quantity";
	public static String PRODUCT_TYPE = "Type";
	public static String PRODUCT_SIZE = "Size";
	public static String PRODUCT_AUTHOR = "Author";
	public static String PRODUCT_SKU = "SKU";
	
	public static String ON_ADD_TO_CART_JUMP_TO_CART = "jumpToCart";
	
	
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
