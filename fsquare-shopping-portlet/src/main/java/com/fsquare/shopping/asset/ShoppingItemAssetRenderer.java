package com.fsquare.shopping.asset;

import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.fsquare.shopping.ShoppingUtil;
import com.fsquare.shopping.model.ShoppingItem;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portlet.asset.model.BaseAssetRenderer;

public class ShoppingItemAssetRenderer extends BaseAssetRenderer{

	private ShoppingItem _shoppingItem;
	
	public ShoppingItemAssetRenderer(ShoppingItem shoppingItem){
		_shoppingItem = shoppingItem;
	}
	
	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getClassPK() {
		return _shoppingItem.getItemId();
	}

	@Override
	public long getGroupId() {
		return _shoppingItem.getGroupId();
	}

	@Override
	public String getSummary(Locale locale) {
		StringBuilder sb = new StringBuilder(_shoppingItem.getName());
		sb.append(_shoppingItem.getPrice());
		return sb.toString();
	}

	@Override
	public String getTitle(Locale locale) {
		return _shoppingItem.getName();
	}

	@Override
	public long getUserId() {
		return _shoppingItem.getUserId();
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUuid() {
		return _shoppingItem.getUuid();
	}

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse, String template) throws Exception {
		if (template.equals(TEMPLATE_FULL_CONTENT)) {
			renderRequest.setAttribute(ShoppingUtil.SHOPPING_ITEM_RECORD, _shoppingItem);
	        return "/html/" + template + ".jsp";
		}else if(template.equals(TEMPLATE_ABSTRACT)){
			
			
		}
		return null;
	}

}
