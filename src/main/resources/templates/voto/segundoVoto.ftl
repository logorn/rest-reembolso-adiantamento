<h3>Qual desses outros restaurantes você mais gosta?</h3>
<#include "/notificacoes/erros.ftl">
<form method="POST" action="/vote-no-restaurante/final" name="restaurante"/>		
	<ul>
		<#list restaurantes as restaurante>
			<#list votosSession as voto>
				<#if restaurante.id != voto.restaurante.id>
					<li>
				    	<input type="radio" name="id" value="${restaurante.id}"> ${restaurante.nome}
				    </li>
				</#if>
			</#list>						    
		</#list>
	</ul>	
	<input type="submit" value="Enviar"/>			
</form>

<#list votosSession as voto>
	${voto.qtd}		    
	${voto.restaurante.nome}
</#list>