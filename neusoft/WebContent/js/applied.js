$(function(){

	var windowHeight = $(document).height();
	if($("#bottom").height() < windowHeight){
		$("#bottom").height(windowHeight-($("#top").height()+$("#middle").height()));
	}
	
	$("#message li:first-child").click(function(){
		window.location.href = "apply.jsp?action=check";
	});
	
	$("#message li:nth-child(2)").click(function(){
		window.location.href = "apply.jsp?action=update";
	});
	
	$("#message li:last-child").click(function(){
		
		window.location.href = "E-ticket.jsp";
	});
	
	$("#loginout").click(function(){
		window.location.href = "main.jsp";
	});
	
});
