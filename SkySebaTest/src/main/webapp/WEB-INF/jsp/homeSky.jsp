<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap -->
<link rel="stylesheet" 	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Seba Sky Json Test</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/estilos.css" rel="stylesheet">

</head>
<body>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

	<div class="container">
    <div class="row">
        <div class="col-xs-8">
    		<div class="invoice-title">
    			<h2>My Bill</h2><h3 class="pull-right"># 12345</h3>
    		</div>
    		<hr>
    		<div class="row">
    			<div class="col-xs-5">
    				<address>
    				<strong>Billed To:</strong><br>
    					Seba V<br>
    					1234 Main<br>
    					Apt. 4B<br>
    					Springfield, ST 54321
    				</address>
    			</div>
    		</div>
    	</div>
    </div>
    
 <div class="row">
    	<div class="col-md-8">
    		<div class="panel panel-default">
    			<div class="panel-heading">
    				<h4 class="panel-title"><strong>Statement:</strong></h4>
	    			<p class="text-right" ><strong>Generated: </strong>${Statement.getGenerated()} <br>
	    			 <strong>    Due: </strong>${Statement.getDue()} </p>
    			</div>
    		</div>
    	</div>
   </div>
   
    <div class="row">
    	<div class="col-md-8">
    		<div class="panel panel-default">
    			<div class="panel-heading">
    				<h4 class="panel-title "><strong>Period:</strong></h4>
	    			<p class="text-right"><strong>From: </strong> ${Statement.getPeriod().getFrom()} <br>
	    			<strong>To: </strong>${Statement.getPeriod().getTo()} </p>
    			</div>
    		</div>
    	</div>
   </div>
    
 <div class="row">
    	<div class="col-md-8">
    		<div class="panel panel-default">
    			<div class="panel-heading">
    				<h4 class="panel-title"><strong>Summary</strong></h4>
    			</div>
    			<div class="panel-body">
    				<div class="table-responsive">
    					<table class="table table-condensed">
    						<thead>
    						</thead>
    						<tbody>
								<tr>
									<td class="no-line text-left"><strong>Package: </strong></td>
									<td class="no-line text-left"> ${Package.getTotal()} </td>
								</tr>
								<tr>
									<td class="no-line text-left"><strong>Call Charges: </strong></td>
									<td class="no-line text-left">${CallCharges.getTotal()}</td>
								</tr>
								<tr>
									<td class="no-line text-left"><strong>Sky Store: </strong></td>
									<td class="no-line text-left">${Store.getTotal()} </td>
								</tr>
								<tr>
									<td class=" text-left"><strong>Total: </strong></td>
									<td class=" text-left" bgcolor="#e6e6fa" > ${Bill.getTotal()}</td>
								</tr>
							</tbody>
						</table>
    				</div>
    			</div>
    		</div>
		</div>
    </div>
    
      
    
    
   <div class="row">
    	<div class="col-md-8">
    		<div class="panel panel-default">
    			<div class="panel-heading">
    				<h4 class="panel-title"><strong>Package Subscriptions</strong></h4>
    			</div>
    			<div class="panel-body">
    				<div class="table-responsive">
    					<table class="table table-condensed">
    						<thead>
    							<tr>
        							<td class="text-left"><strong>Type</strong></td>
									<td class="text-left"><strong>Name</strong></td>
									<td class="text-left"><strong>Cost</strong></td>
                                </tr>
    						</thead>
    						<tbody>
								<c:forEach var="sub" items="${ListSubscriptions}" varStatus="loopCounter">
									<tr>
										<td class=" text-left"><h6>${sub.type}</h6></td>
										<td class=" text-left"><h6>${sub.name}</h6></td>
										<td class=" text-left"><h6>${sub.cost}</h6></td>
									</tr>
								</c:forEach>
								<tr>
									<td class="thick-line"></td>
									<td class="thick-line text-left"><strong>Subtotal: </strong></td>
									<td class="thick-line text-left" bgcolor="#e6e6fa"><strong>${Package.getTotal()} </strong>  </td>
								</tr>
							</tbody>
						</table>
    				</div>
    			</div>
    		</div>
		</div>
    </div> 
    
    
    <div class="row">
    	<div class="col-md-8">
    		<div class="panel panel-default">
    			<div class="panel-heading">
    				<h3 class="panel-title"><strong>Call Charges</strong></h3>
    			</div>
    			<div class="panel-body">
    				<div class="table-responsive">
    					<table class="table table-condensed">
    						<thead>
                                <tr>
        							<td class="text-left"><strong>Called</strong></td>
									<td class="text-left"><strong>Duration</strong></td>
									<td class="text-left"><strong>Cost</strong></td>
                                </tr>
    						</thead>
    						<tbody>
    							<c:forEach var="call" items="${ListCalls}" varStatus="loopCounter">
										<tr>
											<td class="text-left"><h6>  ${call.called} </h6></td>
											<td class="text-left"><h6> ${call.duration} </h6></td>
											<td class="text-left"><h6> ${call.cost}</h6></td>
										</tr>
								</c:forEach>
    							<tr>
    								<td class="thick-line"></td>
    								<td class="thick-line "><strong>Subtotal</strong></td>
    								<td class="thick-line " bgcolor="#e6e6fa"><strong>${CallCharges.getTotal()} </strong></td>
    							</tr>
    						</tbody>
    					</table>
    				</div>
    			</div>
    		</div>
    	</div>
    </div>
    
     <div class="row">
    	<div class="col-md-8">
    		<div class="panel panel-default">
    			<div class="panel-heading">
    				<h4 class="panel-title"><strong>Store Rentals:</strong></h4>
    			</div>
    			<div class="panel-body">
    				<div class="table-responsive">
    					<table class="table table-condensed">
    						<thead>
    							<tr>
        							<td class="text-left"><strong>Title:</strong></td>
									<td class="text-left"><strong>Cost:</strong></td>
                                </tr>    						
    						</thead>
    						<tbody>
								<c:forEach var="rent" items="${ARentals}" varStatus="loopCounter">
										<tr>
											<td class="text-left"><h6>${rent.title}</h6></td>
											<td class="text-left"><h6>${rent.cost}</h6></td>
										</tr>
								</c:forEach>
								<tr>
    								<td class="thick-line"></td>
    								<td class="thick-line"></td>
    							</tr> 						
							</tbody>
						</table>
    				</div>
    			</div>
    		</div>
		</div>
    </div>
    
     <div class="row">
    	<div class="col-md-8">
    		<div class="panel panel-default">
    			<div class="panel-heading">
    				<h4 class="panel-title"><strong>Store Buy And Keep:</strong></h4>
    			</div>
    			<div class="panel-body">
    				<div class="table-responsive">
    					<table class="table table-condensed">
    						<thead>
    							<tr>
        							<td class="text-left"><strong>Title:</strong></td>
									<td class="text-left"><strong>Cost:</strong></td>
									
                                </tr>    						
    						</thead>
    						<tbody>
								<c:forEach var="bk" items="${ListBuyAndKeep}" varStatus="loopCounter">
										<tr>
											<td class="text-left"><h6>${bk.title}</h6></td>
											<td class="text-left"><h6>${bk.cost}</h6></td>
										</tr>
								</c:forEach>
    							<tr>
    								<td class="thick-line "><strong>Subtotal</strong></td>
    								<td class="thick-line " bgcolor="#e6e6fa"><strong> ${Store.getTotal()} </strong></td>
    							</tr>
							</tbody>
						</table>
    				</div>
    			</div>
    		</div>
		</div>
    </div>
</div>

</body>
</html>