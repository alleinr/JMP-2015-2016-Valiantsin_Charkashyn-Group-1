<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">

		<s:url var="formUrl" value="/saveObject" />
		<sf:form modelAttribute="webObject" action="${formUrl}">
			<fieldset>
				<div>
					<label for="name">Name:
					</label>
					<sf:input path="name" />
				</div>		
				<div>
					<label for="stuff">Stuff:
					</label>
					<sf:input path="stuff" />
				</div>			
				<div class="submit">
					<button type="submit" name="save">
						Submit
					</button>
				</div>
			</fieldset>
		</sf:form>

	</tiles:putAttribute>
</tiles:insertDefinition>