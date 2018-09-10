function creatXmlhttp(){
		var xmlhttp;
		if (window.XMLHttpRequest)
		{
		    //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		    xmlhttp=new XMLHttpRequest();
		}
		else
		{
		    // IE6, IE5 浏览器执行代码
		    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		return xmlhttp;
	}

	function setType(id,type){
		
		var xmlhttp = creatXmlhttp();
		xmlhttp.onreadystatechange=function()
		{
			if (xmlhttp.readyState==4 && xmlhttp.status==200)
			{
				document.getElementById("type").innerHTML=xmlhttp.responseText;
			}
		}
		xmlhttp.open("GET","ybus.admin?method=type&id="+id+"&type="+type,true);
		xmlhttp.send();
		
	}
	function setState(id,state){
		var xmlhttp = creatXmlhttp();
		xmlhttp.onreadystatechange=function()
		{
			if (xmlhttp.readyState==4 && xmlhttp.status==200)
			{
				document.getElementById("state").innerHTML=xmlhttp.responseText;
			}
		}
		xmlhttp.open("GET","ybus.admin?method=state&id="+id+"&state="+state,true);
		xmlhttp.send();	
	}