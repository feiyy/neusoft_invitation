$(function(){
	
	$("#QRcode").height($("#QRcode").width());
	
	jQuery("#createQRcode").qrcode({
		render: "canvas",
		width: 200,
		height: 200,
		text: $("#QRcodeNum").html(),
		typeNumber: -1,
		correctLevel: 2,
	});
	
	var mycanvas1=document.getElementsByTagName('canvas')[0];
	
	var img=convertCanvasToImage(mycanvas1);
	
	$('#createQRcode').html(img);
		
});

function convertCanvasToImage(canvas) {
	    var image = new Image();
	    image.src = canvas.toDataURL("image/png");
	    return image;
	}	