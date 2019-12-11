<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>添加客户</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/cust"
		method="post" modelAttribute="customer">
		<table>
			<c:if test="${requestScope.customer.custId != null }">
				<tr>
					<td><input type="hidden" name="_method" value="PUT"></td>
				</tr>
				<tr>
					<td><input type="hidden" name="custId"
						value="${requestScope.customer.custId }"></td>
				</tr>
			</c:if>

			<tr>
				<td>Name:</td>
				<td><form:input path="custName" /></td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td><form:input path="phone" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><form:input path="address" /></td>
			</tr>
			<tr>
				<td ><input type="submit"
					value="保存"></td>
					<td ><input type="button"
					value="返回"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
