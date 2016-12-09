<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>简易贷</title>
<link rel="stylesheet" type="text/css" href="../css/JDstyle.css" />
<style type="text/css">
	#question2, #question3, #question4, #question5, #question6, #question7, #resultPage{
		display: none;
	}
</style>
</head>
<body>
<div class="wrapper">
	<div class="top">
    	<div class="topleft"></div>
        <div class="topright"><a href="/zxkj/home/home.do">首页</a></div>
    </div>
    <div class="content">
    	<div class="space"></div>
    	<div class="face-title">测一测你能贷多少钱？</div>
        <div class="testblock">
        	<div id="question1">
	       	  	<div class="test-title">1、您的年龄？</div>
	            <div class="test-option">
					<a href="javaScript:void(0)" id="11"><b><img src="/zxkj/css/images/1.png" /></b><span>18~25岁</span></a>
					<a href="javaScript:void(0)" id="22"><b><img src="/zxkj/css/images/2.png" /></b><span>26~32岁</span></a>
					<a href="javaScript:void(0)" id="33"><b><img src="/zxkj/css/images/3.png" /></b><span>33~39岁</span></a>
					<a href="javaScript:void(0)" id="34"><b><img src="/zxkj/css/images/4.png" /></b><span>40~45岁</span></a>
	            </div>
            </div>
            <div id="question2">
	       	  	<div class="test-title">2、您的学历？</div>
	            <div class="test-option">
					<a href="javaScript:void(0)" id="11"><b><img src="/zxkj/css/images/gaozhong.png" /></b><span>高中</span></a>
					<a href="javaScript:void(0)" id="15"><b><img src="/zxkj/css/images/dazhuan.png" /></b><span>大专</span></a>
					<a href="javaScript:void(0)" id="20"><b><img src="/zxkj/css/images/benke.png" /></b><span>本科</span></a>
					<a href="javaScript:void(0)" id="25"><b><img src="/zxkj/css/images/shuoshi.png" /></b><span>硕士</span></a>
					<a href="javaScript:void(0)" id="30"><b><img src="/zxkj/css/images/boshi.png" /></b><span>博士</span></a>
					<a href="javaScript:void(0)" id="5"><b><img src="/zxkj/css/images/qita.png" /></b><span>其他</span></a>
	            </div>
            </div>
            <div id="question3">
	       	  	<div class="test-title">3、婚否？</div>
	            <div class="test-option">
					<a href="javaScript:void(0)" id="9"><b><img src="/zxkj/css/images/yihun.png" /></b><span>已婚</span></a>
					<a href="javaScript:void(0)" id="7"><b><img src="/zxkj/css/images/weihun.png" /></b><span>未婚</span></a>
	            </div>
            </div>
            <div id="question4">
	       	  	<div class="test-title">4、房产？</div>
	            <div class="test-option">
					<a href="javaScript:void(0)" id="10"><b><img src="/zxkj/css/images/5.png" /></b><span>租房</span></a>
					<a href="javaScript:void(0)" id="20"><b><img src="/zxkj/css/images/6.png" /></b><span>名下一套房产</span></a>
					<a href="javaScript:void(0)" id="30"><b><img src="/zxkj/css/images/7.png" /></b><span>名下多套房产</span></a>
	            </div>
            </div>
            <div id="question5">
	       	  	<div class="test-title">5、工作？</div>
	            <div class="test-option">
					<a href="javaScript:void(0)" id="5"><b><img src="/zxkj/css/images/8.png" /></b><span>自由职业</span></a>
					<a href="javaScript:void(0)" id="8"><b><img src="/zxkj/css/images/9.png" /></b><span>工薪族</span></a>
					<a href="javaScript:void(0)" id="2"><b><img src="/zxkj/css/images/10.png" /></b><span>个体工商户</span></a>
					<a href="javaScript:void(0)" id="10"><b><img src="/zxkj/css/images/11.png" /></b><span>企业法人或股东</span></a>
	            </div>
            </div>
            <div id="question6">
	       	  	<div class="test-title">6、信贷信息？</div>
	            <div class="test-option">
					<a href="javaScript:void(0)" id="10"><b><img src="/zxkj/css/images/12.png" /></b><span>有信用卡</span></a>
					<a href="javaScript:void(0)" id="13"><b><img src="/zxkj/css/images/13.png" /></b><span>有房贷</span></a>
					<a href="javaScript:void(0)" id="16"><b><img src="/zxkj/css/images/14.png" /></b><span>有车贷</span></a>
					<a href="javaScript:void(0)" id="19"><b><img src="/zxkj/css/images/15.png" /></b><span>房车贷均有</span></a>
					<a href="javaScript:void(0)" id="21"><b><img src="/zxkj/css/images/16.png" /></b><span>其他类贷款</span></a>
	            </div>
            </div>
            <div id="question7">
	            <div class="test-title">7、您的税后年收入？</div>
	            <div class="test-option">
					<div class="option-in">
	                	<span class="option-span">输入金额</span>
	                	<input id="income" type="number" class="option-input" />
	                	<a href="javaScript:void(0)">
	                		<input id="confirm" type="button" value="确定" class="option-button"/>
	                	</a>
	                </div>              
	            </div>
            </div>
            <div class="test-result"></div>
            <input id="extra" type="hidden" value="0">
            
             <div class="testblock" id="resultPage">
	       	  	<div class="test-txt">
	            	恭喜，您的可贷额度为<span class="red" id="hilt">0元</span>;<br />
	                只需首付<span class="red" id="shoufu">0元</span>就可以买到价值<span class="red" id="carprice">0元</span>的车<br />(不含购置税和保险)。<br />
	                申请贷款时请确保证明材料真实且与所填信息相同。
	            </div>
	            <div class="apply-block-button" style="width:1280px;">
	            	<a href="/zxkj/home/test.do"><input name="" type="button" value="重新测试" style="font-size:24px;" /></a>
	                <a href="/zxkj/home/home.do"><input name="" type="button" value="返回首页" style="font-size:24px;" /></a>
	            </div>
	        </div>
        
        </div>
	</div>
