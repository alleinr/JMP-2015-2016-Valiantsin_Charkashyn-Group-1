<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div id="uplink">
		<html:link page="/news.do?method=list">
			<bean:message key="menu.news" />
		</html:link>
		>>
		<bean:message key="menu.view" />
	</div>
	<div class="posttable">
		<TABLE border="0">
			<tr>
				<td id="titlecolumn"><bean:message key="label.common.title" /></td>
				<td id="datacolumn">
					<p><bean:write property="newsMessage.title" name="newsForm" /></p>
				</td>
			</tr>
			<tr>
				<td id="titlecolumn"><bean:message key="label.common.date" /></td>
				<td id="datacolumn"><p><bean:write property="newsMessage.postDate" name="newsForm"
							formatKey='inner.date.format' /></p></td>
			</tr>
			<tr>
				<td id="titlecolumn"><bean:message key="label.common.brief" /></td>
				<td id="datacolumn">
					<p><bean:write property="newsMessage.brief" name="newsForm" /></p>
				</td>
			</tr>
			<tr>
				<td id="titlecolumn"><bean:message key="label.common.text" /></td>
				<td id="datacolumn">
					<p><bean:write property="newsMessage.content" name="newsForm" /></p>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right" id="titlecolumn"><html:form
						action="/news.do?method=edit">
						<html:submit  styleId="button">
							<bean:message key="button.edit" />
						</html:submit>
					</html:form> <html:form action="/news.do?method=delete">
						<html:hidden property="selectedItems"
							value="${newsForm.newsMessage.id}" />
						<html:submit onclick="return sureDelete()"  styleId="button">
							<bean:message key="button.delete" />
						</html:submit>
					</html:form></td>
			</tr>
		</TABLE>
		<br /> <br />
	</div>
</body>
</html>