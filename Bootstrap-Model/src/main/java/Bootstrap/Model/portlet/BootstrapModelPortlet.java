package Bootstrap.Model.portlet;
import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.parmar.cartdetail.model.CartDetail;
import com.parmar.cartdetail.service.CartDetailLocalServiceUtil;
import com.parmar.product.services.model.Product;
import com.parmar.product.services.service.ProductLocalServiceUtil;
import com.parmar.wihlist.service.model.WishList;
import com.parmar.wihlist.service.service.WishListLocalServiceUtil;

import Bootstrap.Model.constants.BootstrapModelPortletKeys;
/**
 * @author rohit.parmar
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Bootstrap-Model Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + BootstrapModelPortletKeys.BootstrapModel,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.requires-namespaced-parameters=false"
	},
	service = Portlet.class
)
public class BootstrapModelPortlet extends MVCPortlet {
 	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
              System.out.println("Render method call "); 
              int getCartID=ParamUtil.getInteger(renderRequest, "cartId");
             
             
               try {
            	   	 
				CartDetailLocalServiceUtil.deleteCartDetail(getCartID);
				
				 
               } 
               catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                   	  
						 
              
	          super.doView(renderRequest, renderResponse);
	}
	@ProcessAction(name = "addToCartDetail")	
	public void addToCartDetail(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {
	System.out.println("----------Action Method call------------------------------------------"); 
	int productId=ParamUtil.getInteger(actionRequest, "productId");
	int productPrice=ParamUtil.getInteger(actionRequest, "productPrice");
	int productQuantity=ParamUtil.getInteger(actionRequest, "ProductQuantity");
	String productDescription=ParamUtil.getString(actionRequest , "productDescription");
	String productImage=ParamUtil.getString(actionRequest, "productImage");
	System.out.println(productId);
	System.out.println(productPrice);
	System.out.println(productQuantity);
	System.out.println(productDescription);
	System.out.println(productImage);
	int cartId=1;
	try
	{ 
				    CartDetail cartobj=CartDetailLocalServiceUtil.createCartDetail(cartId);
				    cartobj.setCartDetail_Price(productPrice);
				    cartobj.setCartDetail_Product_Id(productId);
				    cartobj.setCartDetail_Quantity(productQuantity);
				    cartobj.setCartDetail_Image(productImage);
	 
				    
				    CartDetailLocalServiceUtil.addCartDetail(cartobj);
					actionResponse.setRenderParameter("jspPage", "/addToCart.jsp");
 	 }
	catch(Exception e)
	{
		 e.printStackTrace();
	}
	System.out.println("-----------------------------------------------------------------------");
 }
	@ProcessAction(name = "addWishlist")
	public void addWishlist(ActionRequest actionRequest, ActionResponse actionResponse) {
	
System.out.println("---------------------------Wishlist-----------------------");
	 	   int getProductId=ParamUtil.getInteger(actionRequest, "WishlistProductId");
		   int dymmyId=1;
		   WishList wishListAdd=WishListLocalServiceUtil.createWishList(dymmyId);
		   wishListAdd.setProduct_Id(getProductId);
		   WishListLocalServiceUtil.addWishList(wishListAdd);
		   actionResponse.setRenderParameter("jspPage", "/addWishlist.jsp");
    }
	
	@ProcessAction(name = "addAfterWishList")
	public void addAfterWishList(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		System.out.println("---------------------------Wishlist-----------------------");
		   int getWishListId=ParamUtil.getInteger(actionRequest,"wishListProductId");
		   int dymmyId=1;
		   CartDetail cartobj=CartDetailLocalServiceUtil.createCartDetail(dymmyId);
		   Product pObj=ProductLocalServiceUtil.getProduct(getWishListId);
 	       int productPrice=pObj.getProduct_Price();
 	       int productQuantity=pObj.getProduct_Quantity();
 	       String productImage=pObj.getProduct_Image();  
 	        cartobj.setCartDetail_Price(productPrice);
		    cartobj.setCartDetail_Product_Id(getWishListId);
		    cartobj.setCartDetail_Quantity(productQuantity);
		    cartobj.setCartDetail_Image(productImage);
		    CartDetailLocalServiceUtil.addCartDetail(cartobj); 
 	        try{         	
 	        List<WishList>Wlist=WishListLocalServiceUtil.getWishLists(0, WishListLocalServiceUtil.getWishListsCount());
 	         for(int i=0;i<Wlist.size();i++)
 	         {
 	        	 if( Wlist.get(i).getProduct_Id() == getWishListId )
 	        	 {
 	            	WishList remove=WishListLocalServiceUtil.deleteWishList(Wlist.get(i).getWishList_Id());
 	         		WishListLocalServiceUtil.deleteWishList(remove);
 	        	 }
 	         }
  	        }
 	        catch(Exception e )
 	        {
 	        	e.printStackTrace();
 	        }
            actionResponse.setRenderParameter("jspPage", "/addToCart.jsp");
	 }
}