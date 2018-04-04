<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<portlet:defineObjects/>
<h1>Welcome </h1>
<%
 String getValue=ParamUtil.getString(request, "getWishListId");
%>

<%=getValue %>
 