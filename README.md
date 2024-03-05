_<h1 align="center"> GraphPK :brazil: </h1>_

# **Introdução**

__Para começar, vamos supor o seguinte problema:__ <br>

Uma companhia telefônica ☎️ deseja criar uma rede interligando um conjunto de cidades. O custo para unir duas cidades por meio de cabos é conhecido mas, como toda boa companhia,
esta deseja minimizar seus gastos, fazendo as ligações mais baratas possíveis sem deixar de cobrir nenhuma das cidades. <br>

Esse e outros problemas que seguem essa mesma ideia, podem ser resumidos a achar uma <a href="https://pt.stackoverflow.com/questions/22245/o-que-%C3%A9-%C3%A1rvore-geradora-m%C3%ADnima
" title="É um subgrafo acíclico que contém todos os vértices do grafo">Árvore Geradora Mínima ( MST )</a> para um grafo conhecido, tal problema pode ser enunciado assim: 
<br> <br>
**Dado um grafo G = ( V , E ) com uma função "peso" que associa valores reais w às arestas de E, deseja-se encontrar uma árvore T = ( V , E' ) onde E' está contido em E e a soma dos pesos
das arestas em E' é minima.** <br>

Há uma solução genérica para este problema, apresentada abaixo, que serve de base para dois algoritmos bastante conhecidos para árvores espalhadas mínimas os algoritmos, de: 
  - <a href="https://www.ime.usp.br/~pf/algoritmos_para_grafos/aulas/kruskal.html" title="O algoritmo de Kruskal faz crescer uma floresta geradora até que ela se torne conexa.  A floresta cresce de modo a satisfazer o critério de minimalidade de MSTs baseado em circuitos.">Kruskal</a>
  - <a href="https://www.ime.usp.br/~pf/algoritmos_para_grafos/aulas/prim.html" title="Dado um grafo não-dirigido conexo G com custos nas arestas, o algoritmo de Prim cultiva uma sub­árvore de G até que ela se torne geradora. No fim do processo, a árvore é uma MST.">Prim</a>

O algoritmo genérico mantém um conjunto de arestas A e a seguinte invariante: <br>
  - A cada iteração, A é subconjunto do conjunto de arestas de uma árvore espalhada mínima. <br>

O algoritmo mantém esta invariante adicionando ao conjunto A, a cada iteração, uma aresta (u,v) de maneira que a união de A com (u,v) seja um subconjunto de uma árvore espalhada mínima. 
Pelo fato de esta aresta manter a propriedade de A de ser um subconjunto de arestas de uma árvore espalhada mínima, ela é chamada de aresta segura. <br>

O algoritmo genérico para Árvores Espalhadas Mínimas é apresentado logo abaixo:
```
GENERIC-MST(G,w)
1 A := {}
2 while A não forma uma árvore espalhada
3       do encontre uma aresta (u,v) que é segura para A
4          A := A união {(u,v)}
5 return A
```

# **Algoritmo de Kruskal**

Ordenação das arestas: O algoritmo começa ordenando todas as arestas do grafo em ordem não decrescente de peso.
Inicialização da árvore: Inicialmente, cada vértice do grafo é uma árvore separada.
Iteração sobre as arestas: Começando com a aresta de menor peso, o algoritmo verifica se as extremidades da aresta pertencem a árvores diferentes.
Se pertencerem a árvores diferentes, a aresta é incluída na MST.
Se pertencerem à mesma árvore, a aresta é descartada para evitar a formação de ciclos.
União das árvores: Após incluir uma aresta na MST, as árvores dos vértices conectados pela aresta são fundidas em uma única árvore.

<br>

Vantagens do Algoritmo de Kruskal:
É eficiente para grafos esparsos.
Não requer uma árvore ou floresta inicial.
Funciona bem em grafos densos também.
Desvantagens do Algoritmo de Kruskal:
Pode ser menos eficiente em grafos densos, devido ao custo de ordenação das arestas.
A implementação comumente usa estruturas de dados adicionais, como Union-Find, para verificar a conectividade das árvores.

# **Algoritmo de Prim**

Escolha inicial de vértice: O algoritmo começa escolhendo um vértice arbitrário para iniciar a MST.
Adição de arestas: Em cada etapa, o algoritmo adiciona a aresta de menor peso que conecta um vértice na MST atual a um vértice fora da MST.
Atualização da MST: Após adicionar uma aresta à MST, o vértice recém-incluído é considerado parte da MST.
Repetição até a MST ser completa: O processo continua até que todos os vértices do grafo estejam na MST.

<br>

Vantagens do Algoritmo de Prim:
Geralmente é mais eficiente em grafos densos.
Pode ser implementado com complexidade de tempo melhor em algumas situações do que o algoritmo de Kruskal.
Desvantagens do Algoritmo de Prim:
Requer uma árvore ou floresta inicial, o que pode exigir processamento adicional.
Menos intuitivo para implementação em algumas situações.

# **Comparação entre os dois algoritmos**

Complexidade de Tempo: O algoritmo de Prim é geralmente mais eficiente em grafos densos, enquanto o algoritmo de Kruskal pode ser melhor em grafos esparsos, devido à necessidade de ordenação das arestas.
Estruturas de Dados: Kruskal geralmente requer uma estrutura de dados Union-Find adicional, enquanto Prim pode ser implementado com uma fila de prioridade simples.
Implementação Intuitiva: A implementação de Prim pode ser mais intuitiva para alguns programadores, pois envolve adicionar arestas diretamente à MST, enquanto Kruskal envolve verificar a conectividade das árvores.
Ambos os algoritmos são amplamente utilizados em diversas aplicações, e a escolha entre eles depende do tipo de grafo e das restrições de desempenho específicas do problema em questão.

# **Como a funciona a aplicação?**


