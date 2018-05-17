<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" charset="utf-8" />
		<title>新工科产业学院交流会暨人才培养高峰论坛邀请函</title>
		<script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>
		<script type="text/javascript" src="js/jQueryRotate.2.2.js"></script>
		<script type="text/javascript" src="js/main.js"></script>
		<link rel="stylesheet" type="text/css" href="css/main.css" />
		<style>
			@media only screen and (min-width: 640px) {
				body {
					width: 640px;
					margin: 0 auto;
				}
				#fixed {
					width: 640px;
				}
			}
		</style>
	</head>
	
<script src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>

<script>
<%
  java.util.Map<String,String> map = (java.util.Map)session.getAttribute("map");
  String nonceStr = map.get("nonceStr"); 
  String timestamp = map.get("timestamp");
  String signature = map.get("signature"); 
%>
 wx.config({
    debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
    appId: 'wx1481522e253290f2', // 必填，公众号的唯一标识
    timestamp:<%=timestamp%>, // 必填，生成签名的时间戳
    nonceStr: '<%=nonceStr%>', // 必填，生成签名的随机串
    signature: '<%=signature%>',// 必填，签名
    jsApiList: ['onMenuShareAppMessage','onMenuShareTimeline'] // 必填，需要使用的JS接口列表
}); 

wx.ready(function(){
	
	wx.onMenuShareAppMessage({
		title: '东软睿道新工科产业学院交流会暨人才培养高峰论坛邀请函', // 分享标题
		desc: '', // 分享描述
		link: location.href.split('#')[0], // 分享链接，该链接域名或路径必须与当前页面对应的公众号JS安全域名一致
		imgUrl: 'http://www.zyrc.tech/neusoft/img/Lighthouse.jpg', // 分享图标
		type: '', // 分享类型,music、video或link，不填默认为link
		dataUrl: '', // 如果type是music或video，则要提供数据链接，默认为空
		success: function () {
		// 用户确认分享后执行的回调函数
		},
		cancel: function () {
		// 用户取消分享后执行的回调函数
		}
		});
	
	wx.onMenuShareTimeline({
	    title: '东软睿道新工科产业学院交流会暨人才培养高峰论坛邀请函', // 分享标题
	    link: location.href.split('#')[0], // 分享链接，该链接域名或路径必须与当前页面对应的公众号JS安全域名一致
	    imgUrl: 'http://www.zyrc.tech/neusoft/img/Lighthouse.jpg', // 分享图标
	    success: function () {
	    // 用户确认分享后执行的回调函数
	},
	cancel: function () {
	    // 用户取消分享后执行的回调函数
	    }
	});
	
})

</script>

	<body>
		<div id="all">
			<img src="img/Lighthouse.jpg" />
			<div id="synopsis">
				<div class="head">
					<span class="title">大会简介</span>
					<img src="img/open.png" class="arrows"></img>
				</div>
				<div class="body">
					<div class="content" style="background:url(img/stamp.png);background-repeat:no-repeat;background-position:right bottom;background-size:140px">
						<p>第十六届中国软交会将以“软件定义智能新时代”为主题。旨在让人们切实体会信息化、网络化构造新行业，平台化、服务化构造新企业，社会化、生态化构造新产业的时代变革。
						</p>
						<p>“人工智能+”时代的到来，使得传统产业转型升级、新兴行业深度融合，随之而来的就是不断放大的人才缺口。作为政产学研创深度融合的参与者、实践者、推动者，相关各方都在积极推进人工智能、大数据及交叉领域的知识传播和人才储备进程，完善产教融合、校企合作、协同育人的人才培养模式，搭建新工科建设研究和交流的平台。</p>
						<p>值此契机，第十六届中国软交会将于2018年6月13日举办《“数据赋能 AI领跑”新工科产业学院交流会暨人才培养高峰论坛》。我们将邀请来自全国高校的负责人，行业内的专家领袖，共同探讨“新工科”人才培养模式，共同推进人工智能和大数据的普及应用。</p>
						<p>在此，诚挚地邀请您出席活动，拨冗莅临！</p>
						<br>
						<br>					
						<p style="text-align:right">2018年6月13日</p>
						<p style="text-align:right">第十六届中国国际软件和信息服务交易会</p>
						<br>
						<br>
						
					</div>
				</div>
			</div>

			<div id="unit">
				<div class="head">
					<span class="title">组织单位</span>
					<img src="img/open.png" class="arrows"></img>
				</div>
				<div class="body">
					<div class="content">
						<p style="font-weight: 700; margin-top: 10px; text-indent: 0;">主办单位:</p>
						<li style="margin-top: 5px;">第十六届中国国际软件和信息服务交易会</li>
						<li>CCF YOCSEF</li>
						<li>示范性软件学院联盟</li>
						<p style="font-weight: 700; margin-top: 10px; text-indent: 0;">承办单位:</p>
						<li style="margin-top: 5px;">软件架构新技术国家重点实验室</li>
						<li>国家数字化医学影像设备工程技术研究中心</li>
						<li>计算机软件国家工程研究中心</li>
						<li>东软控股有限公司</li>
						<li>东软睿道教育信息技术有限公司</li>
						
					</div>
				</div>
			</div>

			<div id="theme">
				<div class="head">
					<span class="title">会议信息</span>
					<img src="img/open.png" class="arrows"></img>
				</div>
				<div class="body">
					<div class="content">
						<p style="text-indent: 0;">会议时间：2018年6月13日</p>
						<p style="text-indent: 0;">会议地点：大连世界博览广场1号厅</p>
					</div>
				</div>
			</div>

			<div id="mainContent">
				<div class="head">
					<span class="title">会议日程</span>
					<img src="img/open.png" class="arrows"></img>
				</div>
				<div class="body">
					<div class="content" style="border: 0;">
						<img src="img/webwxgetmsgimg.jpg" />
					</div>
				</div>
			</div>
			
		<!-- 	<div id="time">
				<div class="head">
					<span class="title">时间</span>
					<img src="img/open.png" class="arrows"></img>
				</div>
				<div class="body">
					<div class="content">
						<p style="text-indent: 0;"><font id="beginTime">2018-06-13</font> ~ <font id="endTime">2018-06-15 17:00</font></p>
						<ul>
							<li id="li_first">00</li>
							<li id="li_second">00</li>
							<li id="li_third">00</li>
						</ul>
						<div>
							<span>DAYS</span>
							<span>HOURS</span>
							<span>MINUTES</span>
						</div>
					</div>
				</div>
			</div> -->

			<div id="location" style="margin-bottom: 60px;">
				<div class="head">
					<span class="title">一键导航</span>
					<img src="img/open.png" class="arrows"></img>
				</div>
				<div class="body">
					<div class="content" style="padding: 0; margin: 0;">
						<p style="margin-top: 0; margin-bottom: 20px;">会议地点：大连世界博览广场1号厅（大连市沙河口区会展路18号）</p>
						<div><iframe src="baiduMap.html" width="100%" height="260px" frameborder="0" scrolling="no"></iframe></div>
					</div>
				</div>
			</div>

			<div id="fixed">
				<a href="apply.jsp"><div id="apply">我要报名</div></a>
				<a href="applied.jsp"><div id="applied">已报名</div></a>
			</div>
		</div>
	</body>

</html>