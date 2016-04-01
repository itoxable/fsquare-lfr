package com.fsquare.shopping.portlet.util;

import java.util.Date;
import java.util.Locale;

import javax.portlet.PortletURL;

import com.fsquare.shopping.model.ShoppingItem;
import com.fsquare.shopping.service.ShoppingItemLocalServiceUtil;
import com.fsquare.shopping.service.persistence.ShoppingItemActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;

public class ShoppingItemIndexer extends BaseIndexer {

	public static final String[] CLASS_NAMES = {ShoppingItem.class.getName()};

	public static final String PORTLET_ID = PortletKeys.INVENTORY_MANAGEMENT;

	public ShoppingItemIndexer() {
		setFilterSearch(true);
		setPermissionAware(true);
	}

	@Override
	public void addRelatedEntryFields(Document document, Object obj) {
		document.addKeyword(Field.RELATED_ENTRY, true);
	}

	@Override
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	public String getPortletId() {
		return PORTLET_ID;
	}

	@Override
	public boolean hasPermission(
			PermissionChecker permissionChecker, String entryClassName,
			long entryClassPK, String actionId)
		throws Exception {

//		return BlogsEntryPermission.contains(
//			permissionChecker, entryClassPK, ActionKeys.VIEW);
		return true;
	}

//	@Override
//	public boolean isVisible(long classPK, int status) throws Exception {
//		ShoppingItem entry = ShoppingItemLocalServiceUtil.getShoppingItem(classPK);
//
//		return isVisible(entry.getStatus(), status);
//	}

	@Override
	public void postProcessContextQuery(
			BooleanQuery contextQuery, SearchContext searchContext)
		throws Exception {

		addStatus(contextQuery, searchContext);
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		ShoppingItem entry = (ShoppingItem)obj;

		deleteDocument(entry.getCompanyId(), entry.getItemId());
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		ShoppingItem entry = (ShoppingItem)obj;

		Document document = getBaseModelDocument(PORTLET_ID, entry);

		document.addText(Field.CONTENT, HtmlUtil.extractText(entry.getDescription()));
		document.addText(Field.DESCRIPTION, entry.getDescription());
		document.addDate(Field.MODIFIED_DATE, entry.getModifiedDate());
		document.addText(Field.TITLE, entry.getTitle());

		return document;
	}

	@Override
	protected Summary doGetSummary(
		Document document, Locale locale, String snippet,
		PortletURL portletURL) {

		String entryId = document.get(Field.ENTRY_CLASS_PK);

		portletURL.setParameter("struts_action", "/blogs/view_entry");
		portletURL.setParameter("entryId", entryId);

		Summary summary = createSummary(document);

		summary.setMaxContentLength(500);
		summary.setPortletURL(portletURL);

		return summary;
	}
//	protected Summary createSummary(Document document) {
//		return createSummary(document, Field.TITLE, Field.DESCRIPTION);
//	}
	@Override
	protected void doReindex(Object obj) throws Exception {
		ShoppingItem entry = (ShoppingItem)obj;

		Document document = getDocument(entry);

		SearchEngineUtil.updateDocument(
			getSearchEngineId(), entry.getCompanyId(), document);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		ShoppingItem entry = ShoppingItemLocalServiceUtil.getShoppingItem(classPK);

		doReindex(entry);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);

		reindexEntries(companyId);
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {
		return PORTLET_ID;
	}

	protected void reindexEntries(long companyId)
		throws PortalException, SystemException {

		ActionableDynamicQuery actionableDynamicQuery = new ShoppingItemActionableDynamicQuery() {

			@Override
			protected void addCriteria(DynamicQuery dynamicQuery) {
//				Property displayDateProperty = PropertyFactoryUtil.forName(
//					"displayDate");
//
//				dynamicQuery.add(displayDateProperty.lt(new Date()));

//				Property statusProperty = PropertyFactoryUtil.forName("status");
//
//				Integer[] statuses = {
//					WorkflowConstants.STATUS_APPROVED,
//					WorkflowConstants.STATUS_IN_TRASH
//				};

//				dynamicQuery.add(statusProperty.in(statuses));
			}

			@Override
			protected void performAction(Object object) throws PortalException {
				ShoppingItem entry = (ShoppingItem)object;

				Document document = getDocument(entry);

				addDocument(document);
			}

		};

		actionableDynamicQuery.setCompanyId(companyId);
		actionableDynamicQuery.setSearchEngineId(getSearchEngineId());

		actionableDynamicQuery.performActions();
	}
}