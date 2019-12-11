<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>客户列表</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
</head>
<body>
	<table>
		<thead>
			<tr>
				<td>客户ID</td>
				<td>客户名称</td>
				<td>联系电话</td>
				<td>电子邮箱</td>
				<td>公司地址</td>
				<td>签约日期</td>
				<td>编辑</td>
				<td>删除</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.page.content}" var="customer">
				<tr>
					<td>${customer.custId }</td>
					<td>${customer.custName }</td>
					<td>${customer.phone }</td>
					<td>${customer.email }</td>
					<td>${customer.address }</td>
					<td><fmt:formatDate value="${customer.createDate }"
							pattern="yyyy-MM-dd" /></td>
					<td><a
						href="${pageContext.request.contextPath }/cust/${customer.custId }">编辑</a></td>
					<td><a class="cust_delete"
						href="${pageContext.request.contextPath }/cust/${customer.custId}">删除</a></td>
				</tr>
			</c:forEach>
		</tbody>
		<tr>
			<td colspan="8">总共${requestScope.page.totalElements }条记录 <a
				href="${pageContext.request.contextPath }/custs?pageNum=1&pageSize=20">首页</a>
				<c:if test="${requestScope.page.number>0 }">
					<a
						href="${pageContext.request.contextPath }/custs?pageNum=${ requestScope.page.number}&pageSize=20">上一页</a>

				</c:if> <c:if
					test="${requestScope.page.number<requestScope.page.totalPages-1}">
					<a
						href="${pageContext.request.contextPath }/custs?pageNum=${ requestScope.page.number+1+1}&pageSize=20">下一页</a>
				</c:if> <a
				href="${pageContext.request.contextPath }/custs?pageNum=${requestScope.page.totalPages}&pageSize=20">末页</a>

				共${requestScope.page.totalPages}页 当前页：第${ requestScope.page.number+1}页
			</td>
		</tr>
	</table>
	<form id="frm_cust_delete" action="" method="post">
		<input type="hidden" name="_method" value="DELETE">
	</form>
	<script type="text/javascript">
		$(function() {

			$(".cust_delete").click(function() {
				var action = $(this).attr("href");
				alert(action);
				$("#frm_cust_delete").attr("action", action).submit();
				return false;
			})

		})
	</script>
</body>
</html>
