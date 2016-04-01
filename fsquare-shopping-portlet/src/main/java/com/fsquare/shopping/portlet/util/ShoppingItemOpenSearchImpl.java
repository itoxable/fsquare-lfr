package com.fsquare.shopping.portlet.util;

import com.fsquare.shopping.model.ShoppingItem;
import com.liferay.portal.kernel.search.HitsOpenSearchImpl;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;

public class ShoppingItemOpenSearchImpl extends HitsOpenSearchImpl{

	
	public static final String SEARCH_PATH = "/c/shoppingitem/open_search";

	public static final String TITLE = "Shopping Item Search: ";
	
	@Override
	public Indexer getIndexer() {
		return IndexerRegistryUtil.getIndexer(ShoppingItem.class);
	}

	@Override
	public String getPortletId() {
		return ShoppingItemIndexer.PORTLET_ID;
	}

	@Override
	public String getSearchPath() {
		return SEARCH_PATH;
	}

	@Override
	public String getTitle(String keywords) {
		return TITLE + keywords;
	}

}
