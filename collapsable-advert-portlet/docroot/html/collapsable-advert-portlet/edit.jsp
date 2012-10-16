<%--
/**
* Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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
<%@ include file="init.jsp" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

	<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
	<%--
		PortletURL multiselectUrl = renderResponse.createActionURL();
	--%>
	<%--<div><portlet:namespace /></div>
	<DIV class=lfr-upload-container id="<portlet:namespace />testaui_holder"></DIV>
	<aui:script use="liferay-upload">
			new Liferay.Upload({
			allowedFileTypes: '*.*',
			container: '#<portlet:namespace />testaui_holder',
			maxFileSize: 1024,
			namespace:'<portlet:namespace />',
			uploadFile: '<%=multiselectUrl--%><%--',
			buttonHeight: 300,
			buttonText: 'Upload',
			buttonWidth: 300,
			fallbackContainer: '#<portlet:namespace />testaui_fallback',
			});
	</aui:script>
	--%>

	<script type="text/javascript">
		function send()
		{
			document.UploadForm.submit();
        }
	</script>

	<%--<form name="UploadForm" action="<portlet:actionURL/>" enctype="multipart/form-data" method="POST">
	  small Img<input type="file" name="smallImg" size="50"><br>
	 	<input type="file" name="bigImg" size="50"><br>
		<input type="Submit" value="Upload File" onClick="send()"><br>
	</form>
 --%>

	<div id="advert-form-wrapper">
		<form name="UploadForm" action="<portlet:actionURL/>" enctype="multipart/form-data" method="POST">
			<div id="advert-name">
				<span><liferay-ui:message key="portlet.advert.label.name" />:</span>
				<span><input id="advert_name" name="advert_name" type="text" /></span>
				<%--<button><liferay-ui:message key="portlet.advert.label.selection" /></button> --%>
			</div>

			<div id="advert-first-img">
				<span><liferay-ui:message key="portlet.advert.label.smallImg" />:</span>
				<span><input name="small_img" type="file"/></span>
				<%--<button><liferay-ui:message key="portlet.advert.label.selection" /></button> --%>
			</div>

			<div id="advert-second-img">
				<span><liferay-ui:message key="portlet.advert.label.bigImg" />:</span>
				<span><input name="big_img" type="file" /></span>
				<%-- <button><liferay-ui:message key="portlet.advert.label.selection" /></button>--%>
			</div>

			<div class="advert-btn-bar">
				<input type="submit" value="<liferay-ui:message key="portlet.advert.label.addBtn" />" onclick="send()"/>
			</div>
			<liferay-ui:error key="save-error" message="portlet.advert.error"></liferay-ui:error>
			<liferay-ui:success key="save-success" message="portlet.advert.success" />
		</form>
	</div>
