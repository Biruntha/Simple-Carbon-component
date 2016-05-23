package org.wso2.carbon.orderprocess.mgt.ui;
 
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.context.ConfigurationContext;
import org.wso2.carbon.orderprocess.mgt.data.xsd.FoodItem;
import org.wso2.carbon.orderprocess.mgt.stub.OrderProcessManagerStub;


import java.rmi.RemoteException;
 
public class OrderProcessManagerClient {
	
    private OrderProcessManagerStub stub;
 
    public OrderProcessManagerClient(ConfigurationContext configCtx, String backendServerURL, String cookie) throws Exception{
    	
        String serviceURL = backendServerURL + "OrderProcessManager";
        stub = new OrderProcessManagerStub(configCtx, serviceURL);
        ServiceClient client = stub._getServiceClient();
        Options options = client.getOptions();
        options.setManageSession(true);
        options.setProperty(org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING, cookie);
    }
 
    public FoodItem[] getMenu() throws Exception{
    	
        try{
        	   	
            return stub.getMenu();
            
        }catch (RemoteException e) {
        	
            String msg = "Cannot get the list of Food Items"
                    + " . Backend service may be unavailable";
            
            throw new Exception(msg, e);
        }
        
    }
    
    
    public String confirmOrder(String SelectedFoodItemName, String SelectedFoodItemPrice) throws Exception{
		
    	try{
    		
    		
	    	String message = stub.confirmItem(SelectedFoodItemName,SelectedFoodItemPrice);
	    	
	    	return message;
	    	
    	}catch(RemoteException e){
    		
    		String error = "Problem in retrieving food items";
            
            throw new Exception(error, e);
    		
    	}
    	
	}
    
}