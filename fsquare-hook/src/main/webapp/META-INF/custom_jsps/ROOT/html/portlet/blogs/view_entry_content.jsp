<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil"%>
<%@page import="java.text.Format"%>
<%@ include file="/html/portlet/blogs/init.jsp" %>

<%!
static final boolean EDITOR_INLINE_EDITING_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get("editor.inline.editing.enabled"));
%>

<%
SearchContainer searchContainer = (SearchContainer)request.getAttribute("view_entry_content.jsp-searchContainer");

BlogsEntry entry = (BlogsEntry)request.getAttribute("view_entry_content.jsp-entry");

AssetEntry assetEntry = (AssetEntry)request.getAttribute("view_entry_content.jsp-assetEntry");


//SimpleDateFormat dateFormatDateTime = new SimpleDateFormat("yyyy/MM/dd");

%>

<c:choose>
	<c:when test="<%= BlogsEntryPermission.contains(permissionChecker, entry, ActionKeys.VIEW) && (entry.isVisible() || (entry.getUserId() == user.getUserId()) || BlogsEntryPermission.contains(permissionChecker, entry, ActionKeys.UPDATE)) %>">
		<div class="panel-body clearfix entry <%= WorkflowConstants.getStatusLabel(entry.getStatus()) %>" id="<portlet:namespace /><%= entry.getEntryId() %>">
			<div class="entry-content">

				<%
				String strutsAction = ParamUtil.getString(request, "struts_action");
				//System.out.println("strutsAction: "+strutsAction);
				%>

				<c:if test="<%= !entry.isApproved() %>">
					<h3>
						<liferay-ui:message key='<%= entry.isPending() ? "pending-approval" : WorkflowConstants.getStatusLabel(entry.getStatus()) %>' />
					</h3>
				</c:if>

				<portlet:renderURL var="viewEntryURL">
					<portlet:param name="struts_action" value="/blogs/view_entry" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="urlTitle" value="<%= entry.getUrlTitle() %>" />
				</portlet:renderURL>

				
				<div class="entry-title">
					<h2>
						<c:choose>
							<c:when test='<%= strutsAction.equals("/blogs/view_entry") %>'>
								<%= HtmlUtil.escape(entry.getTitle()) %>
							</c:when>
							<c:otherwise>
								<aui:a href="<%= viewEntryURL %>"><%= HtmlUtil.escape(entry.getTitle()) %></aui:a>
							</c:otherwise>
						</c:choose>
					</h2>
				</div>
				
				<div class="entry-date-author">
					<%= dateFormatDateTime.format(entry.getDisplayDate()) %>
					<liferay-ui:message key="written-by" /> 
					<%= HtmlUtil.escape(PortalUtil.getUserName(entry)) %>
				</div>
			</div>

			<portlet:renderURL var="bookmarkURL" windowState="<%= WindowState.NORMAL.toString() %>">
				<portlet:param name="struts_action" value="/blogs/view_entry" />
				<portlet:param name="urlTitle" value="<%= entry.getUrlTitle() %>" />
			</portlet:renderURL>

			<c:if test='<%= enableSocialBookmarks && socialBookmarksDisplayPosition.equals("top") %>'>
				<liferay-ui:social-bookmarks
					displayStyle="<%= socialBookmarksDisplayStyle %>"
					target="_blank"
					title="<%= entry.getTitle() %>"
					types="<%= socialBookmarksTypes %>"
					url="<%= PortalUtil.getCanonicalURL(bookmarkURL.toString(), themeDisplay, layout) %>"
				/>
			</c:if>

			<c:if test="<%= BlogsEntryPermission.contains(permissionChecker, entry, ActionKeys.DELETE) || BlogsEntryPermission.contains(permissionChecker, entry, ActionKeys.PERMISSIONS) || BlogsEntryPermission.contains(permissionChecker, entry, ActionKeys.UPDATE) %>">
				<ul class="edit-actions entry icons-container lfr-meta-actions clearfix">
					<c:if test="<%= BlogsEntryPermission.contains(permissionChecker, entry, ActionKeys.UPDATE) %>">
						<li class="edit-entry">
							<portlet:renderURL var="editEntryURL">
								<portlet:param name="struts_action" value="/blogs/edit_entry" />
								<portlet:param name="redirect" value="<%= currentURL %>" />
								<portlet:param name="backURL" value="<%= currentURL %>" />
								<portlet:param name="entryId" value="<%= String.valueOf(entry.getEntryId()) %>" />
							</portlet:renderURL>

							<liferay-ui:icon
								image="edit"
								label="<%= true %>"
								url="<%= editEntryURL %>"
							/>
						</li>
					</c:if>

					<c:if test="<%= showEditEntryPermissions && BlogsEntryPermission.contains(permissionChecker, entry, ActionKeys.PERMISSIONS) %>">
						<li class="edit-entry-permissions">
							<liferay-security:permissionsURL
								modelResource="<%= BlogsEntry.class.getName() %>"
								modelResourceDescription="<%= entry.getTitle() %>"
								resourceGroupId="<%= String.valueOf(entry.getGroupId()) %>"
								resourcePrimKey="<%= String.valueOf(entry.getEntryId()) %>"
								var="permissionsEntryURL"
								windowState="<%= LiferayWindowState.POP_UP.toString() %>"
							/>

							<liferay-ui:icon
								image="permissions"
								label="<%= true %>"
								method="get"
								url="<%= permissionsEntryURL %>"
								useDialog="<%= true %>"
							/>
						</li>
					</c:if>

					<c:if test="<%= BlogsEntryPermission.contains(permissionChecker, entry, ActionKeys.DELETE) %>">
						<li class="delete-entry">
							<portlet:renderURL var="viewURL">
								<portlet:param name="struts_action" value="/blogs/view" />
							</portlet:renderURL>

							<portlet:actionURL var="deleteEntryURL">
								<portlet:param name="struts_action" value="/blogs/edit_entry" />
								<portlet:param name="<%= Constants.CMD %>" value="<%= TrashUtil.isTrashEnabled(scopeGroupId) ? Constants.MOVE_TO_TRASH : Constants.DELETE %>" />
								<portlet:param name="redirect" value="<%= viewURL %>" />
								<portlet:param name="entryId" value="<%= String.valueOf(entry.getEntryId()) %>" />
							</portlet:actionURL>

							<liferay-ui:icon-delete label="<%= true %>" trash="<%= TrashUtil.isTrashEnabled(scopeGroupId) %>" url="<%= deleteEntryURL %>" />
						</li>
					</c:if>
				</ul>
			</c:if>

			<div class="entry-body">
				<c:if test='<%= displayStyle.equals(BlogsUtil.DISPLAY_STYLE_ABSTRACT) %>'>
					<c:if test="<%= entry.isSmallImage() %>">
						<div class="asset-small-image">
							<img alt="" class="asset-small-image" src="<%= HtmlUtil.escape(entry.getEntryImageURL(themeDisplay)) %>" />
						</div>
					</c:if>
					
					<div class="asset-small-summary">
						<%
						String summary = entry.getDescription();

						if (Validator.isNull(summary)) {
							summary = entry.getContent();
						}
						%>

						<%= StringUtil.shorten(HtmlUtil.stripHtml(summary), pageAbstractLength) %>
					</div>
						
 
				</c:if>
				<c:if test='<%= displayStyle.equals(BlogsUtil.DISPLAY_STYLE_FULL_CONTENT) || strutsAction.equals("/blogs/view_entry") %>'>

					<%
					String entryContentId = "blogs-entry-content-" + entry.getEntryId();

					boolean inlineEditEnabled = EDITOR_INLINE_EDITING_ENABLED && BlogsEntryPermission.contains(permissionChecker, entry, ActionKeys.UPDATE) && BrowserSnifferUtil.isRtf(request) && !WorkflowDefinitionLinkLocalServiceUtil.hasWorkflowDefinitionLink(themeDisplay.getCompanyId(), scopeGroupId, BlogsEntry.class.getName()) && Validator.equals(GetterUtil.getString(SessionClicks.get(request, "liferay_toggle_controls", "visible")), "visible");
					%>

					<div id="<%= entryContentId %>" class='blogs-entry-content <%= inlineEditEnabled ? "lfr-editable":StringPool.BLANK %>' <%= inlineEditEnabled ?"contenteditable=\"true\" spellcheck=\"false\"" : StringPool.BLANK %>>
						<%= entry.getContent() %>
					</div>

					<liferay-ui:custom-attributes-available className="<%= BlogsEntry.class.getName() %>">
						<liferay-ui:custom-attribute-list
							className="<%= BlogsEntry.class.getName() %>"
							classPK="<%= entry.getEntryId() %>"
							editable="<%= false %>"
							label="<%= true %>"
						/>
					</liferay-ui:custom-attributes-available>

					<c:if test="<%= inlineEditEnabled %>">
						<portlet:actionURL var="updateEntryContent">
							<portlet:param name="struts_action" value="/blogs/edit_entry" />
							<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.UPDATE_CONTENT %>" />
							<portlet:param name="entryId" value="<%= String.valueOf(entry.getEntryId()) %>" />
						</portlet:actionURL>

						<liferay-ui:input-editor
							editorImpl="ckeditor"
							inlineEdit="<%= true %>"
							inlineEditSaveURL="<%= updateEntryContent %>"
							name="<%= entryContentId %>"
						/>
					</c:if>
				</c:if>
			</div>

			<div class="entry-footer">
				<c:if test='<%= (!strutsAction.equals("/blogs/view_entry")) && (displayStyle.equals(BlogsUtil.DISPLAY_STYLE_ABSTRACT) || displayStyle.equals(BlogsUtil.DISPLAY_STYLE_TITLE))  %>'> 
					<div class="continue-reading">
						<a class='btn btn-small' href='<%= viewEntryURL %>'><liferay-ui:message key="continue-reading" /> </a>
					</div>
				</c:if>
				<div class="stats">
					<c:if test="<%= assetEntry != null %>">
						<span class="view-count">
							<span class="fa fa-eye" title="<%=LanguageUtil.get(pageContext, (assetEntry.getViewCount() == 1) ? "view" : "views") %>">
								<%= assetEntry.getViewCount() %>
							</span>
						</span>
					</c:if>
					
					<c:if test='<%= !facebookComments %>'>
						<c:if test="<%= enableComments %>">
						
						
							<span class="comments">
								<%
								long classNameId = PortalUtil.getClassNameId(BlogsEntry.class.getName());
								int messagesCount = MBMessageLocalServiceUtil.getDiscussionMessagesCount(classNameId, entry.getEntryId(), WorkflowConstants.STATUS_APPROVED);
								%>
	
								<c:choose>
									<c:when test='<%= strutsAction.equals("/blogs/view_entry") %>'>
										<span class="fa fa-comment-o" title="<%=LanguageUtil.get(pageContext, (messagesCount == 1) ? "comment" : "comments") %>">
											<%= messagesCount %>
										</span>
									</c:when>
									<c:otherwise>
										<aui:a title='<%=LanguageUtil.get(pageContext, (messagesCount == 1) ? "comment" : "comments") %>' href='<%= PropsValues.PORTLET_URL_ANCHOR_ENABLE ? viewEntryURL : viewEntryURL + StringPool.POUND + "blogsCommentsPanelContainer" %>'>
											<span class="fa fa-comment-o" title="<%=LanguageUtil.get(pageContext, (messagesCount == 1) ? "comment" : "comments") %>">
												<%= messagesCount %>
											</span>
										</aui:a>
									</c:otherwise>
								</c:choose>
							</span>
						</c:if>
					</c:if>
				</div>

				<c:if test="<%= enableFlags %>">
					<liferay-ui:flags
						className="<%= BlogsEntry.class.getName() %>"
						classPK="<%= entry.getEntryId() %>"
						contentTitle="<%= entry.getTitle() %>"
						reportedUserId="<%= entry.getUserId() %>"
					/>
				</c:if>

				<span class="entry-categories">
					<liferay-ui:asset-categories-summary
						className="<%= BlogsEntry.class.getName() %>"
						classPK="<%= entry.getEntryId() %>"
						portletURL="<%= renderResponse.createRenderURL() %>"
					/>
				</span>

				<span class="entry-tags">
					<liferay-ui:asset-tags-summary
						className="<%= BlogsEntry.class.getName() %>"
						classPK="<%= entry.getEntryId() %>"
						portletURL="<%= renderResponse.createRenderURL() %>"
					/>
				</span>

				<c:if test='<%= displayStyle.equals(BlogsUtil.DISPLAY_STYLE_FULL_CONTENT) || strutsAction.equals("/blogs/view_entry") %>'>
					<c:if test="<%= enableRelatedAssets %>">
						<div class="entry-links">
							<liferay-ui:asset-links
								assetEntryId="<%= (assetEntry != null) ? assetEntry.getEntryId() : 0 %>"
								className="<%= BlogsEntry.class.getName() %>"
								classPK="<%= entry.getEntryId() %>"
							/>
						</div>
					</c:if>

					<c:if test='<%= enableSocialBookmarks && socialBookmarksDisplayPosition.equals("bottom") %>'>
						<liferay-ui:social-bookmarks
							contentId="<%= String.valueOf(entry.getEntryId()) %>"
							displayStyle="<%= socialBookmarksDisplayStyle %>"
							target="_blank"
							title="<%= entry.getTitle() %>"
							types="<%= socialBookmarksTypes %>"
							url="<%= PortalUtil.getCanonicalURL(bookmarkURL.toString(), themeDisplay, layout) %>"
						/>
					</c:if>

					<c:if test="<%= enableRatings %>">
						<liferay-ui:ratings
							className="<%= BlogsEntry.class.getName() %>"
							classPK="<%= entry.getEntryId() %>"
						/>
					</c:if>
				</c:if>
			</div>
		</div>

		<div class="cl"><!-- --></div>
	</c:when>
	<c:otherwise>

		<%
		if (searchContainer != null) {
			searchContainer.setTotal(searchContainer.getTotal() - 1);
		}
		%>

	</c:otherwise>
</c:choose>