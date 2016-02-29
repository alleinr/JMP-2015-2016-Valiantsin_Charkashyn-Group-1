<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<br>
	<div id="menutitle">
		<bean:message key="menu.news" />
	</div>
	<div id="menu">
		<br>
		<ul>
			<li><html:link page="/news.do?method=list">
					<bean:message key="link.common.list" />
				</html:link></li>
			<li><html:link page="/news.do?method=add">
					<bean:message key="link.common.add" />
				</html:link></li>
		</ul>
		<br>
	</div>
	<br>
</body>
</html>