</div>
</body>
<script type="text/javascript" src="../3th/jquery.min.js"></script>
<script>
	$(function(){
		$(".test-option a").click(function(){
			var aobj = $(this);//当前点击的对象
			var divid = aobj.parent().parent().attr("id");//所属顶级的divid
			var imgsrc = aobj.find("img").attr("src");//点击的图片地址
			var title = aobj.find("span").text();
			
			//当前问题隐藏 下一个问题显示
			$("#"+divid).hide("slow");
			$("#"+divid).next("div").show("slow");
			
			//显示结果
			$(".test-result").append("<div class='element'><span><img src="+imgsrc+" /></span><em>"+title+"</em></div>");
			
			//额外值累加
			var extraInput = $("#extra").val();//隐藏域中 已有的值
			var extra = aobj.attr("id");//选中的值
			
			$("#extra").val(parseInt(extraInput)+parseInt(extra));
		})
		
		$("#confirm").click(function(){
			var income = $("#income").val();//输入的税后年收入
			var extraInput = $("#extra").val();//隐藏域中 已有的值
			
			//用于测试的年收入 年收入+额外值
			var testIncome = parseInt(income)+parseInt(extraInput);
			
			//贷款额度
			var hilt,shoufu,carprice;
			if(testIncome<=33000)
			{
				hilt = 70000;
				shoufu=57000;
				carprice = 127300;
			}
			else if(testIncome>238000)
			{
				hilt = 500000;
				shoufu = 166700;
				carprice = 666700;
			}else
			{
				hilt = testIncome* parseFloat(2.1)
				shoufu = testIncome * parseFloat(0.7);
				carprice = testIncome*parseFloat(2.8)
			}
			
			//赋值结果
			$("#hilt").text(hilt.toFixed(2)+"元");
			$("#shoufu").text(shoufu.toFixed(2)+"元");
			$("#carprice").text(carprice.toFixed(2)+"元");
			
			//隐藏问题7页面
			$("#question7").hide("slow");
			//隐藏结果项
			$(".test-result").hide("slow");
			
			//显示结果页面
			$("#resultPage").show("slow");
		})
	})
</script>
</html>