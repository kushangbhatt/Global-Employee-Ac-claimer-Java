<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="function" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="list" value="${sessionScope.ulist }"></c:set>
<c:set var="len" value="${function:length(list) }"></c:set>
[<c:forEach items="${sessionScope.ulist }" var="i" varStatus="j">
		{"loan_id":"${i.id }","rate":"${i.rate }", "amount":"${i.amount}", "loan_desc":"${i.loan_desc }"}<c:if test="${len ne j.count }">,</c:if>
	</c:forEach>]