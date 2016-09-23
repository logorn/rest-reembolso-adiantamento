<#if errors??>
	<ul>
		<#list errors as error>
			<li>${error.field} ${error.defaultMessage}</li>
		</#list>
	</ul>	
</#if>