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

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ContentTypes" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.LocaleUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.xuggler.XugglerUtil" %>

<%@ page import="java.util.Locale" %>

<%
String contentsLanguageId = ParamUtil.getString(request, "contentsLanguageId");
String cssPath = ParamUtil.getString(request, "cssPath");
String cssClasses = ParamUtil.getString(request, "cssClasses");
boolean inlineEdit = ParamUtil.getBoolean(request, "inlineEdit");
String languageId = ParamUtil.getString(request, "languageId");
boolean resizable = ParamUtil.getBoolean(request, "resizable");

response.setContentType(ContentTypes.TEXT_JAVASCRIPT);
%>

if (!CKEDITOR.stylesSet.get('liferayStyles')) {
	CKEDITOR.addStylesSet(
		'liferayStyles',
		[

		// FSquare Styles
		{name: 'Carousel Title', element: 'h2', attributes: {'class': 'caroussel-title'}},
		{name: 'Carousel text', element: 'p', attributes: {'class': 'caroussel-text'}},
		
		
		// Block Styles
		{name: 'Normal', element: 'p'},
		{name: 'Heading 1', element: 'h1'},
		{name: 'Heading 2', element: 'h2'},
		{name: 'Heading 3', element: 'h3'},
		{name: 'Heading 4', element: 'h4'},

		// Special classes

		{name: 'Preformatted Text', element:'pre'},
		{name: 'Cited Work', element:'cite'},
		{name: 'Computer Code', element:'code'},

		// Custom styles

		{name: 'Info Message', element: 'div', attributes: {'class': 'portlet-msg-info'}},
		{name: 'Alert Message', element: 'div', attributes: {'class': 'portlet-msg-alert'}},
		{name: 'Error Message', element: 'div', attributes: {'class': 'portlet-msg-error'}}
		]
	);
}

CKEDITOR.config.autoParagraph = false;

CKEDITOR.config.autoSaveTimeout = 3000;

CKEDITOR.config.bodyClass = 'html-editor <%= HtmlUtil.escapeJS(cssClasses) %>';

CKEDITOR.config.closeNoticeTimeout = 8000;

CKEDITOR.config.contentsCss = ['<%= HtmlUtil.escapeJS(cssPath) %>/main.css', 'http://fonts.googleapis.com/css?family=Lato:300,400,700', '/fsquare-fonts-theme/css/main.css?minifierType=css' ];

<%
Locale contentsLocale = LocaleUtil.fromLanguageId(contentsLanguageId);

String contentsLanguageDir = LanguageUtil.get(contentsLocale, "lang.dir");
%>

CKEDITOR.config.contentsLangDirection = '<%= HtmlUtil.escapeJS(contentsLanguageDir) %>';

CKEDITOR.config.contentsLanguage = '<%= HtmlUtil.escapeJS(contentsLanguageId.replace("iw_", "he_")) %>';

CKEDITOR.config.entities = false;

CKEDITOR.config.extraPlugins = 'ajaxsave,media,restore,scayt,wsc,lineheight';

CKEDITOR.config.height = 265;

CKEDITOR.config.language = '<%= HtmlUtil.escapeJS(languageId.replace("iw_", "he_")) %>';

CKEDITOR.config.resize_enabled = <%= resizable %>;

<c:if test="<%= resizable %>">
	CKEDITOR.config.resize_dir = 'vertical';
</c:if>

CKEDITOR.config.stylesCombo_stylesSet = 'liferayStyles';

CKEDITOR.config.toolbar_editInPlace = [
	['Font', 'Styles'],
	['Bold', 'Italic', 'Underline', 'Strike'],
	['Subscript', 'Superscript', 'SpecialChar'],
	['Undo', 'Redo'],
	['SpellChecker', 'Scayt'],
	['NumberedList', 'BulletedList', '-', 'Outdent', 'Indent'], ['Source', 'RemoveFormat'],
];

