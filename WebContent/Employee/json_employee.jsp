<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="function" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="list" value="${sessionScope.employee_details }"></c:set>
<c:set var="len" value="${function:length(list) }"></c:set>
[<c:forEach items="${sessionScope.employee_details }" var="i" varStatus="j">
<c:set var="list1" value="${i[0] }"></c:set>
<c:set var="list2" value="${i[1] }"></c:set>
		{"name_id":"${list2.id }","name":"${list2.name }"}<c:if test="${len ne j.count }">,</c:if>
	</c:forEach>]