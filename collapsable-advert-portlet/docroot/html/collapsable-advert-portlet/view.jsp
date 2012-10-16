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

<%@page import="javax.portlet.RenderRequest"%>
<%@ include file="init.jsp" %>

<%@page import="by.cnb.liferay.portlet.collapsableadvert.service.AdvertLocalServiceUtil"%>
<%@page import="by.cnb.liferay.portlet.collapsableadvert.model.*"%>
<%@page import="java.util.Random"%>
<% %>

<portlet:defineObjects />

<%
	int advertsCount = 0;
	advertsCount = AdvertLocalServiceUtil.getAdvertsCount();
	Advert currentAdvert = null;

	if (advertsCount > 0) {
		Random rndGen = new Random();
		int randomAdvertId = rndGen.nextInt(advertsCount);
		currentAdvert = AdvertLocalServiceUtil.getAdvert(randomAdvertId);
		session.setAttribute("advert", currentAdvert);
	}
%>

<c:choose>
	<c:when test="${not empty advert}">
		<div class="expand">
		    <img id="img_small" src="/../common-bsg-theme/images/advert/small_img_${advert.name}.jpg" alt="" />
		</div>

		<script type="text/javascript">
			$('.expand').hover(function() {
			    var t = setTimeout(function() {
			        $("#img_small").attr("src", '/../common-bsg-theme/images/advert/big_img_${advert.name}.jpg');
			    }, 500);
			    $(this).data('timeout', t);

			},function() {
			    clearTimeout($(this).data('timeout'));
			    $("#img_small").attr("src", '/../common-bsg-theme/images/advert/small_img_${advert.name}.jpg');
			});
		</script>
	</c:when>

	<c:otherwise>
		<liferay-ui:message key="portlet.advert.label.advertEmpty" />
	</c:otherwise>
</c:choose>


