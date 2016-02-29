<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<html>
<head>

</head>
<body>
	<html:html xhtml="true" />

	<div id="uplink">
		<html:link page="/news.do?method=list">
			<bean:message key="menu.news" />
		</html:link>
		>>
		<bean:message key="menu.add" />
	</div>
	<div class="posttable">
		<html:form action="/news.do?method=save">
			<TABLE border=0>
				<tr>
					<td id="titlecolumn"><bean:message key="label.common.title" /></td>
					<td id="datacolumn"><input type="text"
						name="newsMessage.title"
						value="<bean:write property="newsMessage.title" name="newsForm" />"
						maxlength="100" id="Txt001"
						onkeyup="countSymbols(100,'Txt001','countdownTxt001');"
						onkeydown="countSymbols(100,'Txt001','countdownTxt001');" /></td>
					<td><span id="countdownTxt001">0 / 100</span></td>
				</tr>
				<tr>
					<td id="titlecolumn"><bean:message key="label.common.date" /></td>
					<td id="datacolumn"><input type="text"
						name="newsMessage.postDate"
						value="<bean:write property="newsMessage.postDate" name="newsForm" formatKey='inner.date.format'/>"
						id="Txt003" /></td>
					<td></td>
				</tr>
				<tr>
					<td id="titlecolumn"><bean:message key="label.common.brief" /></td>
					<td id="datacolumn"><textarea name="newsMessage.brief"
							maxlength="500" id="TxtA001"
							onkeyup="countSymbols(500,'TxtA001','countdownTxtA001');"
							onkeydown="countSymbols(500,'TxtA001','countdownTxtA001');"><bean:write
								property="newsMessage.brief" name="newsForm" /></textarea></td>
					<td><span id="countdownTxtA001">0 / 500</span></td>
				</tr>
				<tr>
					<td id="titlecolumn"><bean:message key="label.common.text" /></td>
					<td id="datacolumn"><textarea name="newsMessage.content"
							maxlength="2000" id="TxtA002"
							onkeyup="countSymbols(2000,'TxtA002','countdownTxtA002');"
							onkeydown="countSymbols(2000,'TxtA002','countdownTxtA002');"><bean:write
								property="newsMessage.content" name="newsForm" /></textarea></td>
					<td><span id="countdownTxtA002">0 / 2000</span></td>
				</tr>
				<tr>
					<td colspan=2>
						<div id="addbutton">
							<html:submit onclick="return checkEmptyAreas()" styleId="button">
								<bean:message key="button.save" />
							</html:submit>
							</html:form>
							<html:form action="/news.do?method=cancel">
								<html:submit styleId="button">
									<bean:message key="button.cancel" />
								</html:submit>
							</html:form>
						</div>
					</td>
				</tr>
			</TABLE>
	</div>
</body>
</html>