CKEDITOR.config.toolbar_email = [
	['Font','FontSize', 'TextColor', 'BGColor', '-', 'Bold', 'Italic', 'Underline', 'Strike'],
	['JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock'],
	['SpellChecker', 'Scayt'],
	'/',
	['Undo', 'Redo', '-', 'Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'SelectAll', 'RemoveFormat'],
	['Source'],
	['Link', 'Unlink'],
	['Image']
];

CKEDITOR.config.toolbar_liferay = [
	['Bold', 'Italic', 'Underline', 'Strike'],

	<c:if test="<%= inlineEdit %>">
		['AjaxSave', '-', 'Restore'],
	</c:if>

	['Undo', 'Redo', '-', 'Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', ],
	['Font', 'Styles', 'FontSize', '-', 'TextColor', 'BGColor'],
	'/',
	['NumberedList', 'BulletedList', '-', 'Outdent', 'Indent'],
	['JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock'],
	['Image', 'Link', 'Unlink', 'Anchor'],
	['Flash', <c:if test="<%= XugglerUtil.isEnabled() %>"> 'Audio', 'Video',</c:if> 'Table', '-', 'Smiley', 'SpecialChar'],
	['Find', 'Replace', 'SpellChecker', 'Scayt'],
	['SelectAll', 'RemoveFormat'],
	['Subscript', 'Superscript']

	<c:if test="<%= !inlineEdit %>">
		,['Source']
	</c:if>
];

CKEDITOR.config.toolbar_liferayArticle = [
	['Font', 'Styles', 'FontSize', '-', 'TextColor', 'BGColor'],
	['Bold', 'Italic', 'Underline', 'Strike'],
	['Subscript', 'Superscript'],
	'/',
	['Undo', 'Redo', '-', 'Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'SelectAll', 'RemoveFormat'],
	['Find', 'Replace', 'SpellChecker', 'Scayt'],
	['NumberedList','BulletedList','-','Outdent','Indent','Blockquote'],
	['JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock'],
	'/',
	['Source'],
	['Link', 'Unlink', 'Anchor'],
	['Image', 'Flash', <c:if test="<%= XugglerUtil.isEnabled() %>">'Audio', 'Video',</c:if> 'Table', '-', 'Smiley', 'SpecialChar', 'LiferayPageBreak']
];

CKEDITOR.config.toolbar_phone = [
	['Font', 'Bold', 'Italic', 'Underline'],
	['NumberedList', 'BulletedList'],
	['Image', 'Link', 'Unlink']
];

CKEDITOR.config.toolbar_simple = [
	['Font', 'Bold', 'Italic', 'Underline', 'Strike'],
	['NumberedList', 'BulletedList'],
	['Image', 'Link', 'Unlink', 'Table']
];

CKEDITOR.config.toolbar_tablet = [
	['Bold', 'Italic', 'Underline', 'Strike'],
	['NumberedList', 'BulletedList'],
	['Image', 'Link', 'Unlink'],
	['JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock'],
	['Font', 'Styles', 'FontSize', 'RemoveFormat']
];

CKEDITOR.config.font_names="Lato;Roboto Condensed;Arial/Arial, Helvetica, sans-serif;Comic Sans MS/Comic Sans MS, cursive;Courier New/Courier New, Courier, monospace;Georgia/Georgia, serif;Lucida Sans Unicode/Lucida Sans Unicode, Lucida Grande, sans-serif;Tahoma/Tahoma, Geneva, sans-serif;Times New Roman/Times New Roman, Times, serif;Trebuchet MS/Trebuchet MS, Helvetica, sans-serif;Verdana/Verdana, Geneva, sans-serif;merloround_serif_regular';merloroundserifRgIt';merloround_thin_italic';merloround_thin';merloround_regular';merloround_medium_italic';merloround_medium';merloround_light_italic';merloround_light';merloround_regular_italic';merloround_bold_italic';merloround_bold';safina_script;safina_fancy;Stringbeans;Hunterswood;FaithAndGloryOne;FaithAndGloryTwo;GraduateScript;GraduateOrnaments;TheSecretRegular;TheSecretSwashes",

CKEDITOR.on(
	'dialogDefinition',
	function(event) {
		var dialogDefinition = event.data.definition;

		var onShow = dialogDefinition.onShow;

		dialogDefinition.onShow = function() {
			if (typeof onShow === 'function') {
				onShow.apply(this, arguments);
			}

			if (window.top != window.self) {
				var editorElement = this.getParentEditor().container;

				var documentPosition = editorElement.getDocumentPosition();

				var dialogSize = this.getSize();

				var x = documentPosition.x + ((editorElement.getSize('width', true) - dialogSize.width) / 2);
				var y = documentPosition.y + ((editorElement.getSize('height', true) - dialogSize.height) / 2);

				this.move(x, y, false);
			}
		}
	}
);