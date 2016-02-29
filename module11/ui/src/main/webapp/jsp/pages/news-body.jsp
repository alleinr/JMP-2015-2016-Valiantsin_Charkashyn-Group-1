<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function hideButton() {
		var error = document.getElementById('errorNews');
		if (error != null) {
			document.getElementById('deleteButton').style.visibility = 'hidden';
		}
	}
</script>
</head>
<body>
	<div id="uplink">
		<html:link page="/news.do?method=list">
			<bean:message key="menu.news" />
		</html:link>
		>>
		<bean:message key="menu.list" />
		<html:messages id="errorNews" property="error.newslistempty">
			<div style="color: red" id="errorNews" onshow="">
				<bean:write name="errorNews" />
			</div>
		</html:messages>
	</div>
	<div class="posttable">
		<html:form action="/news.do?method=delete">
			<logic:iterate id="news" property="newsList" name="newsForm">
				<div class="post">

					<div id="title">
						<p><b><bean:write name="news" property="title" /></b></p>
					</div>

					<div id="postdate">
						<p><bean:write name="news" property="postDate"
								formatKey='inner.date.format' /></p>
					</div>

					<div id="brief">
						<p><bean:write name="news" property="brief" /></p>
					</div>
					<div id="postlinks">
						<html:link action="/news.do?method=view">
							<html:param name="id">
								<bean:write name="news" property="id" />
							</html:param>
							<bean:message key="link.common.view" />
						</html:link>
						<html:link action="/news.do?method=edit">
							<html:param name="id">
								<bean:write name="news" property="id" />
							</html:param>
							<bean:message key="link.common.edit" />
						</html:link>
						<html:multibox name="newsForm" property="selectedItems"
							styleId="boxes">
							<bean:write name="news" property="id" />
						</html:multibox>
					</div>
				</div>
			</logic:iterate>
	</div>
	<html:submit onclick="return requireCheckboxes()"
		styleId="deleteButton">
		<bean:message key="button.delete" />
	</html:submit>
	</html:form>
	<script type="text/javascript">
		hideButton()
	</script>
</body>
</html>




