<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.parmar.product.services.model.Product"%>
<%@page import="com.parmar.product.services.service.ProductLocalServiceUtil"%>
<%@page import="com.parmar.cartdetail.service.CartDetailLocalServiceUtil"%>
<%@page import="com.parmar.cartdetail.model.CartDetail"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp"%>
 <%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
 
<!------ Include the above in your HEAD tag ---------->
<portlet:defineObjects/>
      <%
    int sum=0;
      List<CartDetail> cartList=CartDetailLocalServiceUtil.getCartDetails(0, CartDetailLocalServiceUtil.getCartDetailsCount());
   %>
 
 <%
 
   int count=CartDetailLocalServiceUtil.getCartDetailsCount();
   try
   {
	   if(count > 0)
	   {
	
 %>
 
 
 
<div class="container">
    <div class="row">
        <div class="col-sm-12 col-md-10 col-md-offset-1">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th><h3><b>Product</b></h3></th>
                        <th><h3><b>Quantity</b></h3></th>
                        <th class="text-center"><h3><b>Price</b></h3></th>
                        <th class="text-center"><h3><b>Total</b></h3><b></b></th>
                        <th>Remove Item </th>
                    </tr>
                </thead>
                <tbody>
                	<%
                	  for(int i=0;i<cartList.size();i++)
                	  {
                		  
                		  Product fetchProductDetail=ProductLocalServiceUtil.getProduct(cartList.get(i).getCartDetail_Product_Id());
                		   
                	%>
                    <tr>
                        <td class="col-sm-8 col-md-6">
                        <div class="media">
                            <a class="thumbnail pull-left" href="#"> <img class="media-object" src="<%=cartList.get(i).getCartDetail_Image() %>" style="width: 72px; height: 72px;"> </a>
                            <div class="media-body">
                                <h4 class="media-heading"><a href="#">&nbsp;<%=fetchProductDetail.getProduct_Name() %></a></h4>
                                <h5 class="media-heading"> by <a href="#">&nbsp;Brand name</a></h5>
                                <span>Status: </span><span class="text-success"><strong>In Stock</strong></span>
                            </div>
                        </div></td>
                        <td class="col-sm-1 col-md-1" style="text-align: center">
                        <input type="text" readonly="true" class="form-control" id="exampleInputEmail1" value="<%=cartList.get(i).getCartDetail_Quantity()%>">
                        </td>
                        <td class="col-sm-1 col-md-1 text-center"><strong><%=cartList.get(i).getCartDetail_Price() %></strong></td>
                        				<%
                        				   int   total=(cartList.get(i).getCartDetail_Quantity() * cartList.get(i).getCartDetail_Price() );
                        					sum+=total;
                        				%>
                        
                        <td class="col-sm-1 col-md-1 text-center"><strong><%=total %></strong></td>
                        <td class="col-sm-1 col-md-1">
                         <portlet:renderURL var="removeItemToCart">
                           <%
                            String conCartId=String.valueOf(cartList.get(i).getCartDetail_Id());
                          %>
                          <portlet:param name="cartId" value="<%=conCartId %>"/>
                          </portlet:renderURL> 
                               <a href="${removeItemToCart}" class="btn btn-warning">Remove</a>
                      </td>
                    </tr>
                    <%
                	  }
                    %> 
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h5>Subtotal</h5></td>
                     </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h3>Total</h3></td>
                        <td class="text-right"><h3><strong style="color:red"><%=sum %></strong></h3></td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td>   <a  class="btn btn-success" href="<%=PortalUtil.getStaticResourceURL(request, request.getContextPath() + "/view.jsp")%>">Continue Shopping</a> </td>
                        
                        <td><button type="button" class="btn btn-success">           
                            Checkout <span class="glyphicon glyphicon-play"></span>
                           </button>  </td>
                         
                       
                      
                  
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%

	}
	   else
	   {
		   %>
		   <div class="jumbotron">
  					<h4 style="color:red;margin-left:40px;">Cart ,Is Empty!</h4>
  					 
  					<p style="margin-left: 40px"><a   class="btn btn-primary btn-lg" href="#" role="button">GoTo Home </a></p>
			</div>
		   
		   
		   
		   
		   <% 
		   
	   }
	   
}
catch(Exception e)
{
e.printStackTrace();
}
%>

