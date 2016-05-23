<%@ page import="org.apache.axis2.context.ConfigurationContext"%>
<%@ page import="org.wso2.carbon.CarbonConstants"%>
<%@ page import="org.wso2.carbon.ui.CarbonUIUtil"%>
<%@ page import="org.wso2.carbon.utils.ServerConstants"%>
<%@ page import="org.wso2.carbon.ui.CarbonUIMessage"%>
<%@ page
	import="org.wso2.carbon.orderprocess.mgt.ui.OrderProcessManagerClient"%>
<%@ page import="org.wso2.carbon.orderprocess.mgt.data.xsd.FoodItem"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://wso2.org/projects/carbon/taglibs/carbontags.jar"
	prefix="carbon"%>

<%
	String serverURL = CarbonUIUtil.getServerURL(config.getServletContext(), session);
        ConfigurationContext configContext =
                (ConfigurationContext) config.getServletContext().getAttribute(CarbonConstants.CONFIGURATION_CONTEXT);
        String cookie = (String) session.getAttribute(ServerConstants.ADMIN_SERVICE_COOKIE);
 
        OrderProcessManagerClient client;
        FoodItem[] foodItems;
        String ConfirmMsg = "";
 
        try {
        	
            client = new OrderProcessManagerClient(configContext, serverURL, cookie);
            foodItems = client.getMenu();
         
            
            
        } catch (Exception e) {
        	
            CarbonUIMessage.sendCarbonUIMessage(e.getMessage(), CarbonUIMessage.ERROR, request, e);
%>

<script type="text/javascript">
	location.href = "../admin/error.jsp";
</script>

<%
	return;

	}
%>

<div id="middle">

	<h1>Restaurant O<sub>2</sub></h1>

		<div id="workArea">

			<form method='post'>
				<input type="submit" name="showMenu" value="Show Menu">
			</form>

			<br>

			<% 
		 if (request.getParameter("showMenu") != null) {
		%>


			<table class="styledLeft" id="moduleTable">
				<thead>
					<tr>
						<th width="20%">Item code</th>
						<th width="30%">Serving Options</th>
						<th width="30%">Price</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (FoodItem  food :foodItems ) {
				%>
					<tr>
						<td><%=food.getId()%></td>
						<td><%=food.getFoodItemName()%></td>
						<td><%=food.getFoodItemprice()%></td>
					</tr>
					<%
					}
				%>
				</tbody>
			</table>

			<%
			}
		%>		

		<br>
		<h2>Place the Order</h2>

		<form method="post">
			<select name="selectFoodItem">
				<option value="0">Ice Coffee</option>
				<option value="1">Fruit Salad</option>
				<option value="2">Milk Shake</option>
				<option value="3">Burger</option>
			</select>
			<input type="submit" name="select" value="Confirm Order">
		</form>

		<br>
		<% 
		 if (request.getParameter("select") != null) {
			 
			 System.out.println(request.getParameter("selectFoodItem"));
			 int option = Integer.parseInt(request.getParameter("selectFoodItem"));
			 ConfirmMsg = client.confirmOrder(foodItems[option].getFoodItemName(),foodItems[option].getFoodItemprice());
		%>
			 <h2><%=ConfirmMsg%></h2>
		<%
		 }
		%>
		
		</div>
</div>
