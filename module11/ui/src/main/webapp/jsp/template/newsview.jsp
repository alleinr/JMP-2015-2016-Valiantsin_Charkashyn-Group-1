<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<tiles:insert page="/jsp/layout.jsp" flush="true">
		<tiles:put name="header" value="/jsp/pages/header.jsp" />
		<tiles:put name="menu" value="/jsp/pages/menu.jsp" />
		<tiles:put name="body" value="/jsp/pages/view-body.jsp" />
		<tiles:put name="footer" value="/jsp/pages/footer.jsp" />
	</tiles:insert>
</body>
</html>