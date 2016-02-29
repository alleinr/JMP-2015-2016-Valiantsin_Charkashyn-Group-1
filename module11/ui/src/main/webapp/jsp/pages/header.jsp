<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
</head>
<body>
	<div id="headlogo">
		<h1>
			<bean:message key="label.common.header" />
		</h1>
		<div id="langlink">
			<a href="lang.do?method=language&baseLocale=en"><bean:message key="label.language.english" /></a> <a href="lang.do?method=language&baseLocale=ru"><bean:message key="label.language.russian" /></a>
		</div>
	</div>
</body>
</html>