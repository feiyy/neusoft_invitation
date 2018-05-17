<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" charset="utf-8" />
		<title>我的电子票</title>
		<script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>
		<script type="text/javascript" src="https://cdn.bootcss.com/jquery.qrcode/1.0/jquery.qrcode.min.js"></script>
		<script type="text/javascript" src="js/E-ticket.js" ></script>
		<link rel="stylesheet" href="css/font-awesome.min.css" />
		<link rel="stylesheet" type="text/css" href="css/E-ticket.css"/>
		<style>
			@media only screen and (min-width: 640px) {
				
				body
				{
					width: 640px;
					margin: 0 auto;
				}
		
			}
		</style>
	</head>
	<body>
		<div id="top">
			我的电子票
			<i class="fa fa-user-circle" aria-hidden="true"></i>
		</div>
		<div id="middle">
			会议现场，出示二维码实现签到
		</div>
		<div id="bottom">
			<div id="usernameTicket">【${u.username}】的电子票</div>
			<div id="number">电子票编号: <span id="QRcodeNum">${u.userQRcode}</span></div>
			<div id="QRcode">
				<div id="createQRcode" name="canvas"></div>
			</div>
		</div>
	</body>
</html>
