<%@page import="com.parmar.cartdetail.service.CartDetailLocalServiceUtil"%>
<%@page import="com.parmar.wihlist.service.service.WishListLocalServiceUtil"%>
<%@page import="com.parmar.wihlist.service.model.WishList"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ include file="/init.jsp"%>
<%@page import="com.parmar.product.services.service.ProductLocalServiceUtil"%>
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
 <!-- Card CSs -->
<style>
.card {
    box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
    transition: 0.3s;
    
    border-radius: 5px;
}
.card:hover {
    box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
}
img {
    border-radius: 5px 5px 0 0;
    display: inline-block;

.container {
    padding: 2px 16px;}
</style>
<!--  -->
<!--Css for image  hover  -->
<!--  -->
<%
	boolean openModal = false;
	List<Product> productList = ProductLocalServiceUtil.getProducts(0,
			ProductLocalServiceUtil.getProductsCount());

 String globalProductId=null;

%>
 <div class="container">
  <div class="col-md-4">
  </div>
     <div class="col-md-4"></div>
 	 <div class="col-md-4">
 	 
 	 <%
        int wishlistItemCount=WishListLocalServiceUtil.getWishListsCount();
 	 
 	    int cartlisrItemCount=CartDetailLocalServiceUtil.getCartDetailsCount();
 	 %>
 	 
 	  
 	 <portlet:renderURL var="addCartUrl">
 	 <portlet:param name="jspPage" value="/addToCart.jsp"/>
 	 </portlet:renderURL>
     <a href="${addCartUrl}"  class="btn btn-info btn-lg" style="margin-top: -73px;margin-left: 70px;">
    
     <span class="glyphicon glyphicon-shopping-cart"></span>  Add To Cart <span style="color:red"><b><%=cartlisrItemCount %></b></span>
     </a> 
    
    
     <portlet:renderURL var="addWishListUrl">
 	 <portlet:param name="jspPage" value="/addWishlist.jsp"/>
 	 </portlet:renderURL>
     <a href="${addWishListUrl}"  style="margin-left: 250px;margin-top: -113px;"
               class="btn btn-info btn-lg" >
     
     
    
     
     
     <span class="glyphicon glyphicon-shopping-cart"></span> WishList<span style="color:red;font-weight: 31px;"><b><%=wishlistItemCount %></b></span>  
     </a>     s
    </div> 
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
 <%-- 
<a href="${sendProductId}" > <img
	src="<%=productList.get(count).getProduct_Image() %>" width="300px"
	height="300px" /> <%=count%></a>	
 
 
  --%>
 
         <%--   <img src="<%=productList.get(count).getProduct_Image() %>" alt="Card image cap" width="300px"
	height="300px"  >
          
           --%>
           <div class="col-md-4">
			<div class="card">
 				<!--  <img src="img_avatar2.png" alt="Avatar" style="width:100%">
  				-->
                       <a href="${sendProductId}" > <img src="https://dummyimage.com/cga" width="349px" height="300px" /></a>				 				 
 				    
				 </div>
 </div>
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
<%-- 						<img src="<%=productObj.getProduct_Image() %>" width="300px"
							height="300px" />
			
			
 --%>			 			<img src="<%=productObj.getProduct_Image() %>" width="300px"
							height="300px" />
			
			
			
					</div>
					<div class="col-sm-4" align="left">

						<h4>
							<b>product ID :</b>
							<%=productObj.getProduct_Id()%></h4>
							<%
								String conWishListId=String.valueOf(productObj.getProduct_Id());
							globalProductId=conWishListId;
							%>
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
								   %>
								   
								      <portlet:actionURL var="addToWishlist" name="addWishlist">
									<portlet:param name="WishlistProductId"
										value="<%=globalProductId%>" />
								</portlet:actionURL>
								    	
								    	
								    	<H3>Demo Id is : <%=globalProductId %></H3>
								    	<a href="${addToWishlist}" id="wishlist" class="btn btn-success" style="width: 160px">Add To Wishlist </a>
								    	 
							
							
							
								<h5 style="color:red"> <%=getProductId %>: Out of Stock</h5>
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

</div>
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

			  $("#wishlist").click(function(){
				  $("#myModal").modal("hide");
			  });
			 
		}
		
	});
</script>