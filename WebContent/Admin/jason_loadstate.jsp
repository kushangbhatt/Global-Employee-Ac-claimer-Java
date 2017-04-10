<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="function" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="list" value="${sessionScope.state_details }"></c:set>
<c:set var="len" value="${function:length(list) }"></c:set>
[<c:forEach items="${sessionScope.state_details }" var="i" varStatus="j">
		{"state_id":"${i.id }","state_name":"${i.state }"}<c:if test="${len ne j.count }">,</c:if>
	</c:forEach>]