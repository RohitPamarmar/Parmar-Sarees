<%@ include file="/init.jsp"%>
<%@page import="java.util.List"%>
<%@page import="com.parmar.wihlist.service.service.WishListLocalServiceUtil"%>
<%@page import="com.parmar.wihlist.service.model.WishList"%>
<%@page import="com.parmar.product.services.service.ProductLocalServiceUtil"%>
<%@page import="com.parmar.product.services.model.Product"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.patcher.PatcherUtil"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<portlet:defineObjects/>

 
<%


String wishListProductId=null;
 List<WishList> wishRecord=WishListLocalServiceUtil.getWishLists(0,WishListLocalServiceUtil.getWishListsCount());

%>


<h1></h1>

<%
            int count=WishListLocalServiceUtil.getWishListsCount();
   
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
                        <td><h3><b>Product</b></h3></td>
                         <td class="text-center"><h3><b>Price</b></h3></td>
                        <td><h3><b>Remove Item</b></h3></td>
                         
                    </tr>
                </thead>
                <tbody>
                	<%
                       Product productObj=null;		
                	   	
                	  for(int i=0;i<wishRecord.size();i++)
                	  {
                		 int  wishProductId=wishRecord.get(i).getProduct_Id();
                		 wishListProductId=String.valueOf(wishProductId);
                		 productObj=ProductLocalServiceUtil.getProduct(wishProductId);
                		 
                				 
                	%>
                    <tr>
                        <td class="col-sm-8 col-md-6">
                        <div class="media">
                            <a class="thumbnail pull-left" href="#"> <img class="media-object" src="<%=productObj.getProduct_Image() %>" style="width: 72px; height: 72px;"> </a>
                            <div class="media-body">
                                <h4 class="media-heading"><a href="#">&nbsp;</a><%=productObj.getProduct_Name() %></h4>
                                <h5 class="media-heading"> by <a href="#">&nbsp;Brand name</a></h5>
                                
                                  <%
                                   String meg="";
                                    if(productObj.getProduct_Quantity() > 0)
                                    {
                                      
                                       %>
                                   	 <span>Status: </span><span class="text-success"><strong style="color:green">In Stock</strong></span>
                                 <!--   <input type="submit" value="Add To Cart" id="openQuantityModal" class="btn btn-success"  />
                                    -->
                                   <input type="submit"  class="btn btn-info" value="Add To Cart" id="openQuantityModal"> 
                                      <%
                                   
                                    }
                                    else
                                    {
                                    	%>
                                    	
                                    	 <span>Status: </span><span class="text-success"><strong style="color:red"> Out Of Stock</strong></span>
                                     
                                    <%
                                    }
                                  
                                  %>
                                
                               
                            </div>
                        </div>
                        </td>
                       
                        <td class="col-sm-1 col-md-1 text-center"><strong><%=productObj.getProduct_Price() %></strong></td>
                        				<%
                        				%>
                    
                        <td class="col-sm-1 col-md-1 text-center"><strong></strong></td>
                        <td class="col-sm-1 col-md-1">
                         <portlet:renderURL var="removeItemToCart">
                           <%
                           
                          %>
                          <portlet:param name="cartId" value=""/>
                          </portlet:renderURL> 
                               <a href="" class="btn btn-warning">Remove</a>
                      </td>
                    </tr>
                    <%
                	  }
                    %> 
                     
                     
                </tbody>
            </table>
        </div>
    </div>
</div>
 
 
 <style>
  .modal-header{
     background-color:white;
   }
   .modal-body{
     background-color:white;
   }
   .modal-footer{
     background-color:white;
   }
   #closeCross{  color:red;
   }
   #closeButton{  
   background-color: red;
   color:white;
   }
  </style>
  
  <portlet:actionURL var="addWishlistToCart" name="addAfterWishList">
        		
        		
        		<portlet:param name="wishListProductId" value="<%=wishListProductId %>"/>
        		
        		</portlet:actionURL>
  
  
 	<form name="" action=" ${addWishlistToCart} " method="post">
        	 
 <div class="container">
  <h2>Large Modal</h2>
  <div class="modal fade" id="myModal" role="dialog">
   <div class="modal-dialog modal-lg">
    <div class="modal-content">
     <div class="modal-header">
          <button type="button" id="closeCross" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Add To Cart</h4>
        </div>
        <div class="modal-body">
        		
       		  	
        				<div class="col-md-5">
        						<label><b><h3>Select Product Quantity :</h3></b></label>
 	    				</div>
 			   			<div class="col-md-3">
 			  					 <input type="number" name="selectQuantity" max="2" min="1" value="1" class="form-control"/>
 			  					 <br>
 			 					 <input type="submit" value="submit" id="colsePanel" class="btn btn-info" />
  	 		  			 </div>
 		 
         </div>
        <div class="modal-footer">
          <button type="button" id="closeButton" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
</div>
</form>

<script>
$(document).ready(function(){
	
	 $("#openQuantityModal").click(function(){
		 
        $("#myModal").modal('show');
	 
	 });
	 $("#colsePanel").click(function(){
		 
		 $("#myModal").modal("hide");
		 
	 });

	
});

</script>

<%
 }
	   else
	   {
		   
		    %>
			<div class="jumbotron">
  					<h4 style="color:red;margin-left: 40px;">Wish-list,Is Empty!</h4>
  					 
  					<p style="margin-left: 40px"><a class="btn btn-primary btn-lg" href="#" role="button">GoTo Home </a></p>
			</div>
	
	
	
		    <% 
	   }
}
catch(Exception e)
{
e.printStackTrace();
}

%>
