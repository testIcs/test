/**
 * 自定义jquery插件
 */
(function($){
	//添加loadding需要的样式
	var defaultCss=".sk-fading-circle{margin:75pt auto;width:40px;height:40px;position:relative}.sk-fading-circle .sk-circle{width:100%;height:100%;position:absolute;left:0;top:0}.sk-fading-circle .sk-circle:before{content:'';display:block;margin:0 auto;width:15%;height:15%;background-color:#fff;border-radius:100%;-webkit-animation:sk-circleFadeDelay 1.2s infinite ease-in-out both;animation:sk-circleFadeDelay 1.2s infinite ease-in-out both}.sk-fading-circle .sk-circle2{-webkit-transform:rotate(30deg);transform:rotate(30deg)}.sk-fading-circle .sk-circle3{-webkit-transform:rotate(60deg);transform:rotate(60deg)}.sk-fading-circle .sk-circle4{-webkit-transform:rotate(90deg);transform:rotate(90deg)}.sk-fading-circle .sk-circle5{-webkit-transform:rotate(120deg);transform:rotate(120deg)}.sk-fading-circle .sk-circle6{-webkit-transform:rotate(150deg);transform:rotate(150deg)}.sk-fading-circle .sk-circle7{-webkit-transform:rotate(180deg);transform:rotate(180deg)}.sk-fading-circle .sk-circle8{-webkit-transform:rotate(210deg);transform:rotate(210deg)}.sk-fading-circle .sk-circle9{-webkit-transform:rotate(240deg);transform:rotate(240deg)}.sk-fading-circle .sk-circle10{-webkit-transform:rotate(270deg);transform:rotate(270deg)}.sk-fading-circle .sk-circle11{-webkit-transform:rotate(300deg);transform:rotate(300deg)}.sk-fading-circle .sk-circle12{-webkit-transform:rotate(330deg);transform:rotate(330deg)}.sk-fading-circle .sk-circle2:before{-webkit-animation-delay:-1.1s;animation-delay:-1.1s}.sk-fading-circle .sk-circle3:before{-webkit-animation-delay:-1s;animation-delay:-1s}.sk-fading-circle .sk-circle4:before{-webkit-animation-delay:-.9s;animation-delay:-.9s}.sk-fading-circle .sk-circle5:before{-webkit-animation-delay:-.8s;animation-delay:-.8s}.sk-fading-circle .sk-circle6:before{-webkit-animation-delay:-.7s;animation-delay:-.7s}.sk-fading-circle .sk-circle7:before{-webkit-animation-delay:-.6s;animation-delay:-.6s}.sk-fading-circle .sk-circle8:before{-webkit-animation-delay:-.5s;animation-delay:-.5s}.sk-fading-circle .sk-circle9:before{-webkit-animation-delay:-.4s;animation-delay:-.4s}.sk-fading-circle .sk-circle10:before{-webkit-animation-delay:-.3s;animation-delay:-.3s}.sk-fading-circle .sk-circle11:before{-webkit-animation-delay:-.2s;animation-delay:-.2s}.sk-fading-circle .sk-circle12:before{-webkit-animation-delay:-.1s;animation-delay:-.1s}@-webkit-keyframes sk-circleFadeDelay{0%,39%,to{opacity:0}40%{opacity:1}}@keyframes sk-circleFadeDelay{0%,39%,to{opacity:0}40%{opacity:1}}";
	$("style").append(defaultCss);
	jQuery.extend({
		//显示加载中
		showLoadding:function(options){
			var settings = {
		            loadText: "加载中，请稍候..."
		        };
		    $.extend(settings, options);
			$("#loadding").remove();
			var laddingDiv="<div id='loadding' style='position: fixed;width: 100%;height: 100%;background-color: #000;opacity: 0.4;padding: 80px 0;'>"
				laddingDiv+=  "<div style='position: relative;top: 165px;color: #fff;left: 35%;'>"+settings.loadText+"</div>";
				laddingDiv+=  "<div class='sk-fading-circle'>";
			    laddingDiv+=    "<div class='sk-circle1 sk-circle'></div>";
			    laddingDiv+=    "<div class='sk-circle2 sk-circle'></div>";
			    laddingDiv+=    "<div class='sk-circle3 sk-circle'></div>";
			    laddingDiv+=    "<div class='sk-circle4 sk-circle'></div>";
			    laddingDiv+=    "<div class='sk-circle5 sk-circle'></div>";
			    laddingDiv+=    "<div class='sk-circle6 sk-circle'></div>";
			    laddingDiv+=    "<div class='sk-circle7 sk-circle'></div>";
			    laddingDiv+=    "<div class='sk-circle8 sk-circle'></div>";
			    laddingDiv+=    "<div class='sk-circle9 sk-circle'></div>";
			    laddingDiv+=    "<div class='sk-circle10 sk-circle'></div>";
			    laddingDiv+=    "<div class='sk-circle11 sk-circle'></div>";
			    laddingDiv+=    "<div class='sk-circle12 sk-circle'></div>";
			    laddingDiv+=  "</div>";
			    laddingDiv+="</div>";
			$("body").prepend(laddingDiv)
		},
		//隐藏加载中
		hideLoadding:function(){
			$("#loadding").remove();
		}
	});
	
	$.formatDate = function(pattern,date){
	    //如果不设置，默认为当前时间
	    if(!date) date = new Date();
	    if(typeof(date) ==="string"){
	       if(date=="")  date = new Date();
	        else  date = new Date(date.replace(/-/g,"/"));
	    }	
	    /*补00*/
	    var toFixedWidth = function(value){
	       var result = 100+value;
	       return result.toString().substring(1);
	    };
	    
	    /*配置*/
	    var options = {
	        regeExp:/(yyyy|M+|d+|h+|m+|s+|ee+|ws?|p)/g,
	        months: ['January','February','March','April','May',
	                 'June','July', 'August','September',
	              'October','November','December'],
	        weeks: ['Sunday','Monday','Tuesday',
	                'Wednesday','Thursday','Friday',
	              'Saturday']
	    };
	    
	    /*时间切换*/
	    var swithHours = function(hours){
	      return hours<12?"AM":"PM";
	    };
	    
	    /*配置值*/
	    var pattrnValue = {
	        "yyyy":date.getFullYear(),                      //年份
	        "MM":toFixedWidth(date.getMonth()+1),           //月份
	        "dd":toFixedWidth(date.getDate()),              //日期
	        "hh":toFixedWidth(date.getHours()),             //小时
	        "mm":toFixedWidth(date.getMinutes()),           //分钟
	        "ss":toFixedWidth(date.getSeconds()),           //秒
	        "ee":options.months[date.getMonth()],           //月份名称
	        "ws":options.weeks[date.getDay()],              //星期名称
	        "M":date.getMonth()+1,
	            "d":date.getDate(),
	            "h":date.getHours(),
	            "m":date.getMinutes(),
	            "s":date.getSeconds(),
	            "p":swithHours(date.getHours())
	    };
	    
	    return pattern.replace(options.regeExp,function(){
	         return  pattrnValue[arguments[0]];
	    });
	  };
}(jQuery));