<%@ page language="java"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script type="text/javascript">
	$(document).ready(function() {
		$("#system-setting").addClass("current");
		$("#add-user").addClass("current");
		$("#system-setting").click();
		change_password_page_init();
	});
</script>

<div id="main-content">
	<div class="clear"></div>
	<div class="content-box">
		<div class="content-box-content">
			<div class="content-box-header">
				<h3>&nbsp;</h3>
				<div class="clear"></div>
			</div>
			<form:form action="" method="post" modelAttribute="addUserForm">
			<c:if test="${hasErrors}">
			<div class="notification error png_bg">
				<a class="close" style="cursor: pointer;"><img src="images/icons/cross_grey_small.png"/></a>
				<div>
					<form:errors path="*" />
				</div>
			</div>
			</c:if>
			<table id="table1" border="0">
				<tbody>
				<tr>
					<td>username</td>
					<td><form:input path="username" class="text-input small-input" /></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>password</td>
					<td><form:password path="password" cssClass="text-input small-input"/></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>firstName</td>
					<td><form:input path="name.firstName" class="text-input small-input" /></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>lastName</td>
					<td><form:input path="name.lastName" class="text-input small-input" /></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>gender(MALE, FEMALE)</td>
					<td><form:input path="gender" class="text-input small-input" /></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>lock(LOCKED, NON_LOCKED)</td>
					<td><form:input path="lock" class="text-input small-input" /></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				</tbody>
			</table>
			<p>
				<br/>
				<input class="button" type="submit" value="提交" />
            </p>
			</form:form>
		</div>
	</div>
	<div class="clear"></div>
	<div id="footer">
		<small>
		Powered by <a href="http://grosso.iteye.com/" target="_blank">林锋</a> | <a href="mailto:grossofans@gmail.com">联系我</a>
		</small>
	</div>
</div>