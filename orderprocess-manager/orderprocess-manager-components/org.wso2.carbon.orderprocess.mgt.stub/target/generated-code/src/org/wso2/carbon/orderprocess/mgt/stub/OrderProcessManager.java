

/**
 * OrderProcessManager.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v10  Built on : Sep 04, 2013 (02:02:54 UTC)
 */

    package org.wso2.carbon.orderprocess.mgt.stub;

    /*
     *  OrderProcessManager java interface
     */

    public interface OrderProcessManager {
          

        /**
          * Auto generated method signature
          * 
                    * @param getMenu1
                
         */

         
                     public org.wso2.carbon.orderprocess.mgt.data.xsd.FoodItem[] getMenu(

                        )
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getMenu1
            
          */
        public void startgetMenu(

            

            final org.wso2.carbon.orderprocess.mgt.stub.OrderProcessManagerCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param confirmItem4
                
         */

         
                     public java.lang.String confirmItem(

                        java.lang.String foodItemName5,java.lang.String foodItemPrice6)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param confirmItem4
            
          */
        public void startconfirmItem(

            java.lang.String foodItemName5,java.lang.String foodItemPrice6,

            final org.wso2.carbon.orderprocess.mgt.stub.OrderProcessManagerCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    