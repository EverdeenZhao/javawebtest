<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./CSS/style.css" type="text/css">
<script language='javascript' type="text/javascript" src='JS/jQuery.js'></script>
<title>Customer portal.</title>
</head>
<body>
<div>
	<div class="tab">
		<a class="tabs">Dashboard</a>
		<a class="tabs">Services Catalog</a>
		<a class="tabs">My Services</a>
		<a class="tabs">Admin</a>
		<a class="tabs">Support Admin</a>
	</div>
	<div class="tabcontent">
		<div class="tabitem" style="display:none;">
			Dashboard
		</div>
		<div class="tabitem">
			Services Catalog
		</div>
		<div class="tabitem">
			My Services
		</div>
		<div class="tabitem">
			Admin
		</div>
		<div class="tabitem">
			Support Admin
		</div>
	</div>
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul>
						<li><a href="#Dashboard" class="scroll">Dashboard</a></li>
						<li><button  onclick="show()">Services catalog</button></li>
						<li><a href="#My Solution" class="scroll">My Solution</a></li>
					</ul>	
					
				</div>	
<div id="Services catalog" style="display: block;">测试</div>

<script>
function show(){
	var m=getElementById("Services catalog");
	m.style.display="none"
}
</script>
</div>
</body>
</html>