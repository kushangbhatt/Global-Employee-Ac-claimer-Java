<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="function" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="list" value="${sessionScope.leave_details }"></c:set>
<c:set var="len" value="${function:length(list) }"></c:set>
[<c:forEach items="${sessionScope.leave_details }" var="i" varStatus="j">
		{"leave_id":"${i.id }","days":"${i.leave_no }", "leave_desc":"${i.leave_desc }"}<c:if test="${len ne j.count }">,</c:if>
	</c:forEach>]