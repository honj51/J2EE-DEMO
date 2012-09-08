<%@ page language="java"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
	$(document).ready(function(){
		$("#system-setting").addClass("current");
		$("#list-roles").addClass("current");
		$("#system-setting").click();
	});
</script>
<div id="main-content">
	<ul class="shortcut-buttons-set">
		<li>
			<a class="shortcut-button" href="user/list-roles">
				<span>
					<img src="images/icons/pencil_48.png"/><br/>分配角色
				</span>
			</a>
		</li>
	</ul>
	<div class="clear"></div>
	<div class="content-box">
		<div class="content-box-content">
			<div class="content-box-header">
				<h3>&nbsp;</h3>
				<div class="clear"></div>
			</div>
			<table border="0">
				<thead>
					<tr>
					<th>userId</th>
					<th>userName</th>
					<th>roleId</th>
					<th>roleName</th>
					<th></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${userRoleList}" var="userRole" varStatus="s">
				<tr>
					<td>${userRole.userId}</td>
					<td>${userRole.userName}</td>
					<td>${userRole.roleId}</td>
					<td>${userRole.roleName }</td>				
					<td></td>
				</tr>
				</c:forEach>
				</tbody>
				
			</table>
		</div>
	</div>
	<div class="clear"></div>
	<div id="footer">
		<small>
			Powered by <a href="http://grosso.iteye.com/" target="_blank">林锋</a> | <a href="mailto:grossofans@gmail.com">联系我</a>
		</small>
	</div>
</div>