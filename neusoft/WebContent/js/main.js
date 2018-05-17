$(function() {
	var $temp = 1;
	$("#synopsis .arrows").click(function() {
		if($temp == 1) {
			$(this).rotate({
				animateTo: 180
			});
			$("#synopsis .content").slideToggle();
			$temp = 2;
		} else if($temp == 2) {
			$(this).rotate({
				angle: 0
			});
			$("#synopsis .content").slideToggle();
			$temp = 1;
		}

	})
})

$(function() {
	var $temp = 1;
	$("#unit .arrows").click(function() {
		if($temp == 1) {
			$(this).rotate({
				animateTo: 180
			});
			$("#unit .content").slideToggle();
			$temp = 2;
		} else if($temp == 2) {
			$(this).rotate({
				angle: 0
			});
			$("#unit .content").slideToggle();
			$temp = 1;
		}

	})
})

$(function() {
	var $temp = 1;
	$("#theme .arrows").click(function() {
		if($temp == 1) {
			$(this).rotate({
				animateTo: 180
			});
			$("#theme .content").slideToggle();
			$temp = 2;
		} else if($temp == 2) {
			$(this).rotate({
				angle: 0
			});
			$("#theme .content").slideToggle();
			$temp = 1;
		}

	})
})

$(function() {
	var $temp = 1;
	$("#mainContent .arrows").click(function() {
		if($temp == 1) {
			$(this).rotate({
				animateTo: 180
			});
			$("#mainContent .content").slideToggle();
			$temp = 2;
		} else if($temp == 2) {
			$(this).rotate({
				angle: 0
			});
			$("#mainContent .content").slideToggle();
			$temp = 1;
		}

	})
})

$(function() {
	var $temp = 1;
	$("#guest .arrows").click(function() {
		if($temp == 1) {
			$(this).rotate({
				animateTo: 180
			});
			$("#guest .content").slideToggle();
			$temp = 2;
		} else if($temp == 2) {
			$(this).rotate({
				angle: 0
			});
			$("#guest .content").slideToggle();
			$temp = 1;
		}

	})
})


$(function() {
	var $temp = 1;
	$("#personnel .arrows").click(function() {
		if($temp == 1) {
			$(this).rotate({
				animateTo: 180
			});
			$("#personnel .content").slideToggle();
			$temp = 2;
		} else if($temp == 2) {
			$(this).rotate({
				angle: 0
			});
			$("#personnel .content").slideToggle();
			$temp = 1;
		}

	})
})

$(function() {
	var $temp = 1;
	$("#plan .arrows").click(function() {
		if($temp == 1) {
			$(this).rotate({
				animateTo: 180
			});
			$("#plan .content").slideToggle();
			$temp = 2;
		} else if($temp == 2) {
			$(this).rotate({
				angle: 0
			});
			$("#plan .content").slideToggle();
			$temp = 1;
		}

	})
})

$(function() {
	var $temp = 1;
	$("#time .arrows").click(function() {
		if($temp == 1) {
			$(this).rotate({
				animateTo: 180
			});
			$("#time .content").slideToggle();
			$temp = 2;
		} else if($temp == 2) {
			$(this).rotate({
				angle: 0
			});
			$("#time .content").slideToggle();
			$temp = 1;
		}

	})
})

$(function() {
	var $temp = 1;
	$("#location .arrows").click(function() {
		if($temp == 1) {
			$(this).rotate({
				animateTo: 180
			});
			$("#location .content").slideToggle();
			$temp = 2;
		} else if($temp == 2) {
			$(this).rotate({
				angle: 0
			});
			$("#location .content").slideToggle();
			$temp = 1;
		}

	})
})

$(function(){
	for(var i = 1 ; i <= $("#guest table tr").length ; i++){
		if($("#guest table tr:nth-child("+i+") td:first-child").text().length == 2){
			$("#guest table tr:nth-child("+i+") td:first-child").css("letter-spacing","10px");	
		}
	}
})


/*//时间倒计时
$(function(){
    date = new Date($("#beginTime").text().replace('-','/').replace('-','/'));
	interval = setInterval(countDown,1000);
})
	

function countDown (){
	var subtract = date.getTime()-new Date();
	$("#li_first").text(padTime(Math.floor(subtract/1000/60/60/24)));
	$("#li_second").text(padTime(Math.floor(subtract/1000/60/60%24)));
	$("#li_third").text(padTime(Math.floor(subtract/1000/60%60)));
	if(subtract <= 0){
		$("#li_first").text("00").css("text-decoration","line-through");
		$("#li_second").text("00").css("text-decoration","line-through");
		$("#li_third").text("00").css("text-decoration","line-through");
		clearInterval(interval);
	}
}

function padTime (stime){
	if(stime<10){
		return "0"+stime;
	}else{
		return stime;
	}
}*/

