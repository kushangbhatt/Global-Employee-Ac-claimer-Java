<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="function" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="list" value="${sessionScope.category_details }"></c:set>
<c:set var="len" value="${function:length(list) }"></c:set>
[<c:forEach items="${sessionScope.category_details }" var="i" varStatus="j">
		{"cat_id":"${i.id }","cat_name":"${i.cat }"}<c:if test="${len ne j.count }">,</c:if>
	</c:forEach>]