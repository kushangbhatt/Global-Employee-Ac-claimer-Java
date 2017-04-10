<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="function" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="list" value="${sessionScope.subcat_details }"></c:set>
<c:set var="len" value="${function:length(list) }"></c:set>
[<c:forEach items="${sessionScope.subcat_details }" var="i" varStatus="j">
		{"subcat_id":"${i.id }","subcat_name":"${i.subcat }"}<c:if test="${len ne j.count }">,</c:if>
	</c:forEach>]