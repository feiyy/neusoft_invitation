$(function(){
		
	if(window.location.search == "?action=check"){
		$("title").html("我的报名表");
		$("input").prop("readonly",true);
		$(":radio").prop("disabled",true);
		$(":checkbox").prop("disabled",true);
		$("i").click(function(){
			$(this).off("click");
		});
		$("#bottom").html("确定");
		$("#bottom").click(function(){
			window.location.href = "applied.jsp";
		});
	}else if(window.location.search == "?action=update"){
		$("title").html("修改个人信息");
		$("#bottom").html("确认修改");
		$("i").click(function(){
			$("ul").slideToggle();
			});
			
			$("li").click(function(){
				$("#select").html($(this).text());
				$("ul").slideToggle();
			});
			
		$("input").focus(function(){
			$("ul").slideUp();
		});	
		
		$("#bottom").click(function(){
			$("[type=hidden]").val($("#select").html());
			$("form").attr("action","updateServlet");
			if($("#username").val()=="")
			{
				alert("请输入用户名");
				return;
			}
			if($("#telephone").val()=="" ||$("#telephone").val().length!=11)
			{
				alert("请输入正确的电话");
				return;
			}
			if($("#workplace").val()=="")
			{
				alert("请输入工作地点");
				return;
			}
			if($("#email").val()=="")
			{
				alert("请输入正确的邮箱");
				return;
			}
			var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/; 
			if(!reg.test($("#email").val()))
			{
				alert("请输入正确的邮箱");
				return;
			}
			//必须有一个checkbox选中		
			if(!ifchecked())
			{
				alert("至少选择一个日程");
			}
			else
			{
				document.forms[0].submit();
			}
			
		});
	}else{
		$("i").click(function(){
		$("ul").slideToggle();
		});
		
		$("li").click(function(){
			$("#select").html($(this).text());
			$("ul").slideToggle();
		});
		
		$("input").focus(function(){
			$("ul").slideUp();
		});
		
		$("#bottom").click(function(){
			$("[type=hidden]").val($("#select").html());
			if($("#username").val()=="")
			{
				alert("请输入用户名");
				return;
			}
			if($("#telephone").val()=="" ||$("#telephone").val().length!=11)
			{
				alert("请输入正确的电话");
				return;
			}
			if($("#workplace").val()=="")
			{
				alert("请输入工作地点");
				return;
			}
			if($("#email").val()=="")
			{
				alert("请输入邮箱");
				return;
			}
			var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/; 
			if(!reg.test($("#email").val()))
			{
				alert("请输入正确的邮箱");
				return;
			}
			//必须有一个checkbox选中			
			if(!ifchecked())
			{
				alert("至少选择一个日程");
			}
			else
			{
				document.forms[0].submit();
			}
			
		});
	}
		
});

function ifchecked()
{
	var chks = document.getElementsByName("agendar");
	for(var i=0; i<chks.length;i++)
	{
		if(chks[i].checked)
		{			
		  return true;
		}
	}	
	return false;
}
