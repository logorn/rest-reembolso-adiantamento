<h3>Qual desses dois restaurantes você mais gosta?</h3>
<#include "/notificacoes/erros.ftl">
<form method="POST" action="/vote-no-restaurante" name="restaurante"/>		
	<ul>
		<#list restaurantes as restaurante>
			<#if restaurante?counter == 3>
				<#break>
			</#if>
		    <li>
		    	<input type="radio" name="id" value="${restaurante.id}"> ${restaurante.nome}
		    </li>
		</#list>
	</ul>
	<input type="submit" value="Enviar"/>					
</form>