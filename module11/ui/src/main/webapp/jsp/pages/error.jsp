<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<html>
<head>
    <title></title>
</head>
<body>
	
	<bean:message key="error.message.common" />
	
    <p>Where: ${pageContext.errorData.requestURI}</p>
    <p>Type of Exception: ${pageContext.exception}</p>
    <p>Exception message: ${pageContext.exception.message}</p>
</body>
</html>