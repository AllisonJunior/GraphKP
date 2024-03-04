<h1 align="center"> GraphKP </h1>

## 1. Introdução

Vamos supor o seguinte problema: <br>

Uma companhia telefônica deseja criar uma rede interligando um conjunto de cidades. O custo para unir duas cidades por meio de cabos é conhecido mas, como toda boa companhia,
esta deseja minimizar seus gastos, fazendo as ligações mais baratas possíveis sem deixar de cobrir nenhuma das cidades. <br>

Esse e outros problemas que seguem essa mesma ideia, podem ser resumidos a achar uma Árvore Espalhada Mínima ( AEM ) para um grafo conhecido, tal problema pode ser enunciado assim: <br>

Dado um grafo G = ( V , E ) com uma função "peso" que associa valores reais w às arestas de E, deseja-se encontrar uma árvore T = ( V , E' ) onde E' está contido em E e a soma dos pesos
das arestas em E' é minima. <br>

Há uma solução genérica para este problema, apresentada abaixo, que serve de base para dois algoritmos bastante conhecidos para árvores espalhadas mínimas: os algoritmos de Kruskal e Prim. 
O algoritmo genérico mantém um conjunto de arestas A e a seguinte invariante: <br>

A cada iteração, A é subconjunto do conjunto de arestas de uma árvore espalhada mínima. <br>

O algoritmo mantém esta invariante adicionando ao conjunto A, a cada iteração, uma aresta (u,v) de maneira que a união de A com (u,v) seja um subconjunto de uma árvore espalhada mínima. 
Pelo fato de esta aresta manter a propriedade de A de ser um subconjunto de arestas de uma árvore espalhada mínima, ela é chamada de aresta segura. <br>


## 2. Algoritmo de Kruskal

## 3. Algoritmo de Prim

## 4. Como funciona
