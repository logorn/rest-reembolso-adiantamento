<div>
	<a href="/vote-no-restaurante">Votar Mais</a>
</div>

<#list eleitores as eleitor>
	Nome: ${eleitor.nome}<br/>	    
	E-mail: ${eleitor.email}<br/>
	Restaurantes preferidos: 
	<ul>
		<#list eleitor.votos as voto>
			<li>${voto.restaurante.nome}</li>
		</#list>
	</ul>		
</#list>

Votação dos restaurantes
<ul>
	<#list votosRestaurantes as restaurante, votos>
		 <li>${restaurante}: ${votos}</li>
	</#list>
</ul>

