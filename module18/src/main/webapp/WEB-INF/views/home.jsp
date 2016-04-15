<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<c:choose>
			<c:when test="${fn:length(authList)>0}">
				<c:forEach var="row" items="${itemsList}">
					<tr>
						<td>${row.id}</td>
						<td>${row.name}</td>
						<td>${row.staff}</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="10">No data</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</tiles:putAttribute>
</tiles:insertDefinition>