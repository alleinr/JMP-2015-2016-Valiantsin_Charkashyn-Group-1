<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<html>

<head>

<link rel="stylesheet" type="text/css" href="./css/stylesheet.css" />
<script type="text/javascript" src="./js/validations.js"></script>
<script>
	var msg = msg || {};
	msg.length = {
		quantityerror: "<bean:message key= "error.message.quantity" />",
		dateerror: "<bean:message key= "error.message.daterror" />",
		noselected: "<bean:message key= "error.message.noselected" />",
		required: "<bean:message key= "error.message.required" />",
		sure: "<bean:message key= "message.sure" />",
		dayerror: "<bean:message key= "error.message.dayerror" />",
		montherror: "<bean:message key= "error.message.montherror" />",
		yearerror:	"<bean:message key= "error.message.yearerror" />",
		notitle: "<bean:message key= "error.message.notitle" />",
		nobrief:	"<bean:message key= "error.message.nobrief" />",
		nocontent:	"<bean:message key= "error.message.nocontent" />",
		nodate:	"<bean:message key= "error.message.nodate" />"
	};
</script>
<title><bean:message key="head.main" /></title>
</head>
<body>
	<div class="m">
		<div class="header">
			<tiles:insert attribute="header" />
		</div>
		<div class="worktable">
			<div class="menubar">
				<tiles:insert attribute="menu" />
			</div>
			<div class="posts">
				<tiles:insert attribute="body" />
			</div>
		</div>
		<div class="footer">
			<tiles:insert attribute="footer" />
		</div>
	</div>
</body>
</html>
