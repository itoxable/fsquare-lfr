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

<%@ include file="/html/taglib/ui/captcha/init.jsp" %>

<noscript>
	<iframe frameborder="0" height="300" src="<%= HttpUtil.protocolize(PropsValues.CAPTCHA_ENGINE_RECAPTCHA_URL_NOSCRIPT, request.isSecure()) %><%= PrefsPropsUtil.getString(PropsKeys.CAPTCHA_ENGINE_RECAPTCHA_KEY_PUBLIC, PropsValues.CAPTCHA_ENGINE_RECAPTCHA_KEY_PUBLIC) %>" width="500"></iframe><br />

	<textarea cols="40" name="recaptcha_challenge_field" rows="3"></textarea>

	<input name="recaptcha_response_field" type="hidden" value="manual_challenge" />
</noscript>

<div class="g-recaptcha" data-sitekey="<%= PrefsPropsUtil.getString(PropsKeys.CAPTCHA_ENGINE_RECAPTCHA_KEY_PUBLIC, PropsValues.CAPTCHA_ENGINE_RECAPTCHA_KEY_PUBLIC) %>"></div>
<script src="<%= HttpUtil.protocolize(PropsValues.CAPTCHA_ENGINE_RECAPTCHA_URL_SCRIPT, request.isSecure()) %>" type="text/javascript"></script>

