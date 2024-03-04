/*
  Essa classe busca representar um grafo qualquer, com alguns metódos de
  suporte aos metódos que aplicam os algoritmos de Kruskal e Prim.
*/
package implementation;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;





public class Grafo
{
      // Quantidade de vértices e lista de adjacência
      private int vertices;
      private LinkedList < Aresta > [] adjacencia;
      
      // Construtor do grafo
      public Grafo ( int _vertices )
      {
            this . vertices = _vertices;
            this . adjacencia = new LinkedList [ vertices ];
            
            for ( int kaj = 0 ; kaj < vertices ; kaj ++ ) adjacencia [ kaj ] = new LinkedList <> ();
      }
      
      // Metódo para adicionar uma aresta ao grafo
      public void adicionar_Aresta ( int _origem , int _destino , int _peso )
      {
            Aresta ref = new Aresta ( _origem , _destino , _peso );
            adjacencia [ _origem ] . add ( ref );
      }
      
      // [ DEBUG ] Metódo para imprimir no console o MST gerado pelo algoritmo de Kruskal
      public void debug_printarMST_Kruskal ( Aresta [] _resultado )
      {
            System . out . println ( "Arestas do MST gerado pelo algoritmo de Kruskal: \n" );
            for ( Aresta ref : _resultado )
                  System . out . println ( ref . get_origem () + " --> " + ref . get_destino () + " : " + ref . get_peso () );
      }
      
      // Método para imprimir no console a MST gerada pelo algoritmo de Prim
      public void debug_printarMST_Prim ( int [] _parent , LinkedList < Aresta > [] _grafo )
      {
            System . out . println ( "Arestas do MST gerado pelo algoritmo de Prim: \n" );
            
            // Verifica se o vértice tem um pai na MST
            for ( int kaj = 1 ; kaj < vertices ; kaj ++ ) if ( _parent [ kaj ] != -1 )
            {
               int u = _parent [ kaj ] , v = kaj , peso = -1;
               
               for ( Aresta aresta : _grafo [ u ] ) if ( aresta . get_destino () == v )
               {
                   peso = aresta . get_peso ();
                   break;
               }
               
                if ( peso != -1 ) System . out . println ( u + " --> " + v + " : " + peso );
                else              System . out . println ( "Aresta inválida: " + u + " --> " + v );
            }
            else System . out . println ( "Aresta inválida: " + _parent [ kaj ] + " --> " + kaj );
      }
      
      // Metódo para encontrar o subconjunto de um elemento qualquer 'kaj'
      public int busca ( int [] _parente , int kaj )
      {
            if ( _parente [ kaj ] == -1 ) return kaj;
                                          return busca ( _parente , _parente [ kaj ] );
      }
      
      // Metódo para unir dois subconjuntos
      public void union ( int [] _parente , int _x , int _y )
      {
            int xSet = busca ( _parente , _x );
            int ySet = busca ( _parente , _y );
            
            _parente [ xSet ] = ySet;
      }
      
      // Método da aplicação do algoritmo de Kruskal para encontrar o MST do grafo
      public void execMST_Kruskal ()
      {
            // Inicialização de variáveis
            Aresta [] resultado = new Aresta [ vertices - 1 ];
            int [] parente = new int [ vertices ];
            Arrays . fill ( parente , -1 );
            int totalArestas = 0;
            
            // Adiciona o tamanho da lista de adjacência de cada vértice
            for ( int kaj = 0 ; kaj < vertices ; kaj ++ ) totalArestas += adjacencia [ kaj ] . size ();
            
            // Array para armazenar todas as arestas do grafo
            Aresta [] arestas = new Aresta [ totalArestas ];
            
            // Criação e preenchimento do array de arestas
            int index = 0;
            for ( int kaj = 0 ; kaj < vertices ; kaj ++ ) for ( Aresta aresta : adjacencia [ kaj ] )
               arestas [ index ++ ] = aresta;
            
            // Ordenação das arestas por peso
            Arrays . sort ( arestas , Comparator . comparingInt ( Aresta :: get_peso ) );
            
            // Aplicação do algoritmo de Kruskal
            int kaj = 0 , jak = 0;
            while ( ( kaj < vertices - 1 ) && ( jak < arestas.length ) )
            {
                 // Obtém a próxima aresta do array ordenado
                 Aresta aresta = arestas [ jak ++ ];
                  
                  // Encontra o conjunto que contém a origem da aresta e o que contém o destino
                 int x = busca ( parente , aresta . get_origem () );
                 int y = busca ( parente , aresta . get_destino () );
                  
                 // Verifica se a inclusão da aresta não forma ciclo
                 if ( x != y ) { resultado [ kaj ++ ] = aresta; union ( parente , x , y ); }
            }
            
            // Print do metódo
            debug_printarMST_Kruskal ( resultado );
      }
      
      // Método da aplicação do algoritmo de Prim para encontrar o MST do grafo
      public void execMST_Prim ()
      {
            // Array para armazenar o pai de cada vértice na MST, um para armazenar o custo mínimo de cada vértice
            // e um para acompanhar se o vértice está incluso na MST
            int [] pai = new int [ vertices ];
            int [] chave = new int [ vertices ];
            boolean [] incluso_emMST = new boolean [ vertices];
            
            // Inicialização dos arrays chave e pai
            for ( int kaj = 0 ; kaj < vertices ; kaj ++ ) { chave [ kaj ] = Integer . MAX_VALUE; pai [ kaj ] = -1; }
            
            // O vértice inicial é escolhido arbitrariamente como o primeiro vértice
            chave [ 0 ] = 0;
            
            // Construção da MST
            for ( int count = 0 ; count < vertices - 1 ; count ++ )
            {
               // Encontre o vértice de chave mínima que ainda não está incluso na MST
               int u = chaveMinima ( chave , incluso_emMST );
                  
               // Marque o vértice como incluso na MST
               incluso_emMST[u] = true;
                  
               // Atualize os valores de chave e pai dos vértices adjacentes ao vértice escolhido
               for ( Aresta aresta : adjacencia [ u ] )
               {
                  int v = aresta.get_destino();
                  int peso = aresta.get_peso();
                  
                  if ( !incluso_emMST [ v ] && peso < chave [ v ] ) { pai [ v ] = u; chave [ v ] = peso; }
               }
            }
            
            // Imprimir a MST gerada pelo algoritmo de Prim
            debug_printarMST_Prim ( pai , adjacencia );
      }
      
      // Metódo para encontrar a chave mínima
      public int chaveMinima ( int [] _chave , boolean [] incluso_emMST )
      {
            int minima = Integer . MAX_VALUE , indice_minima = -1;
            
            for ( int kaj = 0 ; kaj < vertices ; kaj ++ ) if ( ( !incluso_emMST [ kaj ] ) && ( _chave [ kaj ] < minima ) )
            {
                  minima = _chave [ kaj ];
                  indice_minima = kaj;
            }
            
            return indice_minima;
      }
      
      // Metódo para listar todas as arestas já inseridas
      public void mostrar_Arestas ()
      {
            System . out . println ( "\n* LISTA DE ARESTAS DO GRAFO ATUAL *" );
            for ( int kaj = 0 ; kaj < vertices ; kaj ++ ) for ( Aresta aresta : adjacencia [ kaj ] )
                  System . out . println ( "[ " + aresta . get_origem () + " --> " + aresta . get_destino () + ": " + aresta . get_peso () + " ]" );
      }
}
