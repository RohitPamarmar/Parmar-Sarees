 <%@ include file="/init.jsp"%>
<%@page
	import="com.parmar.product.services.service.ProductLocalServiceUtil"%>
<%@page import="com.parmar.product.services.model.Product"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@page import="java.util.List"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<portlet:defineObjects />
<style>
.modal-header {
	background-color: white;
}

.modal-body {
	background-color: white;
}

.modal-footer {
	background-color: white;
}

#close-button {
	background-color: red;
	color: white;
}

#cross-sign {
	color: red;
}
</style>


<%
	boolean openModal = false;
	List<Product> productList = ProductLocalServiceUtil.getProducts(0,
			ProductLocalServiceUtil.getProductsCount());
%>


<%
	for (int count = 0; count < productList.size(); count++) {
%>
<portlet:renderURL var="sendProductId">
	<%
		String productId = String.valueOf(productList.get(count).getProduct_Id());
	%>
	<portlet:param name="jspPage" value="/view.jsp" />
	<portlet:param name="productId" value="<%=productId%>" />
</portlet:renderURL>


<a href="${sendProductId}" > <img
	src="<%=productList.get(count).getProduct_Image() %>" width="300px"
	height="300px" /> <%=count%></a>
 

<%
	}
	try {
		String getProductID = renderRequest.getParameter("productId");
		int conId = Integer.parseInt(getProductID);
		//pageContext.setAttribute("openModal", false);
		if (!getProductID.isEmpty())

		{
			openModal = true;
			Product productObj = ProductLocalServiceUtil.getProduct(conId);
			String imgval = productObj.getProduct_Image();
			String productName = productObj.getProduct_Name();
			//pageContext.setAttribute("openModal", true);
%>

<portlet:actionURL name="addToCartDetail" var="AddtoCart">
	<%
		    String conProductId = String.valueOf(productObj.getProduct_Id());
					String conProductPrice = String.valueOf(productObj.getProduct_Price());
					String conProductQuantity = String.valueOf(productObj.getProduct_Quantity());
	%>

	<portlet:param name="productId" value="<%=conProductId%>" />
	<portlet:param name="productPrice" value="<%=conProductPrice%>" />
	<portlet:param name="productDescription"
		value="<%=productObj.getProduct_Description()%>" />
<portlet:param name="productImage"
		value="<%=productObj.getProduct_Image()%>" />

</portlet:actionURL>

<portlet:renderURL var="click">
</portlet:renderURL>

<form name="addToProduct" method="post" action="${AddtoCart}">
	<div id="myModal" class="modal fade" role="dialog">

		<div class="modal-dialog">

			<!-- Modal content-->

			<div class="modal-content">

				<div class="modal-header">
					<button type="button" id="cross-sign" class="close"
						data-dismiss="modal">&times;</button>
					<h4 class="modal-title"><%=productObj.getProduct_Name()%></h4>
				</div>

				<div class="modal-body">
					<div class="col-sm-8">
						<img src="<%=productObj.getProduct_Image() %>" width="300px"
							height="300px" />
						<%--    <img src="<%=productObj.getProduct_Image() %>" width="300px" height="300px"/>
							      --%>
					</div>
					<div class="col-sm-4" align="left">

						<h4>
							<b>product ID :</b>
							<%=productObj.getProduct_Id()%></h4>
						<input type="hidden" name=""
							value="<%=productObj.getProduct_Id()%>" />
						<h4>
							<b>Price:</b><%=productObj.getProduct_Price()%></h4>
						<h4>
							<%-- <b>Quantity:</b><%=productObj.getProduct_Quantity()%></h4> --%>
							<label style="color:black"><b>Quantity</b></label>
							<input type="number" max="5" name="ProductQuantity" min="1" value="1" class="form-control"/>
						<h4>
							<b>Description</b><%=productObj.getProduct_Description()%></h4>
							
							<%
							String pid = renderRequest.getParameter("productId");
							int conPid = Integer.parseInt(getProductID);
							   Product pobj=ProductLocalServiceUtil.getProduct(conPid); 
							   int getProductId=pobj.getProduct_Quantity() ;
							   
							   if(getProductId > 0)
							   {
								   %>
										<input type="submit" id="addcart" value="Add to Cart" style="width: 160px"
											class="btn btn-success" />

										<button class="btn btn-info"
											style="width: 160px; margin: 10px 0px 0px 0px">Buy Now</button>
								   <h1><%=getProductId %></h1>
							   <% 
							   }
							   else
							   {
								   %>	<input type="submit"  value="Add To Wishlist" style="width: 160px"
										class="btn btn-success" />
								<h1 style="color:red"> <%=getProductId %>: Out of Stock</h1>
                           <% 
								   
							   }
							%>
							
										</div>




					<%--    <img src="<%=imgval%>" width="300px" height="300px"/>
			 --%>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" id="close-button"
						data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>

</form>

<%
	}
	} catch (Exception e) {
		//e.printStackTrace();
	}
%>


<script>
	$(document).ready(function() {
		var openModal =
<%=openModal%>
	;
		if (openModal == true) {
			$("#myModal").modal();
			 
			  $("#addcart").click(function(){
				  $("#myModal").modal("hide");
			  });
			 
		}
		
	});
</script>