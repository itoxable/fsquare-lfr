package com.fsquare.shopping.asset;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;

import com.fsquare.shopping.model.ShoppingItem;
import com.fsquare.shopping.service.ShoppingItemLocalServiceUtil;
import com.fsquare.shopping.service.ShoppingItemServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.Tuple;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.ResourceActionsUtil;
import com.liferay.portal.service.PortletLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.AssetRendererFactory;

public class ShoppingItemAssetRendererFactory  implements AssetRendererFactory  {

	public static final String TYPE = "shopping_item";
	private String _portletId;
	private String _className;
	
	private static final boolean _LINKABLE = false;

	private static final boolean _PERMISSION = true;

	private static final boolean _SELECTABLE = true;
	
	@Override
	public AssetEntry getAssetEntry(long assetEntryId) throws PortalException, SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssetEntry getAssetEntry(String classNameId, long classPK) throws PortalException, SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssetRenderer getAssetRenderer(long classPK) throws PortalException, SystemException {
		ShoppingItem shoppingItem = ShoppingItemLocalServiceUtil.fetchShoppingItem(classPK);
	    return new ShoppingItemAssetRenderer(shoppingItem);
	}

	@Override
	public AssetRenderer getAssetRenderer(long classPK, int type) throws PortalException, SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssetRenderer getAssetRenderer(long groupId, String urlTitle) throws PortalException, SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getClassName() {
		return ShoppingItem.class.getName();
	}

	@Override
	public long getClassNameId() {
		return PortalUtil.getClassNameId(ShoppingItem.class.getName());
	}

	@Override
	public List<Tuple> getClassTypeFieldNames(long classTypeId, Locale locale, int start, int end) throws Exception {
		// TODO Auto-generated method stub
		return Collections.emptyList();
	}

	@Override
	public int getClassTypeFieldNamesCount(long classTypeId, Locale locale) throws Exception {
		return 0;
	}

	@Override
	public Map<Long, String> getClassTypes(long[] groupIds, Locale locale) throws Exception {
		return Collections.emptyMap();
	}

	@Override
	public String getIconPath(PortletRequest portletRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		return themeDisplay.getPathThemeImages() + "/common/history.png";
	}

	@Override
	public String getPortletId() {
		return _portletId;
	}

	@Override
	public String getType() {
		return TYPE;
	}

	@Override
	public String getTypeName(Locale locale, boolean hasSubtypes) {
		return ResourceActionsUtil.getModelResource(locale, getClassName());
	}

	@Override
	public PortletURL getURLAdd(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse) throws PortalException, SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PortletURL getURLView(LiferayPortletResponse liferayPortletResponse, WindowState windowState)
			throws PortalException, SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasAddPermission(PermissionChecker permissionChecker, long groupId, long classTypeId)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasClassTypeFieldNames(long classTypeId, Locale locale) throws Exception {
		List<Tuple> classTypeFieldNames = getClassTypeFieldNames(classTypeId, locale, QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		return !classTypeFieldNames.isEmpty();
	}

	@Override
	public boolean hasPermission(PermissionChecker permissionChecker, long entryClassPK, String actionId)
			throws Exception {

		return _PERMISSION;
	}

	@Override
	public boolean isActive(long companyId) {
		if (Validator.isNull(getPortletId())) {
			return true;
		}

		Portlet portlet = null;

		try {
			portlet = PortletLocalServiceUtil.getPortletById(companyId, getPortletId());
		}
		catch (SystemException se) {
			portlet = PortletLocalServiceUtil.getPortletById(getPortletId());
		}

		if (portlet == null) {
			return false;
		}

		return portlet.isActive();
	}

	@Override
	public boolean isCategorizable() {
		return true;
	}

	@Override
	public boolean isLinkable() {
		return _LINKABLE;
	}

	@Override
	public boolean isListable(long classPK) throws SystemException {
		return false;
	}

	@Override
	public boolean isSelectable() {
		return _SELECTABLE;
	}

	@Override
	public void setClassName(String className) {
		_className = className;
	}

	@Override
	public void setPortletId(String portletId) {
		_portletId = portletId;
	}


}
