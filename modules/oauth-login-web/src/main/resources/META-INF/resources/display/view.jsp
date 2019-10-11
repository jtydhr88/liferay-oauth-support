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

<%@ include file="/display/init.jsp" %>

<%
long userId = themeDisplay.getUserId();

List<OAuthConnection> oAuthConnections = OAuthConnectionLocalServiceUtil.getOAuthConnectionsEnabled(true);

for (OAuthConnection oAuthConnection : oAuthConnections) {
	String expandoColumnName = String.valueOf(oAuthConnection.getOAuthConnectionId()) + "_social_account_id";

	String socailAccountId = ExpandoValueLocalServiceUtil.getData(company.getCompanyId(), User.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME, expandoColumnName, userId, StringPool.BLANK);
%>

	<%if (Validator.isNull(socailAccountId)) {%>
			<%
			String authorizeURLLinkMessage = "sign-in-by-your-x-account";

			if (themeDisplay.isSignedIn()) {
				authorizeURLLinkMessage = "bind-your-x-account";
			}
			%>

			<a href="javascript:;" onClick="getAuthorizeURL(<%= oAuthConnection.getOAuthConnectionId() %>);">login by <%= oAuthConnection.getName() %></a>

	<%} else {%>

			<portlet:actionURL name="unbindSocialAccount" var="unbindSocialAccountURL">
				<portlet:param name="oAuthConnectionId" value="<%= String.valueOf(oAuthConnection.getOAuthConnectionId()) %>" />
			</portlet:actionURL>

			you-have-bound-your-x-account<aui:a href="<%= unbindSocialAccountURL.toString() %>" label="unbind-your-account" />
	<%}%>

	<br />

<%
}
%>

<portlet:actionURL name="getAuthorizeURL" var="getAuthorizeURL" />

<aui:script use="aui-io-request">
	Liferay.provide(
		window,
		"getAuthorizeURL",
		function(oAuthConnectionId) {
			var A = AUI();

			A.io.request(
				"<%= getAuthorizeURL %>",
				{
					dataType: 'json',
					data: {
						<portlet:namespace />oAuthConnectionId: oAuthConnectionId
					},
					after: {
						success: function(event, id, obj) {
							var jsonObject = this.get('responseData');

							window.location.href = jsonObject.authorizeURL;
						}
					}
				}
			);
		}
	);
</aui:script>